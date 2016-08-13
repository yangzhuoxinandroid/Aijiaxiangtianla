package com.example.http;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;


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


public void cityData( Callback.CommonCallback<String> callback){
    //http://123.206.87.139/LoveHomeTownServer/printCity
    String path="http://123.206.87.139/LoveHomeTownServer/printCity";
    RequestParams params=new RequestParams(path);
    x.http().get(params,callback);
}

//4.查询发布信息
public void queryInformation( Callback.CommonCallback<String> callback){
    //http://123.206.87.139/LoveHomeTownServer/detailInfo
    String path="http://123.206.87.139/LoveHomeTownServer/detailInfo";
    RequestParams params=new RequestParams(path);
    x.http().get(params,callback);
}



//    public void getHomeData(String token, Callback.CommonCallback<String> callback){
//        //http://139.196.196.64:8080/edsm/service/getSurveyList?pageSize=10&page=1
//        String path="http://139.196.196.64:8080/edsm/service/getSurveyList?pageSize=10&page=1";
//        RequestParams params=new RequestParams(path);
//        params.addHeader("token",token);
//        x.http().get(params,callback);
//    }



}
