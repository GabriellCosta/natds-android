package com.natura.android.sample.components

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.View
import com.natura.android.sample.R
import com.natura.android.textfield.TextFieldInput

class TextFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textfield)

        val clickable = findViewById<TextFieldInput>(R.id.clickable_item)
        clickable.setOnIconClickListener(View.OnClickListener {
            clickable.text = ""
            clickable.requestFocus()
        })

        val mutableItem = findViewById<TextFieldInput>(R.id.mutable_item)
        val switchDisabledItem = findViewById<View>(R.id.switch_item_disabled)
        switchDisabledItem.setOnClickListener {
            if (mutableItem.isEnabled) {
                mutableItem.isEnabled = false
                mutableItem.footer = "now is disabled again"
            } else {
                mutableItem.isEnabled = true
                mutableItem.footer = "now is enabled"
            }
        }

        val switchErroredItem = findViewById<View>(R.id.switch_item_errored)
        switchErroredItem.setOnClickListener {
            if (mutableItem.state == TextFieldInput.State.ERROR) {
                mutableItem.error = null
            } else {
                mutableItem.error = "error message"
            }
        }

        val switchSucceedItem = findViewById<View>(R.id.switch_item_succeed)
        switchSucceedItem.setOnClickListener {
            if (mutableItem.state == TextFieldInput.State.SUCCESS) {
                mutableItem.footer = ""
                mutableItem.state = TextFieldInput.State.NONE
            } else {
                mutableItem.footer = "success message"
                mutableItem.state = TextFieldInput.State.SUCCESS
            }
        }

        var passwordMode = true
        val password = findViewById<TextFieldInput>(R.id.password_item)
        password.setOnIconClickListener(View.OnClickListener {
            if (passwordMode) {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                password.icon = "EA38"
            } else {
                password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                password.icon = "EA37"
            }
            passwordMode = !passwordMode
        })

    }
}
