package com.florintiron.repolist.mapper

import com.florintiron.repolist.data.local.RepositoryEntity
import com.florintiron.repolist.presentation.list.RepoListItemModel

/**
 * Created by Florin Tiron on 04/10/2020.
 */
class GitHubRepoListDomainMapper :
    Mapper<RepositoryEntity, RepoListItemModel> {

    override fun map(input: RepositoryEntity): RepoListItemModel {
        return RepoListItemModel(input.id.toString(), input.name)
    }

    override fun mapList(input: List<RepositoryEntity>?): List<RepoListItemModel> {
        return input?.map {
            map(it)
        } ?: arrayListOf()
    }
}