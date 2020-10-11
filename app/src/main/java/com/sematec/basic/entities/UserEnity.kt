package com.sematec.basic.entities

data class UserEnity(
    val access_token: String,
    val app_version: String,
    val avatar: String,
    val city: String,
    val country: String,
    val created_at: String,
    val email: String,
    val email_verified_at: String,
    val family: String,
    val gender: String,
    val id: Int,
    val last_login: String,
    val mobile_model: String,
    val mobile_os: String,
    val name: String,
    val os_version: String,
    val phone_number: String,
    val role_id: Int,
    val updated_at: String
)