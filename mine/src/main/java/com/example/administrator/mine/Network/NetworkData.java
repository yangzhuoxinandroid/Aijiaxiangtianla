package com.example.administrator.mine.Network;

import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by dell on 2016/8/2.
 */
public class NetworkData {
    private NetworkData(){

    }
    private static NetworkData instance=null;
    public static NetworkData getInstance(){
        if(instance==null){
            instance=new NetworkData();
        }
        return instance;
    }
    private String path="http://123.206.87.139/LoveHomeTownServer";
    public void getCity(Callback.CommonCallback<String> callback){
        String url=path+"/printCity";
        RequestParams params=new RequestParams(url);
        Log.d("NetworkData", "params:" + params);
        x.http().get(params, callback);
    }
    public void getPrintCategory(Callback.CommonCallback<String> callback){
        String url=path+"/printCategory";
        RequestParams params=new RequestParams(url);
        x.http().get(params,callback);
    }
    public void getChildCategory(Callback.CommonCallback<String> callback){
        String url=path+"/printCategory?parent_category_id=1";
        RequestParams params=new RequestParams(url);
        x.http().get(params,callback);
    }

    public void getAjxList(Callback.CommonCallback<String> callback){
        String url=path+"/detailInfo";
        RequestParams params=new RequestParams(url);
        x.http().get(params, callback);
    }
    public void getAjxLists(int user_id,int city_id,int child_category_id,int parent_category_id,int page,int pageSize,int is_approve,Callback.CommonCallback<String> callback){
        String url=path+"/detailInfo";
        RequestParams params=new RequestParams(url);
        params.addParameter("user_id",user_id);
        params.addParameter("city_id",city_id);
        params.addParameter("child_category_id",child_category_id);
        params.addParameter("parent_category_id",parent_category_id);
        params.addParameter("page",page);
        params.addParameter("pageSize",pageSize);
        params.addParameter("is_approve",is_approve);
        x.http().get(params, callback);
    }
    public void getScanCode(String phone, Callback.CommonCallback<String> callback){
        String url=path+"/scanCode";
        RequestParams params=new RequestParams(url);
        params.addParameter("phone",phone);
        x.http().get(params,callback);
    }
    public void getRegisterUser(String phone,String pwd , String code,Callback.CommonCallback<String> callback){
        String url=path+"/registerUser";
        RequestParams params=new RequestParams(url);
        params.addParameter("phone",phone);
        params.addParameter("pwd",pwd);
        params.addParameter("code",code);
        x.http().get(params,callback);
    }
    public void getisLogin(String userName,String pwd ,String third_login_tag,Callback.CommonCallback<String> callback){
        String url=path+"/isLogin";
        RequestParams params=new RequestParams(url);
        params.addParameter("userName",userName);
        params.addParameter("pwd",pwd);
        params.addParameter("third_login_tag",third_login_tag);
        x.http().get(params,callback);
    }
    public void getisLogin(String userName,String third_login_tag,Callback.CommonCallback<String> callback){
        String url=path+"/isLogin";
        RequestParams params=new RequestParams(url);
        params.addParameter("userName",userName);
        params.addParameter("third_login_tag",third_login_tag);
        x.http().get(params,callback);
    }
    public void getupdateUser(int user_id, String userName, String phone, String contact_site, Callback.CommonCallback<String> callback){
        String url=path+"/updateUser";
        RequestParams params=new RequestParams(url);
        params.addParameter("user_id",user_id);
        params.addParameter("userName",userName);
        params.addParameter("phone",phone);
        params.addParameter("contact_site",contact_site);
        x.http().get(params,callback);
    }
    public void getupdateUser(int user_id, Callback.CommonCallback<String> callback) {
        String url=path+"/updateUser";
        RequestParams params=new RequestParams(url);
        params.addParameter("user_id",user_id);
        x.http().get(params,callback);
    }

}
