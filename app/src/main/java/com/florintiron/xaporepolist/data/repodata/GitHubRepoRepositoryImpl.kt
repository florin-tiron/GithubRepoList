package com.florintiron.xaporepolist.data.repodata

import com.florintiron.xaporepolist.data.local.GitHubRepoLocalDataSource
import com.florintiron.xaporepolist.data.local.RepositoryEntity
import com.florintiron.xaporepolist.data.remote.GitHubRepoRemoteDataSource
import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.util.DataResult
import com.florintiron.xaporepolist.mapper.Mapper

/**
 * Created by Florin Tiron on 04/10/2020.
 */

class GitHubRepoRepositoryImpl<R> constructor(
    private val localDataSource: GitHubRepoLocalDataSource,
    private val remoteDateSource: GitHubRepoRemoteDataSource,
    private val localMapper: Mapper<RepositoryRemote, RepositoryEntity>,
    private val domainMapper: Mapper<RepositoryEntity, R>
) : GitHubRepoRepository<R> {


    override suspend fun getRepositories(): DataResult<List<R>> {
        return try {
            when (val result = remoteDateSource.getRepositories()) {
                is DataResult.Success -> {
                    val localList = localMapper.mapList(result.data.items)
                    localDataSource.saveRepositories(localList)
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

    override suspend fun getDetailedRepository(id: Int): DataResult<R> {
        return try {
            when (val result = localDataSource.getRepositories()) {
                is DataResult.Success -> {
                    val entity = result.data.firstOrNull {
                        it.id == id
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