package com.florintiron.xaporepolist.data.github

import com.florintiron.xaporepolist.data.github.model.Repository
import com.florintiron.xaporepolist.data.github.model.SearchResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Florin Tiron on 04/10/2020.
 */

private const val RESULT_PER_PAGE_LIMIT = 100

class GithubServiceControllerImpl @Inject constructor(
    private val githubServiceApi: GithubServiceApi
) :
    GithubServiceController {


    override suspend fun getRepositoryList(
        query: String,
        sort: Sort?,
        sortOrder: Order?,
        pageNumber: Int?
    ): Response<SearchResponse<Repository>> {
        return githubServiceApi.searchRepositories(
            queryText = query,
            sort = sort?.name,
            order = sortOrder?.name,
            resultsPerPage = RESULT_PER_PAGE_LIMIT,
            page = pageNumber
        )
    }


}