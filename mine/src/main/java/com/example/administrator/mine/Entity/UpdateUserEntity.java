package com.example.administrator.mine.Entity;

/**
 * Created by dsy on 2016/8/14.
 */
public class UpdateUserEntity {

    /**
     * msg : 参数不能为空
     * result : 203
     */

    private String msg;
    private int result;
    private int user_id;//用户ID
    private String user_name;//用户名称
    private String mobile;//电话
    private String contact_site;//地址

    public String getContact_site() {
        return contact_site;
    }

    public void setContact_site(String contact_site) {
        this.contact_site = contact_site;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
