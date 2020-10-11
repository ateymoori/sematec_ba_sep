package com.sematec.basic.login

import com.sematec.basic.entities.UserEnity
import com.sematec.basic.entities.VehicleEntity

interface LoginContract {

    interface View {
        fun onLoginSuccess(data: UserEnity?)
        fun onLoginFailed(msg: String)
        fun onLoading(show: Boolean)
        fun onVehicles(vehicles: List<VehicleEntity>?)
    }

    interface Presenter {
        fun login(username: String, password: String)
    }


}