package com.florintiron.xaporepolist.data.remote

import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.remote.github.model.SearchResponse
import com.florintiron.xaporepolist.data.util.DataResult

/**
 * Created by Florin Tiron on 04/10/2020.
 */
interface GitHubRepoRemoteDataSource {
    suspend fun getRepositories(): DataResult<SearchResponse<RepositoryRemote>>
}