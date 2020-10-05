package com.florintiron.xaporepolist.data.repodata.di

import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceController
import com.florintiron.xaporepolist.data.repodata.search.GitHubSearchRepoDataSource
import com.florintiron.xaporepolist.data.repodata.search.GitHubTrendingRemoteDataSourceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Florin Tiron on 05/10/2020.
 */
@Module
class DataSourceModule {


    @Provides
    fun providesGitHubTrendingRemoteDataSource(githubServiceController: GithubServiceController): GitHubSearchRepoDataSource {
        return GitHubTrendingRemoteDataSourceImpl(githubServiceController)
    }

}