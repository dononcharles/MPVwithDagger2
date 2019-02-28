package com.chaldrac.daggerlesson.api

import com.chaldrac.daggerlesson.models.cloud.ApiGithubUser
import com.chaldrac.daggerlesson.models.cloud.Heroes
import com.chaldrac.daggerlesson.models.cloud.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {

    @get : GET("test-mobile/iOS/json/test2.jsonm")
    val heroes : Observable<Heroes>

    @get : GET("search/issues?q=language:kotlin&order=desc&page=2&per_page=2")
    val gUsers : Observable<ApiGithubUser>

    @GET("users/{login}")
    fun getDetailUser(@Path("login") login: String) : Observable<User>


}