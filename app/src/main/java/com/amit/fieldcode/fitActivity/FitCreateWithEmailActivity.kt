package com.amit.fieldcode.fitActivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.amit.fieldcode.R
import com.amit.fieldcode.fitUtils.*
import kotlinx.android.synthetic.main.fit_activity_create_with_email.*
import kotlinx.android.synthetic.main.fit_layout_bottomtextview.*

class FitCreateWithEmailActivity : FitBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_create_with_email)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        txtLayoutTitle.text = resources.getString(R.string.fit_terms_of_use_and_privacy_policy)

        btnMailCreateAccount.click {
            startActivity(Intent(this, FitHomeActivity::class.java))
        }

        txtForget.click {
            startActivity(Intent(this, FitForgetPasswordActivity::class.java))
        }

        btnMailLogIn.click {
            launchActivityWithNewTask<FitHomeActivity>()
        }
        txtLoginText.click {
            startActivity(Intent(this, FitLoginWithEmailActivity::class.java))
            finish()
        }

        txtEmailBack.click {
          finish()
        }
    }



}
