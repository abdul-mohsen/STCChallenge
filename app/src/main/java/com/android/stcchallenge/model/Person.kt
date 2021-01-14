package com.android.stcchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val bioguideid: String,
    val birthday: String,
    val cspanid: Int,
    val firstname: String,
    val gender: String,
    val gender_label: String,
    val lastname: String,
    val link: String,
    val middlename: String,
    val name: String,
    val namemod: String,
    val nickname: String,
    val osid: String,
    val pvsid: String,
    val sortname: String,
    val twitterid: String,
    val youtubeid: String
): Parcelable
