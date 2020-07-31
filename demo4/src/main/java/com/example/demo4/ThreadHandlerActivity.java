package com.example.demo4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

/**
 * https://blog.csdn.net/shaoenxiao/article/details/54561753
 */
public class ThreadHandlerActivity extends Activity {
    private MyThread thread;
    //创建子线程
    class MyThread extends Thread{
        private Looper looper;//取出该子线程的Looper
        public void run() {
            Log.e("TAG","MyThread======"+Thread.currentThread().getName());
            Looper.prepare();//创建该子线程的Looper
            looper = Looper.myLooper();//取出该子线程的Looper
            Looper.loop();//只要调用了该方法才能不断循环取出消息
        }
    }

    private Handler mHandler;//将mHandler指定轮询的Looper

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //实例化一个特殊的线程HandlerThread，必须给其指定一个名字
//        HandlerThread thread = new HandlerThread("handler thread");
//        thread.start();//千万不要忘记开启这个线程
//        //将mHandler与thread相关联
//        mHandler = new Handler(thread.getLooper()){
//            public void handleMessage(android.os.Message msg) {
//                Log.e("当前子线程是----->", Thread.currentThread()+"");
//            };
//        };
//        mHandler.sendEmptyMessage(1);//发送消息
        thread = new MyThread();
        thread.start();//千万别忘记开启这个线程
        //下面是主线程发送消息
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mHandler = new Handler(thread.looper){
            public void handleMessage(android.os.Message msg) {
                Log.e("TAG","handle thread======"+Thread.currentThread().getName());
            };
        };
        mHandler.sendEmptyMessage(1);

    }

}