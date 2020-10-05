package com.florintiron.xaporepolist.data.repodata

import com.florintiron.xaporepolist.data.util.DataResult

/**
 * Created by Florin Tiron on 04/10/2020.
 */
interface GitHubRepoRepository<R> {
    suspend fun getRepositories(): DataResult<List<R>>
    suspend fun getDetailedRepository(id: Int): DataResult<R>
}