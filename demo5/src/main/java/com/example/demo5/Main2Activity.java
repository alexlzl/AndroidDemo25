package com.example.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private ImageView iv;
    private ScaleDrawable drawable;
    private final int UPDATE_VIEW = 99;
    private boolean IS_SCALING = false;
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv = (ImageView) findViewById(R.id.iv);
        drawable = (ScaleDrawable) iv.getDrawable();
        drawable.setLevel(0);
        mTv=findViewById(R.id.tv_two);
        mTv.setText(isTaskRoot()+"=============");
    }

    public void setScaleDrawableLevel(View view) {
        if (drawable instanceof ScaleDrawable) {
//            drawable.setLevel(5000);
            if (!IS_SCALING) {
                IS_SCALING = true;
                timer.start();
            }
        }
    }

    private CountDownTimer timer = new CountDownTimer(Integer.MAX_VALUE, 60) {
        @Override
        public void onTick(long millisUntilFinished) {
            mHandler.sendEmptyMessage(UPDATE_VIEW);
        }

        @Override
        public void onFinish() {
            IS_SCALING = false;
        }
    };

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_VIEW:
                    int level = drawable.getLevel();
                    Log.i("zyq", "level = " + level);
                    if (level >= 10000) {
                        timer.cancel();
                        drawable.setLevel(10000);
                    } else {
                        drawable.setLevel(level + 100);
                    }

                    break;
            }
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
