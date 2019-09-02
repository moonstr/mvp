package com.zhowin.im.myapplication.test;

class Person(private val attributes:Map<String, String>){
        val name:String by attributes
        val company:String by attributes
        val address:String by attributes
        val email:String by attributes
        }
