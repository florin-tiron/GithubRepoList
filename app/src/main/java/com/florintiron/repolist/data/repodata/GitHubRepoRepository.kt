package com.florintiron.repolist.data.repodata

import com.florintiron.repolist.data.remote.github.datasource.Source
import com.florintiron.repolist.data.util.DataResult

/**
 * Created by Florin Tiron on 04/10/2020.
 */
interface GitHubRepoRepository<R> {
    suspend fun getRepositories(source: Source): DataResult<List<R>>
    suspend fun getDetailedRepository(id: String): DataResult<R>
}