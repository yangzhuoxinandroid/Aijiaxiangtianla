package com.example.http;

import android.app.Application;
import android.content.Context;
import org.xutils.x;

/**
 * Created by 文头头 on 2016/6/29.
 */
public class MainApplication extends Application{

    public static Context context;
    // 在application的onCreate中初始化
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        context = this;
    }
}
