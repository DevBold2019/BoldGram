package com.example.boldgram

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boldgram.Adapters.postAdapter
import com.example.boldgram.Adapters.storyAdapter
import com.example.boldgram.Fragments.*
import com.example.boldgram.Models.postModel
import com.example.boldgram.Models.storyModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar

    lateinit var bottomNav:BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        bottomNav=findViewById(R.id.navBar)

        toolbar=findViewById(R.id.mainScreenToolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)





        bottomNav.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {


                when(p0.itemId){

                    R.id.home->{

                        val fragment: Fragment = HomeFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, fragment).commit()


                    }
                    R.id.search->{

                       val fragment: Fragment = SearchFragment()
                        supportActionBar!!.title=("Search")
                        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, fragment).commit()

                    }
                    R.id.addPost->{


                        val fragment: Fragment = AddPostFragment()
                        supportActionBar!!.title=("New Post")
                        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, fragment).commit()

                    }
                    R.id.info->{

                        val fragment: Fragment = InformationFragment()
                        supportActionBar!!.title = "Activity"
                        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, fragment).commit()
                    }
                    R.id.profile->{

                        val fragment: Fragment = ProfileFragment()
                        supportActionBar!!.title = "Sho Madjozi"
                        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, fragment).commit()
                    }




                }


                return true
            }

        })

        if (savedInstanceState == null){

            val fragment: Fragment =HomeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.contentLayout, fragment).commit()

        }




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_screen_menu,menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.inbox ->{

                val intent: Intent = Intent(this,MessageActivity::class.java)
                startActivity(intent)

            }

        }

        return true
    }

    fun toast(message:String){

        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()

    }





}