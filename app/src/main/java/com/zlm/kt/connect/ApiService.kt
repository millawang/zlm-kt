package com.zlm.kt.connect

import com.zlm.kt.data.model.api.UserDetailResponse
import com.zlm.kt.data.model.api.UsersResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // -------------------------------------------
    /**
     * Get user information
     */
    @GET("/users/{username}")
    fun loadUserInfo(@Path("username") username: String?): Observable<UserDetailResponse?>?

    /**
     * Get User list.
     */
    @GET("users")
    fun loadUser(): Observable<Array<UsersResponse?>?>?

    /**
     * Get user information
     */
    @GET("/users?since={since}&page={page}&per_page={per_page}")
    fun loadUser(@Path("since") since: Int, @Path("page") page: Int, @Path("per_page") per_page: Int): Observable<Array<UsersResponse?>?>?
}