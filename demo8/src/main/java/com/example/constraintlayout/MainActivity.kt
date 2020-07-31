package com.example.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var mTv:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTv=findViewById(R.id.test)
        mTv?.text = "DPI==="+resources.displayMetrics.densityDpi+"Density=="+resources.displayMetrics.density+"XDPI==="+resources.displayMetrics.xdpi+"YDPI==="+resources.displayMetrics.ydpi
    }
}
