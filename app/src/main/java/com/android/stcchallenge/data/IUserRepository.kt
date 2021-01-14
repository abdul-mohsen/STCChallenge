package com.android.stcchallenge.data

import com.android.stcchallenge.model.User

interface IUserRepository {

    suspend fun getAllUsers(): List<User>
}