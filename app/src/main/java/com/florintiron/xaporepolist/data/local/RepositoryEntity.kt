package com.florintiron.xaporepolist.data.local

/**
 * Created by Florin Tiron on 05/10/2020.
 */
data class RepositoryEntity(
    val id: Int,
    val name: String,
    val htmlUrl: String,
    val description: String?,
    val createdAt: String,
    val updatedAt: String,
    val stargazersCount: Int,
    val watchersCount: Int,
    val language: String
)