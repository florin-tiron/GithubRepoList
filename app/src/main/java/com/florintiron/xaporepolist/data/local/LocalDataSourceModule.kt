package com.florintiron.xaporepolist.data.local

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Florin Tiron on 05/10/2020.
 */
@Module
class LocalDataSourceModule {


    @Provides
    @Singleton
    fun providesGitHubTrendingLocalDataSource(): GitHubRepoLocalDataSource {
        return GitHubRepoLocalCacheDataSource()
    }
}