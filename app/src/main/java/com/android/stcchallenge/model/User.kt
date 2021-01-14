package com.android.stcchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val caucus: String? = null,
    val congress_numbers: List<Int> = listOf(),
    val current: Boolean,
    val description: String,
    val district: String?,
    val enddate: String?,
    val extra: Map<String, String> = mapOf(),
    val leadership_title: String?,
    val party: String?,
    val person: Person,
    val phone: String,
    val role_type: String,
    val role_type_label: String,
    val senator_class: String,
    val senator_class_label: String,
    val senator_rank: String,
    val senator_rank_label: String,
    val startdate: String,
    val state: String,
    val title: String,
    val title_long: String,
    val website: String
) : Parcelable
