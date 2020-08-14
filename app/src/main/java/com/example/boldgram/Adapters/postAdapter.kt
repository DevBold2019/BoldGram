package com.example.boldgram.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.boldgram.Models.postModel
import com.example.boldgram.R
import com.example.boldgram.cameraActivity
import com.example.boldgram.commentsActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.BandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.material.snackbar.Snackbar
import de.hdodenhof.circleimageview.CircleImageView
import java.io.IOException

class postAdapter(val  list: List<postModel>,val context: Context):RecyclerView.Adapter<postAdapter.viewholder>() {

    lateinit var onConstraintClick:OnConstraintClickListener
    lateinit var onMoreClick:OnMoreClickListener

    interface OnConstraintClickListener {

        fun onClick(model: postModel,position: Int,view: View)

    }
    interface OnMoreClickListener {

        fun onClicked(model: postModel,position: Int,view: View)

    }

    fun setOnclickListener(listener:OnConstraintClickListener){
        onConstraintClick=listener
    }

    fun setOnMoreClickListener(listener:OnMoreClickListener){

        onMoreClick=listener
    }

    class viewholder(view:View):RecyclerView.ViewHolder(view) {

        val postImageView:ImageView=view.findViewById(R.id.postImageView)
        val profileImageView:CircleImageView=view.findViewById(R.id.profileImageView)
        val locationTextView:TextView=view.findViewById(R.id.postLocation)
        val likesTextView:TextView=view.findViewById(R.id.likesTextView)
        val captionTextView:TextView=view.findViewById(R.id.captionTextView)
        val postersName:TextView=view.findViewById(R.id.postName)
        val captionName:TextView=view.findViewById(R.id.captionNameTextView)
        val captionPostTime:TextView=view.findViewById(R.id.captionPostedTimeTextView)
        val emoji_1:TextView=view.findViewById(R.id.emoji_1)
        val emoji_2:TextView=view.findViewById(R.id.emoji_2)
        val emoji_3:TextView=view.findViewById(R.id.emoji_3)
        val likeButton:ImageButton=view.findViewById(R.id.likeButton)
        val bookmarkButton:ImageButton=view.findViewById(R.id.bookmarkButton)
        val moreButton:ImageButton=view.findViewById(R.id.more_post_details)
        val commentsButton:ImageButton=view.findViewById(R.id.commentButton)
        val commentConstraint:ConstraintLayout=view.findViewById(R.id.comment_constraint)
        val postVideo:SimpleExoPlayerView=view.findViewById(R.id.postVideoView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {

        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.posts_layout,parent,false)

        return viewholder(view)


    }

    override fun getItemCount(): Int {
     return list.size
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val pos=list[position]


        val laugh:Int=0x1F602
        val love:Int=0x1F60D
        val plus:Int=0x2795

        val laughEmoji=String(Character.toChars(laugh))
        val loveEyesEmoji=String(Character.toChars(love))
        val plusEmoji=String(Character.toChars(plus))

        holder.locationTextView.text=pos.post_location
        holder.likesTextView.text=pos.post_likes
        holder.postersName.text=pos.posters_name
        holder.captionTextView.text=pos.caption
        holder.captionName.text=pos.posters_name
        holder.captionPostTime.text=pos.time_posted

        holder.emoji_1.text="$laughEmoji"
        holder.emoji_2.text="$loveEyesEmoji"
        holder.emoji_3.text="$plusEmoji"

        Glide.with(context).load(pos.post_image).into(holder.postImageView)
        Glide.with(context).load(pos.profile_image).into(holder.profileImageView)

        val path = "android.resource://" + context.packageName + "/" + R.raw.video_1
        lateinit var  exoplayer: SimpleExoPlayer
        lateinit var bandWithMeter: BandwidthMeter
        lateinit var trackSelectopr: TrackSelector
        lateinit var    videoUri:Uri
        lateinit var httpFactoryDefault: DefaultHttpDataSourceFactory
        lateinit var extractorsFactory: ExtractorsFactory
        lateinit var mediaSource: MediaSource
        val urlForVideo:String="https://www.radiantmediaplayer.com/media/bbb-360p.mp4"

        if(pos.isItVideo){

          holder.postVideo.visibility=View.VISIBLE
            holder.postImageView.visibility=View.GONE
            holder.profileImageView.borderColor = Color.CYAN
            holder.profileImageView.borderWidth=4


             try {

                 bandWithMeter= DefaultBandwidthMeter()
                 trackSelectopr= DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandWithMeter))
                 exoplayer= ExoPlayerFactory.newSimpleInstance(context,trackSelectopr)
                 videoUri=Uri.parse(urlForVideo)
                 httpFactoryDefault= DefaultHttpDataSourceFactory("exoplayer_video")
                 extractorsFactory= DefaultExtractorsFactory()
                 mediaSource= ExtractorMediaSource(videoUri,httpFactoryDefault,extractorsFactory,null,null)

                 holder.postVideo.player=exoplayer
                 exoplayer.prepare(mediaSource)
                 exoplayer.playWhenReady=true

             }catch (e: IOException){

                 print(e.toString())

             }

        }else{
            holder.postVideo.visibility=View.GONE
            holder.postImageView.visibility=View.VISIBLE
        }


        holder.likeButton.setOnClickListener {

            if( holder.likeButton.drawable.equals(R.drawable.ic_baseline_favorite_24)){

                holder.likeButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                toast("Un Liked")

            }

              holder.likeButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                toast("Liked")

        }
        holder.commentsButton.setOnClickListener {

            val intent: Intent = Intent(context, commentsActivity::class.java)
            context.startActivity(intent)

        }

        holder.bookmarkButton.setOnClickListener {

            if( holder.bookmarkButton.drawable.equals(R.drawable.ic_baseline_bookmark_border_24)){


            }

            holder.bookmarkButton.setImageResource(R.drawable.ic_baseline_bookmark_24)
           snackBar(it,"Added to Bookmark")


        }

        holder.moreButton.setOnClickListener {

            if (onMoreClick!=null && position!=RecyclerView.NO_POSITION){

                onMoreClick!!.onClicked(pos,position,it)

            }

        }

        holder.commentConstraint.setOnClickListener {

            if (onConstraintClick!=null && position!= RecyclerView.NO_POSITION){

                onConstraintClick!!.onClick(pos,position,it)

            }
        }

    }

    fun toast(message:String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }

    fun snackBar(view: View,message: String){
        val snack=Snackbar.make(view,message,Snackbar.LENGTH_LONG)
        snack.show()
    }


}