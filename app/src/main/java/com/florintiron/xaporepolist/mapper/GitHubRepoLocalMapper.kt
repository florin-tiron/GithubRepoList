package com.florintiron.xaporepolist.mapper

import com.florintiron.xaporepolist.data.local.RepositoryEntity
import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote

/**
 * Created by Florin Tiron on 05/10/2020.
 */
class GitHubRepoLocalMapper :
    Mapper<RepositoryRemote, RepositoryEntity> {

    override fun map(input: RepositoryRemote): RepositoryEntity {
        return RepositoryEntity(
            input.id,
            input.name,
            input.html_url,
            input.description,
            input.created_at,
            input.updated_at,
            input.stargazers_count,
            input.watchers_count,
            input.language
        )
    }

    override fun mapList(input: List<RepositoryRemote>?): List<RepositoryEntity> {
        return input?.map {
            map(it)
        } ?: arrayListOf()
    }
}