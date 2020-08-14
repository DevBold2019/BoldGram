package com.example.boldgram.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.boldgram.ConversationActivity
import com.example.boldgram.MainActivity
import com.example.boldgram.Models.messageModel
import com.example.boldgram.R
import de.hdodenhof.circleimageview.CircleImageView

class messageAdapter(val list: List<messageModel>,val context: Context) :RecyclerView.Adapter<messageAdapter.viewholder>() {

    class viewholder(view: View) : RecyclerView.ViewHolder(view) {

        val sendersProfileImage: CircleImageView =view.findViewById(R.id.senders_profile_picture)
        val sendersName: TextView =view.findViewById(R.id.senders_name)
        val messageSnippet: TextView =view.findViewById(R.id.snippet_message)
        val messageLayout: ConstraintLayout =view.findViewById(R.id.messageLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.message_layout,parent,false)

        return viewholder(view)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val pos=list[position]

        holder.sendersName.text=pos.sendersName
        holder.messageSnippet.text=pos.snippet
        Glide.with(context).load(pos.pic).into(holder.sendersProfileImage)

        holder.messageLayout.setOnClickListener {

            val intent: Intent = Intent(context, ConversationActivity::class.java)
            context.startActivity(intent)


        }




    }
}