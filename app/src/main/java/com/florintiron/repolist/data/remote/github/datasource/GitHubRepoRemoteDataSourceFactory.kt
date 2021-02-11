package com.florintiron.repolist.data.remote.github.datasource

/**
 * Created by Florin Tiron on 06/10/2020.
 */

interface GitHubRepoRemoteDataSourceFactory {

    fun create(source: Source): GitHubRepoRemoteDataSource
}