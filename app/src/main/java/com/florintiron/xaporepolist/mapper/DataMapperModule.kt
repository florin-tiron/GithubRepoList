package com.florintiron.xaporepolist.mapper

import com.florintiron.xaporepolist.data.local.RepositoryEntity
import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.presentation.list.RepoListItemModel
import dagger.Module
import dagger.Provides

/**
 * Created by Florin Tiron on 05/10/2020.
 */

@Module
class DataMapperModule {

    @Provides
    fun provideDomainLocalMapper(): Mapper<RepositoryEntity, RepoListItemModel> {
        return GitHubRepoDomainMapper()
    }

    @Provides
    fun provideRepoLocalMapper(): Mapper<RepositoryRemote, RepositoryEntity> {
        return GitHubRepoLocalMapper()
    }
}