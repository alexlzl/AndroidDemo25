package com.example.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val task: TextView =findViewById(R.id.taskid2)
        task.text= "task_id==$taskId"
    }

      public fun test(view: View){
          val intent:Intent=Intent(this,Main2Activity::class.java)
          startActivity(intent)
      }
}
