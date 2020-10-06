package com.florintiron.xaporepolist.mapper

import com.florintiron.xaporepolist.data.local.RepositoryEntity
import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.presentation.details.RepoDetailsModel
import com.florintiron.xaporepolist.presentation.list.RepoListItemModel
import dagger.Module
import dagger.Provides

/**
 * Created by Florin Tiron on 05/10/2020.
 */

@Module
class DataMapperModule {

    @Provides
    fun provideRepoLocalMapper(): Mapper<RepositoryRemote, RepositoryEntity> {
        return GitHubRepoLocalMapper()
    }

    @Provides
    fun provideListRepoDomainLocalMapper(): Mapper<RepositoryEntity, RepoListItemModel> {
        return GitHubRepoListDomainMapper()
    }

    @Provides
    fun provideRepoDetailsDomainLocalMapper(): Mapper<RepositoryEntity, RepoDetailsModel> {
        return GitHubRepoDetailsDomainMapper()
    }
}