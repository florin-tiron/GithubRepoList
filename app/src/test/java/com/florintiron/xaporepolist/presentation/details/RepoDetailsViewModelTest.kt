package com.florintiron.xaporepolist.presentation.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.florintiron.xaporepolist.data.repodata.GitHubRepoRepository
import com.florintiron.xaporepolist.data.util.DataResult
import com.florintiron.xaporepolist.util.TestCoroutineRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
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
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Florin Tiron on 07/10/2020.
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RepoDetailsViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var repoDetailsViewModel: RepoDetailsViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var gitHubRepoRepository: GitHubRepoRepository<RepoDetailsModel>

    @Mock
    private lateinit var repoDetailModelObserver: Observer<RepoDetailsModel>

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repoDetailsViewModel = RepoDetailsViewModel(gitHubRepoRepository)
        repoDetailsViewModel.repoDetails.observeForever(repoDetailModelObserver)
    }


    @Test
    fun getDetails_success_showDetails() {
        val repoDetailsModel = RepoDetailsModel(
            "101001",
            "GitHub Repo",
            "A description",
            "https://github.com",
            "2020-10-05",
            false,
            "Martin Fowler",
            1000
        )
        val dataResult = DataResult.Success<RepoDetailsModel>(repoDetailsModel)

        testCoroutineRule.runBlockingTest {
            doReturn(dataResult)
                .`when`(gitHubRepoRepository)
                .getDetailedRepository(any())


            repoDetailsViewModel.getDetails("100")

            verify(repoDetailModelObserver).onChanged(dataResult.data)
        }
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}