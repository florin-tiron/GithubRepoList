package com.florintiron.xaporepolist.presentation.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.florintiron.xaporepolist.data.repodata.GitHubRepoRepository
import com.florintiron.xaporepolist.data.util.DataResult
import com.florintiron.xaporepolist.util.TestCoroutineRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by Florin Tiron on 06/10/2020.
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ListRepoViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var listRepoViewModel: ListRepoViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var gitHubRepoRepository: GitHubRepoRepository<RepoListItemModel>

    @Mock
    private lateinit var listRepoObserver: Observer<List<RepoListItemModel>>

    @Mock
    private lateinit var isLoadingObserver: Observer<Boolean>

    @Mock
    private lateinit var errorMessageObserver: Observer<String>

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        listRepoViewModel = ListRepoViewModel(gitHubRepoRepository)
        listRepoViewModel.repoList.observeForever(listRepoObserver)
        listRepoViewModel.isLoading.observeForever(isLoadingObserver)
        listRepoViewModel.errorMessage.observeForever(errorMessageObserver)

    }


    @Test
    fun loadList_success_showList() {
        val repoList = arrayListOf<RepoListItemModel>(
            RepoListItemModel("100", "repo1"),
            RepoListItemModel("200", "repo2")
        )
        val dataResult = DataResult.Success<List<RepoListItemModel>>(repoList)
        val loadingArgumentCaptor = ArgumentCaptor.forClass(Boolean::class.java)

        testCoroutineRule.runBlockingTest {
            doReturn(dataResult)
                .`when`(gitHubRepoRepository)
                .getRepositories(any())

            listRepoViewModel.loadList()

            verify(listRepoObserver).onChanged(dataResult.data)
            verify(isLoadingObserver, times(3)).onChanged(loadingArgumentCaptor.capture())
            assert(loadingArgumentCaptor.allValues[0] == false)
            assert(loadingArgumentCaptor.allValues[1] == true)
            assert(loadingArgumentCaptor.allValues[2] == false)
        }
    }

    @Test
    fun loadList_error_showErrorMessage() {

        val message = "Unknown error"
        val dataResult = DataResult.Error(Exception(message))
        val loadingArgumentCaptor = ArgumentCaptor.forClass(Boolean::class.java)

        testCoroutineRule.runBlockingTest {
            doReturn(dataResult)
                .`when`(gitHubRepoRepository)
                .getRepositories(any())

            listRepoViewModel.loadList()

            verify(isLoadingObserver, times(3)).onChanged(loadingArgumentCaptor.capture())
            assert(loadingArgumentCaptor.allValues[0] == false)
            assert(loadingArgumentCaptor.allValues[1] == true)
            assert(loadingArgumentCaptor.allValues[2] == false)
            verify(errorMessageObserver).onChanged(message)
        }
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}