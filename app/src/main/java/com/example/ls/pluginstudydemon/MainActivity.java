package com.example.ls.pluginstudydemon;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.pluginstand.PluginManager;
import com.example.pluginstand.ProxyActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //6.0之后动态必须权限，这里估计很多人都怕坑了。很多博客也没写明白导致很多人最后运行失败。
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        PluginManager.getInstance().setContext(this);
        verifyStoragePermissions(this);
    }
    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void jumpTaopiaoPiao(View view) {
        File file = new File(Environment.getExternalStorageDirectory(), "taopiaopiao-debug.apk");
        PluginManager.getInstance().loadPath(file.getAbsolutePath());
        //跳转到空壳activity启动插件apk
        Intent intent = new Intent(this,ProxyActivity.class);
        intent.putExtra("className", PluginManager.getInstance().getPackageInfo().activities[0].name);
        intent.putExtra("keys","我是主Activity里面的数据哦！");
        startActivity(intent);
    }

    public void jumpDidi(View view) {
        File file = new File(Environment.getExternalStorageDirectory(), "didichuxing-debug.apk");
        PluginManager.getInstance().loadPath(file.getAbsolutePath());
        //跳转apk
        Intent intent = new Intent(this,ProxyActivity.class);
        intent.putExtra("className", PluginManager.getInstance().getPackageInfo().activities[0].name);
        startActivity(intent);
    }
}
