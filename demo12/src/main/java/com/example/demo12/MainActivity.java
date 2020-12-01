package com.example.demo12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.test);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ConstraintLayout)textView.getParent()).scrollBy(-100,-100);
                //指的是View内容的偏移量，如果是ViewGroup的话作用的就是它的所有子view，如果是TextView的话则作用的就是TextView的内容。这两个api作用的对象是view的内容而不是view本身。
                //
                ((ConstraintLayout)textView.getParent()).scrollTo(-100,-100);
//                textView.scrollBy(5,5);
//               i=i+20;
               //移动视图
//                textView.offsetLeftAndRight(i);
                Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
            }
        });
    }
}