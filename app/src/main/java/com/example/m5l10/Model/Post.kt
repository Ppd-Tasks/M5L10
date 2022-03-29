package com.example.m5l10.Model

class Post{
    var profile:Int = 0
    var fullname:String
    var photo:Int = 0
    var photo1:Int = 0
    var photo2:Int = 0
    //var boolean:Boolean = false

    constructor(profile:Int,fullname:String,photo:Int){
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
    }
    constructor(profile:Int,fullname:String,photo:Int,photo1:Int){
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
        this.photo1 = photo1
    }
    constructor(profile:Int,fullname:String,photo:Int,photo1:Int,photo2:Int){
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
        this.photo1 = photo1
        this.photo2 = photo2
    }
}