package com.example.myapplication

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val task:TextView=findViewById(R.id.taskid1)
        task.text= "task_id==$taskId"
    }
    public fun onTest(view: View){
      val componentName:ComponentName=ComponentName("com.example.task2","com.example.task2.Main2Activity")
        startActivity(Intent().setComponent(componentName))

    }
}
