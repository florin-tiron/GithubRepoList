package com.florintiron.xaporepolist.data.local

import com.florintiron.xaporepolist.data.util.DataResult

/**
 * Created by Florin Tiron on 05/10/2020.
 */

interface GitHubRepoLocalDataSource {

    suspend fun getRepositories(): DataResult<List<RepositoryEntity>>
    suspend fun saveRepositories(list: List<RepositoryEntity>)
}