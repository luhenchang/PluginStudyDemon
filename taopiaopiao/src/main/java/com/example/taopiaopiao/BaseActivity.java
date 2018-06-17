package com.example.taopiaopiao;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.pluginstand.PluginInterface;

/**
 * 作者:王飞
 * 邮箱:1276998208@qq.com
 * create on 2018/6/14 15:51
 */
public class BaseActivity extends Activity implements PluginInterface {
    protected Activity that;
    @SuppressLint("NewApi")
    @Nullable
    @Override
    public Intent getParentActivityIntent() {
        return that.getParentActivityIntent();
    }

    @Override
    public void attach(Activity proxyActivity) {
        that = proxyActivity;
    }

    @Override
    public Context getBaseContext() {
        return that.getBaseContext();
    }

    @Override
    public Context getApplicationContext() {
        return that.getApplicationContext();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void setContentView(View view) {
        that.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        that.setContentView(view, params);
    }

    @Override
    public void setContentView(int layoutResID) {
        that.setContentView(layoutResID);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        that.addContentView(view, params);
    }
    @Override
    public <T extends View> T findViewById(int id) {
        return that.findViewById(id);
    }

    @Override
    public Intent getIntent() {
        return that.getIntent();
    }

    @Override
    public ClassLoader getClassLoader() {
        return that.getClassLoader();
    }

    @Override
    public Resources getResources() {
        return that.getResources();
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        return that.getLayoutInflater();
    }

    @NonNull
    @Override
    public MenuInflater getMenuInflater() {
        return that.getMenuInflater();
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return that.getSharedPreferences(name, mode);
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        return that.getApplicationInfo();
    }

    @Override
    public WindowManager getWindowManager() {
        return that.getWindowManager();
    }

    @Override
    public Window getWindow() {
        return that.getWindow();
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        return that.getSystemService(name);
    }

    @Override
    public void finish() {
        that.finish();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return that.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    protected void onRestart() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}
