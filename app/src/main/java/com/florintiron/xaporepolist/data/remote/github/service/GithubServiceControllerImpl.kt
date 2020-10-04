package com.florintiron.xaporepolist.data.remote.github.service

import com.florintiron.xaporepolist.data.remote.github.model.RepositoryRemote
import com.florintiron.xaporepolist.data.remote.github.model.SearchResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Florin Tiron on 04/10/2020.
 */


class GithubServiceControllerImpl @Inject constructor(
    private val githubServiceApi: GithubServiceApi
) :
    GithubServiceController {


    override suspend fun getRepositoryList(
        query: String,
        sort: Sort?,
        sortOrder: Order?,
        resultPerPage: Int?,
        pageNumber: Int?
    ): Response<SearchResponse<RepositoryRemote>> {
        return githubServiceApi.searchRepositories(
            queryText = query,
            sort = sort?.name,
            order = sortOrder?.name,
            resultsPerPage = resultPerPage,
            page = pageNumber
        )
    }


}