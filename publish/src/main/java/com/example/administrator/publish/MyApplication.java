package com.example.administrator.publish;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by Administrator on 2016/8/15.
 */
public class MyApplication extends Application {
    public  static Context context;
    public  static MyApplication myApplication;
    @Override
    public void onCreate() {
        context=this;
        myApplication =this;
        super.onCreate();
        x.Ext.init(this);
    }
}
