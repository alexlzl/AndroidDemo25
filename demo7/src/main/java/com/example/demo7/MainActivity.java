package com.example.demo7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view){
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(this,Main2Activity.class));
        startActivity(new Intent().setAction("com.example.test"));
    }
}
