package com.florintiron.repolist.data.repodata.di

import com.florintiron.repolist.data.local.GitHubRepoLocalDataSource
import com.florintiron.repolist.data.local.LocalDataSourceModule
import com.florintiron.repolist.data.local.RepositoryEntity
import com.florintiron.repolist.data.remote.RemoteDataSourceModule
import com.florintiron.repolist.data.remote.di.ServiceControllerModule
import com.florintiron.repolist.data.remote.github.datasource.GitHubRepoRemoteDataSourceFactory
import com.florintiron.repolist.data.remote.github.di.GitHubServiceModule
import com.florintiron.repolist.data.remote.github.model.RepositoryRemote
import com.florintiron.repolist.data.repodata.GitHubRepoRepository
import com.florintiron.repolist.data.repodata.GitHubRepoRepositoryImpl
import com.florintiron.repolist.mapper.Mapper
import com.florintiron.repolist.presentation.details.RepoDetailsModel
import com.florintiron.repolist.presentation.list.RepoListItemModel
import dagger.Module
import dagger.Provides

/**
 * Created by Florin Tiron on 05/10/2020.
 */

@Module(
    includes = [
        GitHubServiceModule::class,
        ServiceControllerModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class]
)
class DataRepositoryModule {

    @Provides
    fun provideGithubRepoListRepository(
        gitHubRepoLocalDataSource: GitHubRepoLocalDataSource,
        gitHubRepoRemoteDataSourceFactory: GitHubRepoRemoteDataSourceFactory,
        localMapper: Mapper<RepositoryRemote, RepositoryEntity>,
        domainMapper: Mapper<RepositoryEntity, RepoListItemModel>
    )
            : GitHubRepoRepository<RepoListItemModel> {

        return GitHubRepoRepositoryImpl(
            gitHubRepoLocalDataSource,
            gitHubRepoRemoteDataSourceFactory,
            localMapper,
            domainMapper
        )
    }

    @Provides
    fun provideGithubRepoDetailsRepository(
        gitHubRepoLocalDataSource: GitHubRepoLocalDataSource,
        gitHubRepoRemoteDataSourceFactory: GitHubRepoRemoteDataSourceFactory,
        localMapper: Mapper<RepositoryRemote, RepositoryEntity>,
        domainMapper: Mapper<RepositoryEntity, RepoDetailsModel>
    )
            : GitHubRepoRepository<RepoDetailsModel> {

        return GitHubRepoRepositoryImpl(
            gitHubRepoLocalDataSource,
            gitHubRepoRemoteDataSourceFactory,
            localMapper,
            domainMapper
        )
    }

}