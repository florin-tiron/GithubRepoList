package com.florintiron.xaporepolist.data.remote.github.di

import com.florintiron.xaporepolist.BuildConfig
import com.florintiron.xaporepolist.data.remote.github.service.GithubServiceApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Florin Tiron on 04/10/2020.
 */

const val GITHUB_API_URL = "https://api.github.com/"
const val HEADER_ACCEPT_KEY = "Accept"
const val HEADER_ACCEPT_VALUE = "application/vnd.github.v3+json"

@Module
class GitHubServiceModule {


    @Provides
    fun provideGitHubService(): GithubServiceApi {

        return Retrofit.Builder()
            .baseUrl(GITHUB_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
            .create(GithubServiceApi::class.java)
    }


    private fun getClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }

        val headerInterceptor =
            Interceptor { chain ->
                val request: Request =
                    chain.request().newBuilder()
                        .addHeader(HEADER_ACCEPT_KEY, HEADER_ACCEPT_VALUE).build()
                chain.proceed(request)
            }

        okHttpClientBuilder.addInterceptor(headerInterceptor)

        return okHttpClientBuilder.build()
    }
}