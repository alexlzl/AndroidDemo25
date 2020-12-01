package com.example.demo14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.example.demo14.R;

import java.io.File;

/**
 * https://juejin.cn/post/6844904013515718664
 */
public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.text);
        String fileDir = this.getFilesDir().getAbsolutePath();
        String cacheDir = this.getCacheDir().getAbsolutePath();
        mTextView.setText("getFilesDir=="+fileDir+"===cacheDir==="+cacheDir);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] files = getExternalFilesDirs(Environment.MEDIA_MOUNTED);
            for (File file : files) {
                Log.e("file_dir", file.getAbsolutePath());
            }
        }

        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)){
            //sd卡已经安装，可以进行相关文件操作
            Log.e("file_dir", "SD卡已经安装");
        }else{
            Log.e("file_dir", "SD卡未安装");
        }
        Log.e("file_dir", String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()));



    }
}