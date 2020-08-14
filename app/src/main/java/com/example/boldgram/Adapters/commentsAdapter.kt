package com.example.boldgram.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.boldgram.ConversationActivity
import com.example.boldgram.Models.commentsModel
import com.example.boldgram.Models.messageModel
import com.example.boldgram.R
import de.hdodenhof.circleimageview.CircleImageView

class commentsAdapter(val list: MutableList<commentsModel>, val context: Context) : RecyclerView.Adapter<commentsAdapter.viewholder>() {

    class viewholder(view: View) : RecyclerView.ViewHolder(view) {

        val sendersProfileImage: CircleImageView =view.findViewById(R.id.commentProfilePicture)
        val sendersName: TextView =view.findViewById(R.id.commentSectionNameTextView)
        val commentCaption: TextView =view.findViewById(R.id.commentSectionDescriptionTextView)
        val likeComment: ImageButton =view.findViewById(R.id.likeCommentButton)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.comment_section_layout,parent,false)

        return viewholder(view)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val pos=list[position]

        holder.sendersName.text=pos.name
        holder.commentCaption.text=pos.caption
        Glide.with(context).load(pos.pic).into(holder.sendersProfileImage)

        holder.likeComment.setOnClickListener {

            if( holder.likeComment.drawable.equals(R.drawable.ic_baseline_favorite_24)){

                holder.likeComment.setImageResource(R.drawable.ic_baseline_favorite_border_24)

            }

            holder.likeComment.setImageResource(R.drawable.ic_baseline_favorite_24)

        }

        }



    }