package com.example.kotlin.a01startkotlin.class06

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.example.kotlin.a01startkotlin.R
import com.example.kotlin.a01startkotlin.util.Preference
import com.example.kotlin.a01startkotlin.util.ViewUtil
import kotlinx.android.synthetic.main.activity_login_page.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class LoginPageActivity : AppCompatActivity() {
    private val TAG = "LoginPageActivity"
    private var phone: String by Preference(this, "phone", "")
    private var password: String by Preference(this, "password", "")
    private val mRequestCode = 0
    private var bRemember = false
    private var mPassword = "111111"
    private var mVerifyCode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        rg_login.setOnCheckedChangeListener { group, checkedId -> resetHint(checkedId) }
        ck_remember.setOnCheckedChangeListener { buttonView, isChecked -> bRemember = isChecked }
        et_phone.addTextChangedListener(HideTextWatcher(et_phone))
        btn_forget.setOnClickListener { doForget() }
        btn_login.setOnClickListener { doLogin() }
        et_phone.setText(phone)
        et_password.setText(password)
    }

    private fun resetHint(checkedId: Int) {
        if (checkedId == R.id.rb_password) {
            tv_password.text = "登录密码："
            et_password.hint = "请输入密码"
            btn_forget.text = "忘记密码"
            ck_remember.visibility = View.VISIBLE
        } else if (checkedId == R.id.rb_verifycode) {
            tv_password.text = "　验证码："
            et_password.hint = "请输入验证码"
            btn_forget.text = "获取验证码"
            ck_remember.visibility = View.INVISIBLE
        }
    }

    private inner class HideTextWatcher(private val mView: EditText) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            if (s.toString().trim().length == ViewUtil.getMaxLength(mView)) {
                ViewUtil.hideOneInputMethod(this@LoginPageActivity, mView)
            }
        }

    }

    private fun doForget() {
        val phone = et_phone.text.toString().trim()
        if (phone.length < ViewUtil.getMaxLength(et_phone)) {
            toast("请输入正确的手机号")
            return
        }

        if (rb_password.isChecked) {
            startActivityForResult<LoginForgetActivity>(mRequestCode, Pair("phone", phone))
        } else if (rb_verifycode.isChecked) {
            mVerifyCode = String.format("%06d", (Math.random() * 1000000 % 1000000).toInt())
            alert("手机号$phone，本次验证码是$mVerifyCode，请输入验证码", "请记住验证码") {
                positiveButton("好的") { }
            }.show()
        }

    }

    private fun doLogin() {
        val phone = et_phone.text.toString().trim()
        if (phone.length < ViewUtil.getMaxLength(et_phone)) {
            toast("请输入正确的手机号")
            return
        }

        if (rb_password.isChecked) {
            val password = et_password.text.toString().trim()
            if (mPassword != password) {
                toast("请输入正确的密码")
            } else {
                loginSuccess()
            }
        } else if (rb_verifycode.isChecked) {
            val verifyCode = et_password.text.toString().trim()
            if (mVerifyCode != verifyCode) {
                toast("请输入正确的验证码")
            } else {
                loginSuccess()
            }
        }
    }

    private fun loginSuccess() {
        alert("您的手机号码是${et_phone.text}，恭喜你通过登录验证，点击“确定”按钮返回上个页面", "登录成功") {
            positiveButton("确定返回") {
                finish()
            }
            negativeButton("我再看看") {
            }
        }.show()
        if (bRemember) {
            phone = et_phone.text.toString()
            password = et_password.text.toString()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == mRequestCode && data != null) {
            //用户密码已改为新密码
            mPassword = data.getStringExtra("new_password")
        }
    }

}
