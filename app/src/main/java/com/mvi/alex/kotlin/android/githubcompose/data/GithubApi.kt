package com.mvi.alex.kotlin.android.githubcompose.data

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET(Endpoints.GET_USERS)
    suspend fun getUsers(): List<com.mvi.alex.kotlin.android.githubcompose.data.model.User>

    @GET(Endpoints.GET_USER)
    suspend fun getUser(@Path("userLogin") userId: String): com.mvi.alex.kotlin.android.githubcompose.data.model.UserDetail?

    @GET(Endpoints.GET_REPOS_BY_USER)
    suspend fun getRepos(@Path("userLogin") userId: String): List<com.mvi.alex.kotlin.android.githubcompose.data.model.Repo>
}
