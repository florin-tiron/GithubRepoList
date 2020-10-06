package com.florintiron.xaporepolist.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.florintiron.xaporepolist.data.remote.github.datasource.Source
import com.florintiron.xaporepolist.data.repodata.GitHubRepoRepository
import com.florintiron.xaporepolist.data.util.DataResult
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Florin Tiron on 04/10/2020.
 */

private const val REPOSITORY_LANGUAGE = "kotlin"

class ListRepoViewModel @Inject constructor(
    private val gitHubRepoRepository: GitHubRepoRepository<RepoListItemModel>
) : ViewModel() {

    private val _repoList = MutableLiveData<List<RepoListItemModel>>()
    val repoList: LiveData<List<RepoListItemModel>> = _repoList

    private val _isLoading = MutableLiveData(true)
    val isLoadingData: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage


    fun loadList() {
        _isLoading.value = true

        viewModelScope.launch {
            when (val result =
                gitHubRepoRepository.getRepositories(Source.Trending.Weekly(REPOSITORY_LANGUAGE))) {
                is DataResult.Success -> {
                    handleDataRetrieveSuccess(result.data)
                }
                is DataResult.Error -> {
                    handleDataRetrieveError(result.exception)
                }
            }
            _isLoading.value = false
        }
    }

    private fun handleDataRetrieveSuccess(itemList: List<RepoListItemModel>) {
        _repoList.value = itemList
    }

    private fun handleDataRetrieveError(exception: Exception) {
        _errorMessage.value = exception.message
    }
}