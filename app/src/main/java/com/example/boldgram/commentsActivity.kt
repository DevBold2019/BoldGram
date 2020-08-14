package com.example.boldgram

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boldgram.Adapters.commentsAdapter
import com.example.boldgram.Adapters.messageAdapter
import com.example.boldgram.Models.commentsModel
import com.example.boldgram.Models.messageModel

class commentsActivity : AppCompatActivity() {

    lateinit var toolbar:Toolbar
    lateinit var t1: TextView
    lateinit var t2: TextView
    lateinit var t3: TextView
    lateinit var t4: TextView
    lateinit var t5: TextView
    lateinit var t6: TextView
    lateinit var t7: TextView
    lateinit var t8: TextView
    lateinit var t9: TextView
    lateinit var writeComment:EditText

    lateinit var commentName: TextView
    lateinit var commentText: TextView

    lateinit var post: TextView

    lateinit var commentRecyclerView: RecyclerView
    lateinit var commentList: MutableList<commentsModel>
    lateinit var adapter: commentsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        toolbar=findViewById(R.id.commentsToolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        commentText=findViewById(R.id.commentSectionDescriptionTextView)
        commentText.text="It is called Life because you have to live it and life happens."

        commentName=findViewById(R.id.commentSectionNameTextView)
        commentName.text="Shazzy"

        commentRecyclerView=findViewById(R.id.commentsRecycler)
        commentRecyclerView.setHasFixedSize(false)
        commentRecyclerView.layoutManager= LinearLayoutManager(applicationContext,RecyclerView.VERTICAL,false)


 /*       commentList= listOf(




        )*/

        commentList= mutableListOf(

            commentsModel(R.drawable.girl_1,"Shazzy","Bla bla bla blav fgmhj.iddfrdfsgrugcgxzssdffg "),
            commentsModel(R.drawable.girl_2,"Nancy","Bla bla bla blas fdgdgdgdgfsdfwedgdfssfs "),
            commentsModel(R.drawable.maple,"Tom Cat","Bla bla bla bla sffgmbnbccxfdgghmvgsfefdgb"),
            commentsModel(R.drawable.maple,"Tom Cat","Bla bla bla bla eetegrhyk.nvbvgdgdgdfdddfxs"),
            commentsModel(R.drawable.maple,"Tom Cat","Bla bla bla bla egegegergeegefeee"),
            commentsModel(R.drawable.girl_1,"Tom Cat","Bla bla bla bla eetrhtjyjykululukkyukuliu"),
            commentsModel(R.drawable.girl_2,"Tom Cat","Bla bla bla bla gegfegegrgregetefefe"),
            commentsModel(R.drawable.maple,"Tom Cat","Bla bla bla bla fgdgregtjyktfgdrggrhrththr "),
            commentsModel(R.drawable.maple,"Tom Cat","Bla bla bla bla fbfbfbgfntgjthewefwegrr4rt"),
            commentsModel(R.drawable.girl_1,"Tom Cat","Bla bla bla bla sfwfwfwdwwfwfwfwfwfwfwfwfwfwffwwwwwfw"),
            commentsModel(R.drawable.bold_gram,"Tom Cat","Bla bla bla bla  sd ksdkkdsksdwkdmwskmwkdmwmddwdnwjddnjwnf")


        )



        adapter = commentsAdapter(commentList,applicationContext)
        commentRecyclerView.adapter= adapter


        populateBottomLayout()



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_screen_menu,menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.inbox ->{

                val intent: Intent = Intent(this,cameraActivity::class.java)
                startActivity(intent)

            }

        }

