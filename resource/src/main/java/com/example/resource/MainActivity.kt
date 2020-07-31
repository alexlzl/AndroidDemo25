package com.example.resource

import android.graphics.drawable.TransitionDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var mIv: ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mIv=findViewById(R.id.test_iv)
        val drawable=resources.getDrawable(R.drawable.transition_simple)
        mIv?.setImageDrawable(drawable)
        (drawable as TransitionDrawable).startTransition(2000)
    }
}
