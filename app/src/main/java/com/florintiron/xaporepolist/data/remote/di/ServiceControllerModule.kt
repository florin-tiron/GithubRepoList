package com.florintiron.xaporepolist.data.remote.di

import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceApi
import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceController
import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceControllerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Florin Tiron on 05/10/2020.
 */
@Module
class ServiceControllerModule {


    @Provides
    @Singleton
    fun provideGitHubServiceController(githubServiceApi: GithubServiceApi): GithubServiceController {
        return GithubServiceControllerImpl(githubServiceApi)
    }
}