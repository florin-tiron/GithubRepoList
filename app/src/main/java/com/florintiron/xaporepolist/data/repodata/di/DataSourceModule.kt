package com.florintiron.xaporepolist.data.repodata.di

import com.florintiron.xaporepolist.data.remote.GitHubRepoRemoteDataSource
import com.florintiron.xaporepolist.data.remote.GitHubTrendingRemoteRemoteDataSource
import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceController
import dagger.Module
import dagger.Provides

/**
 * Created by Florin Tiron on 05/10/2020.
 */
@Module
class DataSourceModule {


    @Provides
    fun providesGitHubTrendingRemoteDataSource(githubServiceController: GithubServiceController): GitHubRepoRemoteDataSource {
        return GitHubTrendingRemoteRemoteDataSource(githubServiceController)
    }

}