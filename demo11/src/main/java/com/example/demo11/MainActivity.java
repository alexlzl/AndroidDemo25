package com.example.demo11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int i=0;
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        TextView textView=findViewById(R.id.test);
        textView.setText("getbottom=="+textView.getBottom()+"getbottom-gettop"+(textView.getBottom()-textView.getTop())+"======"+"getright-getleft=="+(textView.getRight()-textView.getLeft())+"getright=="+textView.getRight());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+10;
                //相对于view原始位置移动的偏移量
                textView.setTranslationX(i);
                Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
            }
        });
    }
}