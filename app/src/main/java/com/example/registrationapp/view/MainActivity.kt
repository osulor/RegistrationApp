package com.example.registrationapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.registrationapp.R
import com.example.registrationapp.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_button.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            val name = fullName_editText.text.toString()
            val phone = phone_editText.text.toString()
            val email = email_editText.text.toString()
            intent.putExtra(Constants.NAME_KEY, name)
            intent.putExtra(Constants.PHONE_KEY, phone)
            intent.putExtra(Constants.EMAIL_KEY, email)
            startActivity(intent)
        }

    }

//    fun nextButtonClicked(view: View){
//
//        val intent = Intent(this,SecondActivity::class.java)
//        startActivity(intent)
//    }


}
