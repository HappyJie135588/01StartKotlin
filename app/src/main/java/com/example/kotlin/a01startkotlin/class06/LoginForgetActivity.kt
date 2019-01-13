package com.example.kotlin.a01startkotlin.class06

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.util.ViewUtil
import kotlinx.android.synthetic.main.activity_login_forget.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

class LoginForgetActivity : AppCompatActivity() {
    private var mVerifyCode: String? = null
    private var mPhone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_forget)
        et_password_first.addTextChangedListener(HideTextWatcher(et_password_first))
        et_password_second.addTextChangedListener(HideTextWatcher(et_password_second))
        et_verifycode.addTextChangedListener(HideTextWatcher(et_verifycode))
        btn_verifycode.setOnClickListener { getVerifyCode() }
        btn_confirm.setOnClickListener { doConfirm() }
        mPhone = intent.getStringExtra("phone")
    }

    private fun doConfirm() {
        val password_first = et_password_first.text.toString().trim()
        val password_second = et_password_second.text.toString().trim()
        if (password_first.length < 6 ||
                password_second.length < 6) {
            toast("请输入正确的新密码")
            return
        } else if (password_first != password_second) {
            toast("两次输入的新密码不一致")
            return
        } else if (et_verifycode.text.toString() != mVerifyCode) {
            toast("请输入正确的验证码")
            return
        } else {
            toast("密码修改成功")
            //携带修改后的新密码返回主登录页面
            val intent = Intent().putExtra("new_password", password_first)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun getVerifyCode() {
        mVerifyCode = String.format("%06d", (Math.random() * 1000000 % 1000000).toInt())
        alert("手机号$mPhone，本次验证码是$mVerifyCode，请输入验证码", "请记住验证码") {
            positiveButton("好的") { }
        }.show()
    }

    private inner class HideTextWatcher(private val mView: EditText) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            if (s.toString().trim().length == ViewUtil.getMaxLength(mView)) {
                ViewUtil.hideOneInputMethod(this@LoginForgetActivity, mView)
            }
        }

    }
}
