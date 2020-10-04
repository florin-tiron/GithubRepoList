package com.florintiron.xaporepolist.data.github.model

/**
 * Created by Florin Tiron on 04/10/2020.
 */

data class SearchRepositoriesResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<Repository>
)
