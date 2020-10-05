package com.florintiron.xaporepolist.data.remote

import com.florintiron.xaporepolist.data.remote.exception.RemoteDataException
import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.remote.github.model.SearchResponse
import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceController
import com.florintiron.xaporepolist.data.remote.github.service.Order
import com.florintiron.xaporepolist.data.remote.github.service.Sort
import com.florintiron.xaporepolist.data.util.DataResult


/**
 * Created by Florin Tiron on 04/10/2020.
 */

class GitHubTrendingRemoteRemoteDataSource(private val githubApiServiceController: GithubServiceController) :
    GitHubRepoRemoteDataSource {

    override suspend fun getRepositories(): DataResult<SearchResponse<RepositoryRemote>> {

        val response = githubApiServiceController.getRepositoryList(
            QUERY_TEXT,
            Sort.STARS,
            Order.DESCENDING,
            RETURNED_RESULTS,
            FIRST_PAGE
        )

        return if (response.isSuccessful) {
            val successResponse =
                response.body() ?: throw RemoteDataException.ResponseError("Response is null")
            DataResult.Success(successResponse)
        } else {
            DataResult.Error(RemoteDataException.ServerError(response.code()))
        }
    }


    companion object {
        private const val QUERY_TEXT = "language:kotlin"
        private const val RETURNED_RESULTS = 100
        private const val FIRST_PAGE = 1

    }

}