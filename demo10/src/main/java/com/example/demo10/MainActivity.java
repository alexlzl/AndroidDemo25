package com.example.demo10;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButton = (Button) findViewById(R.id.Button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建动画作用对象：此处以Button为例

// 步骤1：设置属性数值的初始值 & 结束值
                ValueAnimator valueAnimator = ValueAnimator.ofInt(mButton.getLayoutParams().width, 1000);
                // 初始值 = 当前按钮的宽度，此处在xml文件中设置为150
                // 结束值 = 500
                // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
                // 即默认设置了如何从初始值150 过渡到 结束值500

// 步骤2：设置动画的播放各种属性
                valueAnimator.setDuration(5000);
                // 设置动画运行时长:1s

// 步骤3：将属性数值手动赋值给对象的属性:此处是将 值 赋给 按钮的宽度
                // 设置更新监听器：即数值每次变化更新都会调用该方法
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {

                        int currentValue = (Integer) animator.getAnimatedValue();
                        // 获得每次变化后的属性值
                        System.out.println(currentValue);
                        // 输出每次变化后的属性值进行查看
//                        ViewGroup.LayoutParams layoutParams= mButton.getLayoutParams();
//                        layoutParams.width=currentValue;
//                        mButton.setLayoutParams(layoutParams);
                        mButton.getLayoutParams().width = currentValue;
                        // 每次值变化时，将值手动赋值给对象的属性
                        // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

// 步骤4：刷新视图，即重新绘制，从而实现动画效果
                        mButton.requestLayout();

                    }
                });

                valueAnimator.start();
                // 启动动画
            }
        });


    }

}
