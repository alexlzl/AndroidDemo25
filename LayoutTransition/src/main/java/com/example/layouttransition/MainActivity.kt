package com.example.layouttransition

import android.animation.LayoutTransition
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    var view:View?=null
    var layoutTransition:LayoutTransition?=null
    private var parent:LinearLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        parent=findViewById(R.id.parent)
    }
    public fun test(view: View){
        val button:Button= Button(this)
        button.text="add1"
        parent?.addView(button)
    }

}