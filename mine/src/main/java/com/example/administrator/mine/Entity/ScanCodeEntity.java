package com.example.administrator.mine.Entity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dsy on 2016/8/13.
 */
public class ScanCodeEntity {
    /**
     * result : 203
     * http_status_code : 400
     * detail : 参数 mobile 格式不正确，mobile手机号格式不正确
     * code : 0
     * msg : 发送成功
     * count : 1
     * fee : 0.055
     * unit : RMB
     * mobile : 18169219732
     * sid : 8830444576
     */

    private int result;
    private int http_status_code;
    private String detail;
    private int code;
    private String msg;
    private int count;
    private double fee;
    private String unit;
    private String mobile;
    private long sid;

    public static ScanCodeEntity objectFromData(String str) {

        return new Gson().fromJson(str, ScanCodeEntity.class);
    }

    public static ScanCodeEntity objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ScanCodeEntity.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getHttp_status_code() {
        return http_status_code;
    }

    public void setHttp_status_code(int http_status_code) {
        this.http_status_code = http_status_code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }
}
