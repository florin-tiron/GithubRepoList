package com.florintiron.xaporepolist.data.local

import com.florintiron.xaporepolist.data.util.DataResult

/**
 * Created by Florin Tiron on 05/10/2020.
 */

interface GitHubRepoLocalDataSource {

    suspend fun getGitHubRepos(): DataResult<List<RepositoryEntity>>
    suspend fun saveGitHubRepos(list: List<RepositoryEntity>)
}