package com.example.boldgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class ConversationActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        toolbar = findViewById(R.id.conversationToolbar)
        setSupportActionBar(toolbar)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.conversation_menu,menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.information ->{

                toast("Information")

            }

            R.id.videoCall ->{


                toast("Video Call")
            }

        }

        return true
    }

    fun toast(message:String){

        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()

    }

}



