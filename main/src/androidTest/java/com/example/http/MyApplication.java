package com.example.http;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by 文头头 on 2016/8/2.
 */
public class MyApplication extends Application {

    public Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        context=this;
    }
}
