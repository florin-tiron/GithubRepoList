package com.florintiron.repolist.data.remote.github.model

/**
 * Created by Florin Tiron on 04/10/2020.
 */

data class SearchResponse<T>(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<T>?
)
