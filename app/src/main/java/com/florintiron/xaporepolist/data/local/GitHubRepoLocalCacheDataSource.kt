package com.florintiron.xaporepolist.data.local

import com.florintiron.xaporepolist.data.util.DataResult
import javax.inject.Inject

/**
 * Created by Florin Tiron on 05/10/2020.
 */

class GitHubRepoLocalCacheDataSource @Inject constructor() :
    GitHubRepoLocalDataSource {

    var repoList: List<RepositoryEntity>? = null

    override suspend fun getRepositories(): DataResult<List<RepositoryEntity>> {
        return repoList?.let {
            DataResult.Success(it)
        } ?: DataResult.Error(LocalDataException.Empty)

    }


    override suspend fun saveRepositories(data: List<RepositoryEntity>) {
        repoList = data
    }

}