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
import kotlinx.android.synthetic.main.fit_activity_login_back.*
import kotlinx.android.synthetic.main.fit_layout_bottomtextview.*

class FitLoginBackActivity : FitBaseActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_login_back)

        txtLayoutTitle.text = resources.getString(R.string.fit_don_t_have_an_account_sign_up)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags

        txtLayoutTitle.click {
            startActivity(Intent(this, FitSignUpActivity::class.java))
        }

        LogInBack.click {
            startActivity(Intent(this, FitLoginActivity::class.java))
        }

        btnBackLogin.click {
            startActivity(Intent(this, FitHomeActivity::class.java))
        }

        txtForgetPassword.click {
            startActivity(Intent(this, FitForgetPasswordActivity::class.java))
        }
    }

    fun backShowPassword(view: View) {
        if (view.id == R.id.backShowPassword) {
            if (edtBackPassword.transformationMethod == PasswordTransformationMethod.getInstance()) {
                backShowPassword.text = getString(R.string.fit_hide)
                edtBackPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                backShowPassword.text = getString(R.string.fit_show)
                edtBackPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()
            }
        }
    }
}

