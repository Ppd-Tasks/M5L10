package com.example.m5l10.Model

class Feed {
    var isAd:Boolean = false
    var post:Post? = null
    var stories:ArrayList<Story> = ArrayList()

    constructor(post: Post){
        this.post = post
    }
    constructor(){
        this.isAd = true
    }

    constructor(stories:ArrayList<Story>){
        this.stories = stories
    }
}