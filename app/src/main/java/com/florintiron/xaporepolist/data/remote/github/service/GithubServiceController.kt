package com.florintiron.xaporepolist.data.remote.github.service

import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.remote.github.model.SearchResponse
import retrofit2.Response

/**
 * Created by Florin Tiron on 04/10/2020.
 */

interface GithubServiceController {

    suspend fun getRepositoryList(
        query: String,
        sort: Sort?,
        sortOrder: Order?,
        resultPerPage: Int?,
        pageNumber: Int?
    ): Response<SearchResponse<RepositoryRemote>>

}


enum class Sort(val type: String) {
    STARS("stars"),
    FORKS("forks"),
    HELP_WANTED("help-wanted-issues"),
    RECENT_UPDATES("updates")
}

enum class Order(val type: String) {
    ASCENDING("asc"), DESCENDING("dsc")
}