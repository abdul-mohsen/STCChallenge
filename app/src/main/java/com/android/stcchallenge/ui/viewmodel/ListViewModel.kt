package com.android.stcchallenge.ui.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.stcchallenge.data.UserRepository
import com.android.stcchallenge.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class ListViewModel: ViewModel() {

    private val _userList: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val userList: StateFlow<List<User>> = _userList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _userList.emit(UserRepository.getAllUsers())
        }
    }
//
//    fun jsonConverter(activity: Activity) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val inputStream = activity.assets.open("us_senators.json")
//            val input = inputStream.bufferedReader().use{it.readText()}
//            val jsonDeserializer = JsonDeserializer { json, _, _ ->
//                json as JsonObject
//                val longList = json.getAsJsonArray("objects")
//                Gson().fromJson(longList, Array<User>::class.java).also { Timber.d("$it") }
//            }
//            val gSon = GsonBuilder().registerTypeAdapter(Array<User>::class.java, jsonDeserializer).create()
//            val output = gSon.fromJson(input, Array<User>::class.java)
//            _userList.emit(output.toList().sortedBy { it.person.lastname })
//        }
//    }
}