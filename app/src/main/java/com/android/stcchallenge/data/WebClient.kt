package com.android.stcchallenge.data

import com.android.stcchallenge.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object WebClient {

    private const val YELP_BASE_URL = "https://jsonkeeper.com/b/WOS5/"

    private val jsonDeserializer = JsonDeserializer { json, _, _ ->
        json as JsonObject
        val longList = json.getAsJsonArray("objects")
        Gson().fromJson(longList, Array<User>::class.java).also { Timber.d("$it") }
    }

    val jsonAPI: JsonAPI = Retrofit.Builder().baseUrl(YELP_BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().registerTypeAdapter(Array<User>::class.java, jsonDeserializer).create()
        ))
        .build()
        .create(JsonAPI::class.java)
}