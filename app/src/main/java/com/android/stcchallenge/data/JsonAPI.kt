package com.android.stcchallenge.data

import com.android.stcchallenge.model.User
import retrofit2.http.GET

interface JsonAPI {

    @GET(".")
    suspend fun getAllUsers(): Array<User>
}