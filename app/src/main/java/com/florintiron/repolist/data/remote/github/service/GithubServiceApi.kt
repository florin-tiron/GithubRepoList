package com.florintiron.repolist.data.remote.github.service

import com.florintiron.repolist.data.remote.github.model.RepositoryRemote
import com.florintiron.repolist.data.remote.github.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Florin Tiron on 04/10/2020.
 */
interface GithubServiceApi {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") queryText: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") resultsPerPage: Int? = null,
        @Query("page") page: Int? = null
    ): Response<SearchResponse<RepositoryRemote>>

}

