package com.example.http;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * Created by 文头头 on 2016/6/29.
 */
public class HttpContext {

    //单例
    private HttpContext(){

    }
    private static HttpContext instance=null;
    public static HttpContext getInstance(){
        if(instance==null){
            instance=new HttpContext();
        }
        return instance;
    }


//public void getFirstData(String type, Callback.CommonCallback<String> callback){
//    // http://v.juhe.cn/toutiao/index?type=shishang&key=934966647904cba51cd9a53781b01a33
//    String path1 = "http://v.juhe.cn/toutiao/index";
//    String path =path1+"?type="+type+"&key=934966647904cba51cd9a53781b01a33";
//    RequestParams params=new RequestParams(path);
////    params.addParameter("type",type);
//    x.http().get(params,callback);
//}



}
