package com.florintiron.repolist.data.repodata

import com.florintiron.repolist.data.local.GitHubRepoLocalDataSource
import com.florintiron.repolist.data.local.RepositoryEntity
import com.florintiron.repolist.data.remote.github.datasource.GitHubRepoRemoteDataSourceFactory
import com.florintiron.repolist.data.remote.github.datasource.Source
import com.florintiron.repolist.data.remote.github.model.RepositoryRemote
import com.florintiron.repolist.data.util.DataResult
import com.florintiron.repolist.mapper.Mapper

/**
 * Created by Florin Tiron on 04/10/2020.
 */

class GitHubRepoRepositoryImpl<R> constructor(
    private val localDataSource: GitHubRepoLocalDataSource,
    private val remoteDateSourceFactory: GitHubRepoRemoteDataSourceFactory,
    private val localMapper: Mapper<RepositoryRemote, RepositoryEntity>,
    private val domainMapper: Mapper<RepositoryEntity, R>
) : GitHubRepoRepository<R> {


    override suspend fun getRepositories(source: Source): DataResult<List<R>> {
        return try {
            when (val result = remoteDateSourceFactory.create(source).getRepositories()) {
                is DataResult.Success -> {
                    val localList = localMapper.mapList(result.data.items)
                    localDataSource.saveGitHubRepos(localList)
                    DataResult.Success(domainMapper.mapList(localList))
                }
                is DataResult.Error -> {
                    DataResult.Error(Exception("Unable to get data"))
                }
            }
        } catch (ex: Exception) {
            return DataResult.Error(ex)
        }
    }

    override suspend fun getDetailedRepository(id: String): DataResult<R> {
        return try {
            when (val result = localDataSource.getGitHubRepos()) {
                is DataResult.Success -> {
                    val entity = result.data.firstOrNull {
                        it.id == id.toInt()
                    }
                    entity?.let {
                        DataResult.Success(domainMapper.map(it))
                    } ?: DataResult.Error(Exception("Repository for id: $id not found"))
                }
                is DataResult.Error -> {
                    DataResult.Error(Exception("Unable to get data"))
                }
            }
        } catch (ex: Exception) {
            return DataResult.Error(ex)
        }
    }

}

