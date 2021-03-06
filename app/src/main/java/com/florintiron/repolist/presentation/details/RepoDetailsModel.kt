package com.florintiron.repolist.presentation.details

/**
 * Created by Florin Tiron on 05/10/2020.
 */
data class RepoDetailsModel(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val createdAt: String,
    val hasIssue: Boolean,
    val ownerName: String,
    val stars: Int
)