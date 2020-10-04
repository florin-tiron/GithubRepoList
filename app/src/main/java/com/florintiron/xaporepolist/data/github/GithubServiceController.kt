package com.florintiron.xaporepolist.data.github

import com.florintiron.xaporepolist.data.github.model.SearchRepositoriesResponse
import retrofit2.Response

/**
 * Created by Florin Tiron on 04/10/2020.
 */

interface GithubServiceController {

    suspend fun getRepositoryList(
        query: String,
        sort: Sort?,
        sortOrder: Order?,
        pageNumber: Int?
    ): Response<SearchRepositoriesResponse>

}


enum class Sort(type: String) {
    STARS("stars"),
    FORKS("forks"),
    HELP_WANTED("help-wanted-issues"),
    RECENT_UPDATES("updates")
}

enum class Order(type: String) {
    ASCENDING("asc"), DESCENDING("dsc")
}