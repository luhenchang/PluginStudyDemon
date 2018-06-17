package com.example.pluginstand;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * 作者:王飞
 * 邮箱:1276998208@qq.com
 * create on 2018/6/14 15:43
 */
public interface PluginInterface {
    //注入上下文
    public void attach(Activity proxyActivity);
    public void onCreate(Bundle savedInstanceState);
    public void onStart() ;
    public void onResume();
    public void onPause() ;
    public void onStop() ;
    public void onDestroy();
    public void onSaveInstanceState(Bundle outState);
    public boolean onTouchEvent(MotionEvent event) ;
    public void onBackPressed();
}
