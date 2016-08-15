package com.example.administrator.mine;

import android.app.Application;

import org.xutils.x;

/**
 * Created by dell on 2016/7/2.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);//初始化
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}