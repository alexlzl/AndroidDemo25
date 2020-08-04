package com.wudengwei.roundshadowlayout;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.media.Image;
import android.os.Build;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "zhaolei";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View view = findViewById(R.id.roundlayout);
        final ImageView imageView = findViewById(R.id.iv_viewtobitmap);

        findViewById(R.id.bt_creater).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                measureView(view, imageView);
            }
        });
    }



    /**
     * 测量View
     */
    void measureView(View view, final ImageView imageView){

        Log.e(TAG, "view to bitmap 开始");
        final View viewRoot = view;
//
        int measuredWidth = View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY);
        int measuredHeight = View.MeasureSpec.makeMeasureSpec(view.getHeight(), View.MeasureSpec.EXACTLY);
        viewRoot.measure(measuredWidth, measuredHeight);
        viewRoot.layout(0, 0, viewRoot.getMeasuredWidth(), viewRoot.getMeasuredHeight());

        final Bitmap bitmap = transferBitmap(viewRoot);
        imageView.setImageBitmap(bitmap);
    }

    /**
     * view to bitmap
     * @return bitmap
     */
    public static Bitmap transferBitmap(View v) {
        Bitmap bmp;
        int w = v.getWidth();
        int h = v.getHeight();
        if (w <= 0 || h <= 0) {
            return null;
        }
        try {
            bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_4444);
            Canvas c = new Canvas(bmp);
            c.drawColor(Color.WHITE);
            v.draw(c);
        } catch (Exception e) {
            return null;
        }
        return bmp;
    }

    /**
     * 设置视图裁剪的圆角半径
     * @param radius
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setClipViewCornerRadius(View view, final int radius){

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            //不支持5.0版本以下的系统
            return;
        }

        if(view == null) return;

        if(radius <= 0){
            return;
        }

        /*view.setOutlineProvider(new ViewOutlineProvider() {

            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), radius);
            }
        });*/
        view.setOutlineProvider(new ViewOutlineProvider() {

            @Override
            public void getOutline(View view, Outline outline) {
                Log.e(TAG, "手动执行getOutline了");
                outline.setRoundRect(0, 0, view.getWidth(),   view.getHeight(), radius);
            }
        });
        view.setClipToOutline(true);

    }
}
