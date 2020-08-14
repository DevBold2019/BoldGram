package com.example.boldgram.Fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boldgram.Adapters.postAdapter
import com.example.boldgram.Adapters.storyAdapter
import com.example.boldgram.Models.postModel
import com.example.boldgram.Models.storyModel
import com.example.boldgram.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
    lateinit var storyRecyclerView: RecyclerView
    lateinit var postRecyclerView: RecyclerView
    lateinit var storyList: List<storyModel>
    lateinit var postList: List<postModel>
    lateinit var storyAdapter: storyAdapter
    lateinit var postAdapter: postAdapter
    lateinit var bottomSheetDialog: BottomSheetDialog
    lateinit var moreDialog: Dialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.fragment_blank, container, false)


        val unicode:Int=0x1F525
        val laugh:Int=0x1F602
        val love:Int=0x1F60D
        val flame=String(Character.toChars(unicode))
        val laughEmoji=String(Character.toChars(laugh))
        val loveEyes=String(Character.toChars(love))


        bottomSheetDialog= BottomSheetDialog(activity!!)
        bottomSheetDialog.setContentView(R.layout.new_comment_layout);
        bottomSheetDialog.setCanceledOnTouchOutside(true)

        moreDialog= Dialog(activity!!)
        moreDialog.setContentView(R.layout.more_layout)
        moreDialog.setCanceledOnTouchOutside(true)

        storyRecyclerView=view.findViewById(R.id.storiesRecyclerView)
        storyRecyclerView.setHasFixedSize(false)
        storyRecyclerView.layoutManager= LinearLayoutManager(context!!.applicationContext,RecyclerView.HORIZONTAL,false)


        postRecyclerView=view.findViewById(R.id.postsRecyclerView)
        postRecyclerView.setHasFixedSize(false)
        postRecyclerView.layoutManager= LinearLayoutManager(context,RecyclerView.VERTICAL,false)


        storyList= listOf(
            storyModel(R.drawable.girl_1,"Shazzy"),
            storyModel(R.drawable.maple,"Tom Cat"),
            storyModel(R.drawable.sho_madjozi,"Sho Madjozi"),
            storyModel(R.drawable.girl_2,"Nancy")
        )

        postList= listOf(

            postModel("Confidence is what makes a lady $loveEyes.",
                R.drawable.girl_1,
                R.drawable.girl_1,"Manhattan","Shazzy","50 likes","23 minutes ago",true),
            postModel("I can't find a rat to eat $laughEmoji $flame",
                R.drawable.maple,
                R.drawable.maple,"New York","Tom Cat","500 likes","5 hours ago",false),
            postModel("Having A good time before the mega concert $flame",
                R.drawable.sho_madjozi,
                R.drawable.sho_madjozi,"Cape Town,South Africa","Sho Madjozi","500 likes","1 hour ago",true),
            postModel("It is called Life because you have to live it and life happens.",
                R.drawable.girl_2,
                R.drawable.girl_2,"Malaysia","Nancy","60 likes","5 minutes ago",false)

        )

        storyAdapter = storyAdapter(storyList,context!!.applicationContext)
        storyRecyclerView.adapter= storyAdapter
        storyAdapter.notifyDataSetChanged()

        postAdapter = postAdapter(postList,context!!.applicationContext)
        postRecyclerView.adapter= postAdapter
        postAdapter.notifyDataSetChanged()

        postAdapter.setOnclickListener(object : postAdapter.OnConstraintClickListener {

            override fun onClick(model: postModel, position: Int, view: View) {

                showBottomSheet()

            }

        })
        postAdapter.setOnMoreClickListener(object : postAdapter.OnMoreClickListener {
            override fun onClicked(model: postModel, position: Int, view: View) {

                showMoreDialog()
                //showBottomSheet()
            }


        })

        return view


    }

    fun  showBottomSheet(){

        bottomSheetDialog.show()

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

        val emoji_1_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_1)!!
        val emoji_2_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_2)!!
        val emoji_3_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_3)!!
        val emoji_4_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_4)!!
        val emoji_5_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_5)!!
        val emoji_6_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_6)!!
        val emoji_7_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_7)!!
        val emoji_8_TextView: TextView = bottomSheetDialog.findViewById(R.id.comment_emoji_8)!!



        val postTextView: TextView = bottomSheetDialog.findViewById(R.id.post_comment_text_view)!!
        val editText: EditText = bottomSheetDialog.findViewById(R.id.add_comment_edit_text)!!

        emoji_1_TextView.text=laughEmoji
        emoji_2_TextView.text=loveEyesEmoji
        emoji_3_TextView.text=crazyEmoji
        emoji_4_TextView.text=flameEmoji
        emoji_5_TextView.text=perfectEmoji
        emoji_6_TextView.text=mockEmoji
        emoji_7_TextView.text=loveEmoji
        emoji_8_TextView.text=handsEmoji


        emoji_1_TextView.setOnClickListener {
            val textGot=emoji_1_TextView.text.toString()
            editText.text.append(textGot)
        }

        emoji_2_TextView.setOnClickListener {
            val textGot=emoji_2_TextView.text.toString()
            editText.text.append(textGot)
        }

        emoji_3_TextView.setOnClickListener {
            val textGot=emoji_3_TextView.text.toString()
            editText.text.append(textGot)
        }

        emoji_4_TextView.setOnClickListener {
            val textGot=emoji_4_TextView.text.toString()
            editText.text.append(textGot)
        }

        emoji_5_TextView.setOnClickListener {
            val textGot=emoji_5_TextView.text.toString()
            editText.text.append(textGot)
        }

        emoji_6_TextView.setOnClickListener {
            val textGot=emoji_6_TextView.text.toString()
            editText.text.append(textGot)
        }

        emoji_7_TextView.setOnClickListener {
            val textGot=emoji_7_TextView.text.toString()
            editText.text.append(textGot)
        }

        emoji_8_TextView.setOnClickListener {
            val textGot=emoji_8_TextView.text.toString()
            editText.text.append(textGot)
        }

        editText.addTextChangedListener(object : TextWatcher {
            @SuppressLint("ResourceAsColor")
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

               if(editText.text.toString().trim().isEmpty()){

                   postTextView.setTextColor(Color.GRAY)
                   postTextView.isEnabled=false
                   return
               }

                postTextView.isEnabled=true
                postTextView.setTextColor(Color.parseColor("#00BFFF"))
            }

            @RequiresApi(Build.VERSION_CODES.M)
            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                if(editText.text.toString().trim().isEmpty()){

                    postTextView.setTextColor(Color.GRAY)
                    postTextView.isEnabled=false

                    return

                }

                postTextView.isEnabled=true
                postTextView.setTextColor(Color.parseColor("#00BFFF"))


            }
            @SuppressLint("ResourceAsColor")
            @RequiresApi(Build.VERSION_CODES.M)
            override fun afterTextChanged(s: Editable) {

                if(editText.text.toString().trim().isEmpty()){

                    postTextView.setTextColor(Color.GRAY)
                    postTextView.isEnabled=false

                    return

                }
                postTextView.isEnabled=true

                postTextView.setTextColor(Color.parseColor("#00BFFF"))


            }
        })

        postTextView.setOnClickListener {

            editText.text.clear()
            toast("Sending post ")
            bottomSheetDialog.cancel()
        }



    }

    fun showMoreDialog(){

        moreDialog.show()




    }
    fun toast(message:String){

        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()

    }
    fun snackBar(view: View,message: String){
        val snack= Snackbar.make(view,message, Snackbar.LENGTH_LONG).setAction("Undo ",View.OnClickListener {



        })
        snack.setActionTextColor(Color.BLUE)
        snack.show()
    }
    fun checkText(){}

}