package com.example.boldgram.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.boldgram.Models.storyModel
import com.example.boldgram.R
import com.mikhaellopez.circularimageview.CircularImageView
import com.alexzh.circleimageview.CircleImageView

class storyAdapter(val list:List<storyModel>,val context: Context): RecyclerView.Adapter<storyAdapter.viewholder>() {

    class viewholder(view: View) :RecyclerView.ViewHolder(view) {

        val storyImage:CircleImageView  =view.findViewById(R.id.storyProfile)
        val storyName:TextView=view.findViewById(R.id.storyName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.story_layout,parent,false)

        return viewholder(view)


    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
       val pos=list[position]

        holder.storyName.text=pos.name
        Glide.with(context).load(pos.pic).into(holder.storyImage)




    }
}