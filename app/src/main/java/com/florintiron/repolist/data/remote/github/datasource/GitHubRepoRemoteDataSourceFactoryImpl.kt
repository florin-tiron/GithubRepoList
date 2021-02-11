package com.florintiron.repolist.data.remote.github.datasource

import com.florintiron.repolist.data.remote.github.service.GithubServiceController

/**
 * Created by Florin Tiron on 06/10/2020.
 */
class GitHubRepoRemoteDataSourceFactoryImpl(
    private val githubApiServiceController: GithubServiceController
) : GitHubRepoRemoteDataSourceFactory {

    override fun create(source: Source): GitHubRepoRemoteDataSource {
        when (source) {
            is Source.Trending -> {
                return GitHubTrendingRemoteRemoteDataSource(
                    githubApiServiceController,
                    source.queryText,
                    source.resultsCount
                )
            }
        }
    }
}





