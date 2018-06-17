package com.example.pluginstand;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * 作者:王飞
 * 邮箱:1276998208@qq.com
 * create on 2018/6/14 16:23
 */
public class PluginManager {
    //用来加载我们的插件apk类
    private DexClassLoader dexclassLoader;
    //加载插件的资源文件图片呀，xml等
    private Resources resources;
    private Context context;
    private static PluginManager ourInstance = new PluginManager();
    //获取插件安装包信息如Activity的类明等
    private PackageInfo packageInfo;

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public static PluginManager getInstance() {
        return ourInstance;
    }
    public void setContext(Context context){
        this.context=context;
    }
    public DexClassLoader getClassLoader() {
        return dexclassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    private PluginManager() {

    }

    //路径
    public void loadPath(String path) {
        File dexoutFile = context.getDir("dex", Context.MODE_PRIVATE);
        //能加载外置卡的能力了
        dexclassLoader = new DexClassLoader(path, dexoutFile.getAbsolutePath(), null, context.getClassLoader());
        PackageManager packageManager=context.getPackageManager();
        packageInfo=packageManager.getPackageArchiveInfo(path,PackageManager.GET_ACTIVITIES);

        //需要AssetManager
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager,path);
            resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());

        } catch (InstantiationException e) {


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
