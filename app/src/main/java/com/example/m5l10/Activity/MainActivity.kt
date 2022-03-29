package com.example.m5l10.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l10.Adapter.FeedAdapter
import com.example.m5l10.Model.Feed
import com.example.m5l10.Model.Post
import com.example.m5l10.Model.Story
import com.example.m5l10.R

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this,1))

        refreshAdapter(getAllItems())
    }
    fun refreshAdapter(items:ArrayList<Feed>){
        val adapter = FeedAdapter(this,items)
        recyclerView.adapter = adapter
    }
    fun getAllItems():ArrayList<Feed>{
        val stories:ArrayList<Story> = ArrayList()

        stories.add(Story(R.drawable.img,"Odilbek"))
        stories.add(Story(R.drawable.img,"Odilbek"))
        stories.add(Story(R.drawable.img,"Odilbek"))
        stories.add(Story(R.drawable.img,"Odilbek"))
        stories.add(Story(R.drawable.img,"Odilbek"))

        val feeds:ArrayList<Feed> = ArrayList()

        feeds.add(Feed(stories))

        feeds.add(Feed(Post(R.drawable.img,"Odilbek Mirzayev",R.drawable.img_1)))
        feeds.add(Feed())
        feeds.add(Feed(Post(R.drawable.img,"Odilbek Mirzayev",R.drawable.img_1)))
        feeds.add(Feed(Post(R.drawable.img,"Odilbek Mirzayev",R.drawable.img_1)))
        feeds.add(Feed(Post(R.drawable.img,"Odilbek Mirzayev",R.drawable.img_1)))
        feeds.add(Feed(Post(R.drawable.img,"Odilbek Mirzayev",R.drawable.img_1,R.drawable.img_1)))
        feeds.add(Feed(Post(R.drawable.img,"Odilbek Mirzayev",R.drawable.img_1)))
        feeds.add(Feed(Post(R.drawable.img,"Odilbek Mirzayev",R.drawable.img_1,R.drawable.img_1,R.drawable.img_1)))

        return feeds

    }
}