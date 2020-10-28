package com.amit.fieldcode.fitActivity

import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.TransformationMethod
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.amit.fieldcode.R
import com.amit.fieldcode.fitUtils.FitBaseActivity
import com.amit.fieldcode.fitUtils.click
import kotlinx.android.synthetic.main.fit_activity_enter_password.*


class FitEnterPasswordActivity : FitBaseActivity(), TextWatcher {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fit_activity_enter_password)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        val flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.decorView.systemUiVisibility = flags

        imgMasterBack.click {
            finish()
        }

        edt1.transformationMethod = MyPasswordTransformationMethod()
        edt2.transformationMethod = MyPasswordTransformationMethod()
        edt3.transformationMethod = MyPasswordTransformationMethod()
        edt4.transformationMethod = MyPasswordTransformationMethod()


        edt1.addTextChangedListener(this)
        edt2.addTextChangedListener(this)
        edt3.addTextChangedListener(this)
        edt4.addTextChangedListener(this)
    }

    override fun afterTextChanged(s: Editable) {

        if (s.length == 1) {
            if (edt1.length() == 1) {
                edt2.requestFocus()
            }

            if (edt2.length() == 1) {
                edt3.requestFocus()
            }

            if (edt3.length() == 1) {
                edt4.requestFocus()
            }

            if (edt4.length() == 1) {
                startActivity(Intent(this, FitWellDoneActivity::class.java))
            }

        } else if (s.isEmpty()) {
            if (edt4.length() == 0) {
                edt3.requestFocus()
            }

            if (edt3.length() == 0) {
                edt2.requestFocus()
            }

            if (edt2.length() == 0) {
                edt1.requestFocus()
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
    }
}

class MyPasswordTransformationMethod : TransformationMethod {

    override fun onFocusChanged(
        view: View?,
        sourceText: CharSequence?,
        focused: Boolean,
        direction: Int,
        previouslyFocusedRect: Rect?
    ) {
    }

    override fun getTransformation(source: CharSequence, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

}

class PasswordCharSequence(private val source: CharSequence) : CharSequence {
    override val length: Int
        get() = source.length

    override fun get(index: Int): Char {
        return '*'
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return source.subSequence(startIndex, endIndex)
    }

    companion object {
        private const val DOT = '\u2022'
        private const val BIGGER_DOT = '●'
    }

}
