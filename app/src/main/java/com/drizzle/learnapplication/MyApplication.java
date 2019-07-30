package com.drizzle.learnapplication;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Project Name：LearnApplication
 * Package Name: com.drizzle.learnapplication
 * Created by Drizzle on 2019/7/30
 * Instructions：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
