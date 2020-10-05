package com.florintiron.xaporepolist.data.local

import com.florintiron.xaporepolist.data.remote.github.model.Owner

/**
 * Created by Florin Tiron on 05/10/2020.
 */
data class RepositoryEntity(
    val id: Int,
    val name: String,
    val fullName: String,
    val owner: Owner,
    val isPrivate: Boolean,
    val htmlUrl: String,
    val description: String,
    val fork: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val stargazersCount: Int,
    val watchersCount: Int,
    val language: String
)