package com.zhowin.im.myapplication

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.zhowin.im.myapplication", appContext.packageName)
        println("Hello World!")
    }
    fun main(args: Array<String>) {    // 包级可见的函数，接受一个字符串数组作为参数
        println("Hello World!")         // 分号可以省略
    }
}
