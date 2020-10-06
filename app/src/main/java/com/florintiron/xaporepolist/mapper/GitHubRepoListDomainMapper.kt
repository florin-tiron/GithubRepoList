package com.florintiron.xaporepolist.mapper

import com.florintiron.xaporepolist.data.local.RepositoryEntity
import com.florintiron.xaporepolist.presentation.list.RepoListItemModel

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