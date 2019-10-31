package com.example.registrationapp.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.registrationapp.R
import com.example.registrationapp.model.User
import com.example.registrationapp.util.Constants
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


    val userName = intent?.getParcelableExtra(Constants.USERS_INFOS) as User
        userName.let { user ->
            val name = user.name
            val phone = user.phone
            val email = user.email
            fullName2_textView.text = name
            phone2_textView.text = phone
            email2_textView.text = email
        }



        register_button.setOnClickListener {
            val intent = Intent(this,SuccessActivity::class.java)
            startActivity(intent)
        }

        picture_button.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(callCameraIntent.resolveActivity(packageManager) != null){
                startActivityForResult(callCameraIntent,CAMERA_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if(resultCode == Activity.RESULT_OK && data != null){
                    imageView.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this,"Unrecognized request code", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
