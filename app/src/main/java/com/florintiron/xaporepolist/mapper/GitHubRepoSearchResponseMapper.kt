package com.florintiron.xaporepolist.mapper

import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.presentation.list.RepoListItemModel

/**
 * Created by Florin Tiron on 04/10/2020.
 */
class GitHubRepoSearchResponseMapper :
    ListMapper<RepositoryRemote, RepoListItemModel> {

    override fun map(input: List<RepositoryRemote>?): List<RepoListItemModel> {
        return input?.map {
            RepoListItemModel(it.id.toString(), it.name)
        } ?: arrayListOf()
    }
}