package com.amit.fieldcode.fitActivity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.amit.fieldcode.R
import com.amit.fieldcode.fitUtils.FitBaseActivity
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_activity_sign_up.*

class FitSignUpActivity : FitBaseActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_sign_up)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags

        btnSignUp.click {
            startActivity(Intent(this, FitLoginBackActivity::class.java))
        }

    }

    fun showPassword(view: View) {
        if (view.id == R.id.sighUpShow) {
            if (edtSignUpPassword.transformationMethod == PasswordTransformationMethod.getInstance()) {
                sighUpShow.text = getString(R.string.fit_hide)
                edtSignUpPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance();
            } else {
                sighUpShow.text = getString(R.string.fit_show)
                edtSignUpPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()
            }
        }
    }
}
