package com.example.touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="TAG";
    private CustomTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e(TAG,"MainActivity==========click");
//                Toast.makeText(MainActivity.this,"click",Toast.LENGTH_LONG).show();
//            }
//        });
//        textView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG,"MainActivity==========touch");
//                Toast.makeText(MainActivity.this,"touch",Toast.LENGTH_LONG).show();
//                return true;
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"MainActivity==========dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MainActivity==========onTouchEvent");
        return super.onTouchEvent(event);
//        return false;
    }

}