package com.example.pluginstand;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.pluginstand.PluginInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者:王飞
 * 邮箱:1276998208@qq.com
 * create on 2018/6/14 16:16
 * <p>
 * 空壳  内容不再 该项目下
 * <p>
 * 耳机
 */
public class ProxyActivity extends Activity {
    /*
    * 需要加载的插件里的class
    * */
    private String className;
    PluginInterface pluginInterface;
    private String keyString;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");
        keyString=getIntent().getStringExtra("keys");
        try {
            Class activityClass = getClassLoader().loadClass(className);
            Constructor constructor = activityClass.getConstructor(new Class[]{});
            //调用私有的Activity构造函数进行实例化对象。
            Object instance = constructor.newInstance(new Object[]{});
            //这里强行转换Activity为定义的接口，因为我们已经在插件apk里面实现了这个接口。
            pluginInterface = (PluginInterface) instance;
            pluginInterface.attach(this);
            //传入一些信息。这里如果需要住Activity传入插件activity数据可以通过Bundle传递哦
            Bundle bundle = new Bundle();
            bundle.putString("keys",keyString);
            //这里调用开启插件Activity
            pluginInterface.onCreate(bundle);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        pluginInterface.onStart();
        super.onStart();
    }

    @Override
    protected void onPause() {
        pluginInterface.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        pluginInterface.onDestroy();
        super.onDestroy();
    }

    /*
    * 加载Activity
    *
    * class  小黄车的
    *
    * 资源  小黄车的
    * */
    //加载小黄车的资源和类
    @Override
    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }
    //加载小黄车的资源和类
    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().getClassLoader();
    }
}
