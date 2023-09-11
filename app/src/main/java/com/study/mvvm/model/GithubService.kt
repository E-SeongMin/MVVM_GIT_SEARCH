package com.study.mvvm.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{owner}")
    fun getUser(@Path("owner") owner: String) : Call<GithubUser>
}