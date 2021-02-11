package com.florintiron.repolist.data.remote.github.datasource

import com.florintiron.repolist.data.remote.github.model.RepositoryRemote
import com.florintiron.repolist.data.remote.github.model.SearchResponse
import com.florintiron.repolist.data.util.DataResult

/**
 * Created by Florin Tiron on 04/10/2020.
 */
interface GitHubRepoRemoteDataSource {
    suspend fun getRepositories(): DataResult<SearchResponse<RepositoryRemote>>
}