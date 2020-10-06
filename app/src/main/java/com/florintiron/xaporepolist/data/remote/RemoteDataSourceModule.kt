package com.florintiron.xaporepolist.data.remote

import com.florintiron.xaporepolist.data.remote.github.datasource.GitHubRepoRemoteDataSourceFactory
import com.florintiron.xaporepolist.data.remote.github.datasource.GitHubRepoRemoteDataSourceFactoryImpl
import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceController
import dagger.Module
import dagger.Provides

/**
 * Created by Florin Tiron on 06/10/2020.
 */
@Module
class RemoteDataSourceModule {

    @Provides
    fun provideGitHubRepoRemoteDataSourceFactory(githubServiceController: GithubServiceController)
            : GitHubRepoRemoteDataSourceFactory {
        return GitHubRepoRemoteDataSourceFactoryImpl(githubServiceController)
    }

}