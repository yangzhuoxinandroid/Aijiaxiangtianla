package com.example.administrator.mine.Entity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pc on 2016/8/3.
 */
public class LoginEntity {

    /**
     * pwd : 123
     * user_id : 1
     * user_name : 李四
     * msg : success
     * result : 200
     */

    private String pwd;
    private int user_id;
    private String user_name;
    private String msg;
    private int result;

    public static LoginEntity objectFromData(String str) {

        return new Gson().fromJson(str, LoginEntity.class);
    }

    public static LoginEntity objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), LoginEntity.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
