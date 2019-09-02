package com.zhowin.im.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zhowin.im.myapplication.extention.lastChar
import com.zhowin.im.myapplication.extention.lengyh

class MainActivity : AppCompatActivity() {

    var name:String?=null;
    data class User(var id:String,var name:String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var A=User("","")
        var B=User("1213","123")
        "aa".lengyh();
        "aa".lastChar
    }
    fun getUser():User{
        return User("","");
    }
}
