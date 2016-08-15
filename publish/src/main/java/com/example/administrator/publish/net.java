package com.example.administrator.publish;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * Created by Administrator on 2016/8/13.
 */
public class net {
    private  net(){

    }
    public  static  net instance=null;
    public static  net getInstance(){
        if (instance==null){
            instance=new net();
        }
        return  instance;
    }

    public void getdata(Callback.CommonCallback<String> callback ){

            String path="http://123.206.87.139/LoveHomeTownServer/printCategory";
            RequestParams parms=new RequestParams(path);
            x.http().get(parms,callback);


    }


}