        return true
    }

    override fun onNavigateUp(): Boolean {

        finish()
        return true
    }

    fun populateBottomLayout(){

        val laugh:Int=0x1F602
        val loveEyes:Int=0x1F60D
        val crazyLaugh:Int=0x1F606
        val flame:Int=0x1F525
        val perfect:Int=0x1F44C
        val mockLaugh:Int=0x1F605
        val handsUp:Int=0x1F450
        val love:Int=0x1F49C

        val laughEmoji=String(Character.toChars(laugh))
        val loveEyesEmoji=String(Character.toChars(loveEyes))
        val handsEmoji=String(Character.toChars(handsUp))
        val mockEmoji=String(Character.toChars(mockLaugh))
        val crazyEmoji=String(Character.toChars(crazyLaugh))
        val loveEmoji=String(Character.toChars(love))
        val flameEmoji=String(Character.toChars(flame))
        val perfectEmoji=String(Character.toChars(perfect))

        t1 = findViewById(R.id.num_1)
        t2 =findViewById(R.id.num_2)
        t3 = findViewById(R.id.num_3)
        t4 = findViewById(R.id.num_4)
        t5 = findViewById(R.id.num_5)
        t6 = findViewById(R.id.num_6)
        t7 =findViewById(R.id.num_7)
        t8 = findViewById(R.id.num_8)
        t8 = findViewById(R.id.num_8)

        post=findViewById(R.id.post_comment_text_view)
        writeComment=findViewById(R.id.add_comment_edit_text)

        t1.text=laughEmoji
        t2.text=loveEyesEmoji
        t3.text=crazyEmoji
        t4.text=flameEmoji
        t5.text=perfectEmoji
        t6.text=mockEmoji
        t7.text=loveEmoji
        t8.text=handsEmoji

        t1.setOnClickListener {
            val textGot=t1.text.toString()
            writeComment.text.append(textGot)
        }

        t2.setOnClickListener {
            val textGot=t2.text.toString()
            writeComment.text.append(textGot)
        }

        t3.setOnClickListener {
            val textGot=t3.text.toString()
            writeComment.text.append(textGot)
        }

        t4.setOnClickListener {
            val textGot=t4.text.toString()
            writeComment.text.append(textGot)
        }

        t5.setOnClickListener {
            val textGot=t5.text.toString()
            writeComment.text.append(textGot)
        }

        t6.setOnClickListener {
            val textGot=t6.text.toString()
            writeComment.text.append(textGot)
        }

        t7.setOnClickListener {
            val textGot=t7.text.toString()
            writeComment.text.append(textGot)
        }

        t8.setOnClickListener {
            val textGot=t8.text.toString()
            writeComment.text.append(textGot)
        }

        writeComment.addTextChangedListener(object : TextWatcher {
            @SuppressLint("ResourceAsColor")
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if(writeComment.text.toString().trim().isEmpty()){

                    post.setTextColor(Color.GRAY)
                    post.isEnabled=false
                    return
                }

                post.isEnabled=true
                post.setTextColor(Color.parseColor("#00BFFF"))
            }

            @RequiresApi(Build.VERSION_CODES.M)
            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if(writeComment.text.toString().trim().isEmpty()){

                    post.setTextColor(Color.GRAY)
                    post.isEnabled=false

                    return

                }

                post.isEnabled=true
                post.setTextColor(Color.parseColor("#00BFFF"))


            }
            @SuppressLint("ResourceAsColor")
            @RequiresApi(Build.VERSION_CODES.M)
            override fun afterTextChanged(s: Editable) {

                if(writeComment.text.toString().trim().isEmpty()){

                    post.setTextColor(Color.GRAY)
                    post.isEnabled=false

                    return

                }
                post.isEnabled=true

                post.setTextColor(Color.parseColor("#00BFFF"))


            }
        })

        post.setOnClickListener {

            val text=writeComment.text.toString()
            commentList.add(commentsModel(R.drawable.sho_madjozi,"Shazzy","$text"))
            adapter.notifyDataSetChanged()
            commentRecyclerView.scrollToPosition(adapter.itemCount-1)

            writeComment.text.clear()
            toast("Sent ")







        }



    }

    fun toast(message: String) {

        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

    }

}