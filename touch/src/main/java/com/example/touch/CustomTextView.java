package com.example.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {
    private static final String TAG = "TAG";

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "CustomTextView==========dispatchTouchEvent");
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "CustomTextView==========ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.e(TAG, "CustomTextView==========ACTION_CANCEL");
//                break;
//            case MotionEvent.ACTION_OUTSIDE:
//                Log.e(TAG, "CustomTextView==========ACTION_OUTSIDE");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG, "CustomTextView==========ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG, "CustomTextView==========ACTION_UP");
//                break;
//        }
        return super.dispatchTouchEvent(event);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "CustomTextView==========onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "CustomTextView==========ACTION_DOWN");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "CustomTextView==========ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_OUTSIDE:
                Log.e(TAG, "CustomTextView==========ACTION_OUTSIDE");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "CustomTextView==========ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "CustomTextView==========ACTION_UP");
                break;
        }
//        return super.onTouchEvent(event);
        return true;
    }
}
