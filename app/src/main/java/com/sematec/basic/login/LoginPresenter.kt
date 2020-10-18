package com.sematec.basic.login

import com.sematec.basic.api.WebService
import com.sematec.basic.entities.LoginRequestEntity
import com.sematec.basic.utils.AppUtils

class LoginPresenter(val view: LoginContract.View) : LoginContract.Presenter {

    override fun login(username: String, password: String) {
        Thread {
            val apiCall = WebService.api.login(
                LoginRequestEntity(
                    username = username, password = password
                )
            ).execute()

            when {
                apiCall.isSuccessful -> {
                    AppUtils.setData("token", apiCall.body()?.access_token)
                    view.onLoginSuccess(apiCall.body())
                    getVehicles()
                }
                apiCall.code() == 401 -> {
                    view.onLoginFailed("User/Pass wrong")
                }
                else -> {
                    view.onLoginFailed("error in server")
                }
            }
        }.start()

    }


    private fun getVehicles() {
        val token = AppUtils.getData("token")
        val apiCall = WebService.api.getVehicles(
            token = "Bearer $token"
        ).execute()
        if (apiCall.isSuccessful) {
            val vehicles = apiCall.body()
            view.onVehicles(vehicles)
        }else{
            view.onLoginFailed("Error in login")
        }

    }
}