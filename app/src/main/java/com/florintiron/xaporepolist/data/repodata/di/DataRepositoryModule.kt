package com.florintiron.xaporepolist.data.repodata.di

import com.florintiron.xaporepolist.data.remote.di.ServiceControllerModule
import com.florintiron.xaporepolist.data.remote.github.di.GitHubServiceModule
import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.repodata.GitHubRepoRepository
import com.florintiron.xaporepolist.data.repodata.GitHubRepoRepositoryImpl
import com.florintiron.xaporepolist.data.repodata.search.GitHubSearchRepoDataSource
import com.florintiron.xaporepolist.mapper.ListMapper
import com.florintiron.xaporepolist.presentation.list.RepoListItemModel
import dagger.Module
import dagger.Provides

/**
 * Created by Florin Tiron on 05/10/2020.
 */

@Module(
    includes = [
        GitHubServiceModule::class,
        ServiceControllerModule::class,
        DataSourceModule::class]
)
class DataRepositoryModule {

    @Provides
    fun provideGithubSearchRepository(
        gitHubSearchRepoDataSource: GitHubSearchRepoDataSource,
        mapper: ListMapper<RepositoryRemote, RepoListItemModel>
    )
            : GitHubRepoRepository<RepoListItemModel> {

        return GitHubRepoRepositoryImpl(
            gitHubSearchRepoDataSource,
            mapper
        )
    }

}