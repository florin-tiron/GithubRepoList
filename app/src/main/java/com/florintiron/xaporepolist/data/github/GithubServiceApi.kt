package com.florintiron.xaporepolist.data.github

import com.florintiron.xaporepolist.data.github.model.Repository
import com.florintiron.xaporepolist.data.github.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Florin Tiron on 04/10/2020.
 */
interface GithubServiceApi {

    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") queryText: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") resultsPerPage: Int? = null,
        @Query("page") page: Int? = null
    ): Response<SearchResponse<Repository>>

}

