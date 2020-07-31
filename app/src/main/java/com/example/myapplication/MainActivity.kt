package com.example.myapplication

import android.content.res.Configuration
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
   private var textView:TextView?=null
    private var textView1:TextView?=null
    private var textView2:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.test)
        textView1=findViewById(R.id.test1)
        textView2=findViewById(R.id.test2)
    }

    fun test(view: View) {

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val rec:Rect = Rect()
        //getWindowVisibleDisplayFrame方法可以获取到程序显示的区域，包括标题栏，但不包括状态栏。
        window.decorView.getWindowVisibleDisplayFrame(rec)
        //状态栏
        val statusBarH=rec.top
        Log.e("TAG", "status_bar====$statusBarH")
        textView?.text = "status_bar====$statusBarH"
        //显示视图内容区  该方法获取到的View是程序不包括标题栏的部分
        val title=window.findViewById<View>(Window.ID_ANDROID_CONTENT).top
//        val title=toTop-statusBarH
        //标题栏
        textView1?.text = "title_bar=======$title"
        textView2?.text="content_height==========${window.findViewById<View>(Window.ID_ANDROID_CONTENT).height}"
    }
    override fun onRestart() {
        super.onRestart()
        Log.e("TAG", "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy")
    }
}
