package com.example.boldgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var buttonLogin: Button
    lateinit var username:EditText
    lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin=findViewById(R.id.loginButton)

        username=findViewById(R.id.usernameEditText)
        password=findViewById(R.id.passwordEditText)


        buttonLogin.setOnClickListener {

            if(username.text.toString().trim().isEmpty() || password.text.toString().trim().isEmpty()){

                toast("Null Values")
                return@setOnClickListener
            }

            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()


        }



    }

    fun toast(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
}