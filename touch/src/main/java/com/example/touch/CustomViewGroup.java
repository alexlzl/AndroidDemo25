package com.example.touch;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

class CustomViewGroup extends LinearLayout {
    private static final String TAG="TAG";


    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"VIEW_GROUP==========dispatchTouchEvent");
//        return super.dispatchTouchEvent(ev);
        return false;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"VIEW_GROUP==========onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"VIEW_GROUP==========onTouchEvent");
        return super.onTouchEvent(event);
//        return true;
    }
}
