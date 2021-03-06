package com.florintiron.repolist.data.local

import com.florintiron.repolist.data.util.DataResult
import javax.inject.Inject

/**
 * Created by Florin Tiron on 05/10/2020.
 */

class GitHubRepoLocalCacheDataSource @Inject constructor() :
    GitHubRepoLocalDataSource {

    var repoList: List<RepositoryEntity>? = null

    override suspend fun getGitHubRepos(): DataResult<List<RepositoryEntity>> {
        return repoList?.let {
            DataResult.Success(it)
        } ?: DataResult.Error(LocalDataException.Empty)

    }


    override suspend fun saveGitHubRepos(data: List<RepositoryEntity>) {
        repoList = data
    }

}