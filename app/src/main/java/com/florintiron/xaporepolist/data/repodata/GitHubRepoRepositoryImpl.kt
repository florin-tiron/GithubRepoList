package com.florintiron.xaporepolist.data.repodata

import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.repodata.search.GitHubSearchRepoDataSource
import com.florintiron.xaporepolist.data.util.DataResult
import com.florintiron.xaporepolist.mapper.ListMapper

/**
 * Created by Florin Tiron on 04/10/2020.
 */

class GitHubRepoRepositoryImpl<R> constructor(
    val remoteDateSource: GitHubSearchRepoDataSource,
    val mapper: ListMapper<RepositoryRemote, R>
) : GitHubRepoRepository<R> {


    override suspend fun getRepositories(page: Int): DataResult<List<R>> {
        val result = remoteDateSource.genTrendingKotlinRepositories(page)
        return try {
            when (result) {
                is DataResult.Success -> {
                    DataResult.Success(mapper.map(result.data.items))
                }
                is DataResult.Error -> {
                    DataResult.Error(Exception("Unable to get data"))
                }
            }
        } catch (ex: Exception) {
            return DataResult.Error(ex)
        }
    }


}