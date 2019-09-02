package com.zhowin.im.myapplication

import java.util.*

class Test {
    class Person2(private val attributes: Map<String, String>) {
        val name: String by  attributes
        val company: String by  attributes
        val address: String by  attributes
        val email: String by  attributes
    }
    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {

            println("123")
        }
    }
}