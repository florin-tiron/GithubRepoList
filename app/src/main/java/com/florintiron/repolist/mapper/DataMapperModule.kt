package com.florintiron.repolist.mapper

import com.florintiron.repolist.data.local.RepositoryEntity
import com.florintiron.repolist.data.remote.github.model.RepositoryRemote
import com.florintiron.repolist.presentation.details.RepoDetailsModel
import com.florintiron.repolist.presentation.list.RepoListItemModel
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