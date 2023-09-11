package com.study.mvvm.model

import com.google.gson.GsonBuilder
import com.study.mvvm.Const.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubObject {
    private val gson = GsonBuilder().setLenient().create()
    private val okHttp = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(okHttp).addConverterFactory(GsonConverterFactory.create(gson)).build()

    val githubService: GithubService = retrofit.create(GithubService::class.java)
}