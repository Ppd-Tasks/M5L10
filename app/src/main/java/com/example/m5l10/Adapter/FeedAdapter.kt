package com.example.m5l10.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l10.Model.Feed
import com.example.m5l10.Model.Post
import com.example.m5l10.Model.Story
import com.example.m5l10.R

class FeedAdapter(var context: Context, var items:ArrayList<Feed>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_TYPE_AD = 0
    private val ITEM_TYPE_STORY = 1
    private val ITEM_TYPE_POST = 2

    override fun getItemViewType(position: Int): Int {
        val feeds = items[position]

        if (feeds.isAd) return ITEM_TYPE_AD
        //if (feeds.post?.boolean == true)
        //   return ITEM_TYPE_AD
        if(feeds.stories.size > 0)
            return ITEM_TYPE_STORY
        return ITEM_TYPE_POST

        //return if (items[position].stories.size > 0) ITEM_TYPE_STORY else ITEM_TYPE_POST
    }

    fun isSecondPos(position: Int): Boolean{
        return position == 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_TYPE_STORY){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story,parent,false)
            return StoryViewHolder(context,view)
        }else if (viewType == ITEM_TYPE_AD){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_ads,parent,false)
            return AdViewHolder(context,view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post,parent,false)
        return PostViewHolder(view)
    }

    fun refreshAdapter(stories:ArrayList<Story>,recyclerView:RecyclerView){
        val adapter = StoryAdapter(context,stories)
        recyclerView.adapter = adapter
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is AdViewHolder){

        }

        if (holder is StoryViewHolder) {
            val recyclerView = holder.recyclerView
            refreshAdapter(feed.stories,recyclerView)
        }

        if (holder is PostViewHolder) {
            val iv_profile = holder.iv_profile
            val iv_photo = holder.iv_photo
            val iv_photo1 = holder.iv_photo1
            val iv_photo2 = holder.iv_photo2
            val linear = holder.linear
            val tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.post!!.profile)
            iv_photo.setImageResource(feed.post!!.photo)
            iv_photo1.setImageResource(feed.post!!.photo1)
            iv_photo2.setImageResource(feed.post!!.photo2)
            tv_fullname.text = feed.post?.fullname

            if (feed.post!!.photo1 != 0){
                linear.visibility = View.VISIBLE
                iv_photo1.visibility = View.VISIBLE
            }
            if (feed.post!!.photo1 != 0 && feed.post!!.photo2 != 0){
                linear.visibility = View.VISIBLE
                iv_photo1.visibility = View.VISIBLE
                iv_photo2.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AdViewHolder(context: Context,view: View):RecyclerView.ViewHolder(view)

    class StoryViewHolder(context: Context,view: View):RecyclerView.ViewHolder(view){
        var recyclerView:RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            recyclerView.setLayoutManager(manager)
        }
    }

    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_profile:ImageView
        var iv_photo:ImageView
        var iv_photo1:ImageView
        var iv_photo2:ImageView
        var linear:LinearLayout
        var tv_fullname:TextView
        var tv_caption:TextView
        var iv_like:ImageView
        var iv_comment:ImageView
        var iv_send:ImageView
        var iv_save:ImageView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_photo = view.findViewById(R.id.iv_photo)
            iv_photo1 = view.findViewById(R.id.iv_photo1)
            iv_photo2 = view.findViewById(R.id.iv_photo2)
            linear = view.findViewById(R.id.linear)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            tv_caption = view.findViewById(R.id.tv_caption)
            iv_like = view.findViewById(R.id.iv_like)
            iv_comment = view.findViewById(R.id.iv_comment)
            iv_send = view.findViewById(R.id.iv_send)
            iv_save = view.findViewById(R.id.iv_save)
        }
    }
}