package com.android.stcchallenge.data

import com.android.stcchallenge.model.User
import timber.log.Timber

object UserRepository: IUserRepository {

    override suspend fun getAllUsers(): List<User> {
        return WebClient.jsonAPI.getAllUsers().toList().also { Timber.d("$it") }
    }
}