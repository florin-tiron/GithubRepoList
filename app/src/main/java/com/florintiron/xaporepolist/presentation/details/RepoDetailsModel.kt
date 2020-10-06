package com.florintiron.xaporepolist.presentation.details

/**
 * Created by Florin Tiron on 05/10/2020.
 */
data class RepoDetailsModel(
    val name: String,
    val description: String,
    val url: String,
    val createdAt: String,
    val hasIssue: Boolean,
    val ownerName: String,
)