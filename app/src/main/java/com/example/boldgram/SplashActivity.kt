package com.example.boldgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler:Handler= Handler()


        handler.postDelayed(object : Runnable {
            override fun run() {


                val intent:Intent= Intent(this@SplashActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()


            }


        },2000)




    }
}