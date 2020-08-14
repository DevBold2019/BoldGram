package com.example.boldgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boldgram.Adapters.messageAdapter
import com.example.boldgram.Adapters.storyAdapter
import com.example.boldgram.Models.messageModel
import com.example.boldgram.Models.postModel
import com.example.boldgram.Models.storyModel

class MessageActivity : AppCompatActivity() {


    lateinit var toolbar:Toolbar
    lateinit var messageRecyclerView: RecyclerView
    lateinit var messagesList: List<messageModel>
    lateinit var adapter: messageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val cat=0x1F431
        val miss=0x1F62B
        val smile=0x1F60A
        val blink=0x1F609

        val catEmoji=String(Character.toChars(cat))
        val missEmoji=String(Character.toChars(miss))
        val smileEmoji=String(Character.toChars(smile))
        val blinkEmoji=String(Character.toChars(blink))


        toolbar=findViewById(R.id.messageToolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        messageRecyclerView=findViewById(R.id.messageRecyclerView)
        messageRecyclerView.setHasFixedSize(false)
        messageRecyclerView.layoutManager= LinearLayoutManager(applicationContext,RecyclerView.VERTICAL,false)


        messagesList= listOf(

            messageModel(R.drawable.sho_madjozi,"Hello pretty $blinkEmoji?","Sho Madjozi"),
            messageModel(R.drawable.maple,"Meow $catEmoji","Tom Cat"),
            messageModel(R.drawable.girl_2,"Can we Hang out $smileEmoji ?","Anna Lisa"),
            messageModel(R.drawable.girl_1,"I miss you $missEmoji","Shazzy Shaz")

        )

        adapter = messageAdapter(messagesList,applicationContext)
        messageRecyclerView.adapter= adapter
        adapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.message_menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.videoCall -> {

                toast("Video Call")

            }

            R.id.newMessage -> {
                toast("New Message")
            }

        }

        return true
    }

    fun toast(message: String) {

        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

    }

    fun launchCamera(view: View) {

        val intent: Intent = Intent(this,cameraActivity::class.java)
        startActivity(intent)
        finish()


    }
}