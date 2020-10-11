package com.sematec.basic.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sematec.basic.ImageSearchEngineActivity
import com.sematec.basic.R
import com.sematec.basic.entities.UserEnity
import com.sematec.basic.entities.VehicleEntity
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(this)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            presenter.login(
                username = username.text.toString(), password = password.text.toString()
            )
        }


    }

    override fun onLoginSuccess(data: UserEnity?) {
        runOnUiThread {
            data?.access_token?.toast()
        }

//        startActivity(
//            Intent(this, ImageSearchEngineActivity::class.java)
//        )
    }

    override fun onLoginFailed(msg: String) {
        runOnUiThread {
            msg.toast()
        }
    }

    override fun onLoading(show: Boolean) {

    }

    override fun onVehicles(vehicles: List<VehicleEntity>?) {
        runOnUiThread {
            vehicles?.get(0).toString().toast()
        }
    }
}