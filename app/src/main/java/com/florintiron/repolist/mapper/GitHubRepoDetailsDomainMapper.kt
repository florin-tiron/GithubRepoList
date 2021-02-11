package com.florintiron.repolist.mapper

import com.florintiron.repolist.data.local.RepositoryEntity
import com.florintiron.repolist.presentation.details.RepoDetailsModel

/**
 * Created by Florin Tiron on 04/10/2020.
 */

private const val NOT_AVAILABLE_DESCRIPTION_VALUE = "N/A"

class GitHubRepoDetailsDomainMapper :
    Mapper<RepositoryEntity, RepoDetailsModel> {

    override fun map(input: RepositoryEntity): RepoDetailsModel {
        return RepoDetailsModel(
            input.id.toString(),
            input.name,
            input.description ?: NOT_AVAILABLE_DESCRIPTION_VALUE,
            input.htmlUrl,
            input.createdAt,
            input.issueCount > 0,
            input.owner.name,
            input.stargazersCount
        )
    }

    override fun mapList(input: List<RepositoryEntity>?): List<RepoDetailsModel> {
        return input?.map {
            map(it)
        } ?: arrayListOf()
    }
}