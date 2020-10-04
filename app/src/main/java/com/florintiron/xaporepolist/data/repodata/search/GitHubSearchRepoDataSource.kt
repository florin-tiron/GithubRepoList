package com.florintiron.xaporepolist.data.repodata.search

import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.remote.github.model.SearchResponse
import com.florintiron.xaporepolist.data.util.DataResult

/**
 * Created by Florin Tiron on 04/10/2020.
 */
interface GitHubSearchRepoDataSource {
    suspend fun genTrendingKotlinRepositories(page: Int?): DataResult<SearchResponse<RepositoryRemote>>
}