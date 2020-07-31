package com.example.location

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val tv=findViewById<TextView>(R.id.test)
        val location:IntArray= IntArray(2)
        tv.getLocationOnScreen(location)
        val location1:IntArray= IntArray(2)
        tv.getLocationInWindow(location1)
        val rec: Rect = Rect()
        //getWindowVisibleDisplayFrame方法可以获取到程序显示的区域，包括标题栏，但不包括状态栏。
        window.decorView.getWindowVisibleDisplayFrame(rec)
        //状态栏
        val statusBarH=rec.top
        Log.e("TAG", "status_bar====$statusBarH")
        tv.text = "x=="+location[0].toInt()+"y=="+location[1].toInt()+ "status_bar====$statusBarH===="+"window==x=="+location1[0].toInt()+"window==yy=="+location1[1].toInt()
        val wh=findViewById<TextView>(R.id.wh)
        wh.text="width==="+resources.displayMetrics.widthPixels+"height========="+resources.displayMetrics.heightPixels
    }

    fun onClick(view: View){
        (view as Button).text="left=="+view.left
    }
}
