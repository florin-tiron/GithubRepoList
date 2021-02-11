package com.florintiron.repolist.presentation.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.florintiron.repolist.data.repodata.GitHubRepoRepository
import com.florintiron.repolist.data.util.DataResult
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Florin Tiron on 04/10/2020.
 */

class RepoDetailsViewModel @Inject constructor(
    private val gitHubRepoRepository: GitHubRepoRepository<RepoDetailsModel>
) : ViewModel() {

    private val _repoDetails = MutableLiveData<RepoDetailsModel>()
    val repoDetails: LiveData<RepoDetailsModel> = _repoDetails


    fun getDetails(id: String) {
        viewModelScope.launch {
            when (val result = gitHubRepoRepository.getDetailedRepository(id)) {
                is DataResult.Success -> {
                    handleDataRetrieveSuccess(result.data)
                }
                is DataResult.Error -> {
                    handleDataRetrieveError(result.exception)
                }
            }
        }
    }

    private fun handleDataRetrieveSuccess(value: RepoDetailsModel) {
        _repoDetails.value = value
    }

    private fun handleDataRetrieveError(exception: Exception) {
        Log.e("RepoDetailsViewModel", "Error retrieving details: ${exception.message}", exception)
    }
}