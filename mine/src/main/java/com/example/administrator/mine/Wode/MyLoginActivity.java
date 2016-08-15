package com.example.administrator.mine.Wode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mine.Entity.LoginEntity;
import com.example.administrator.mine.Entity.QQLoginEntity;
import com.example.administrator.mine.Entity.StaticDataEntity;
import com.example.administrator.mine.Network.NetworkData;
import com.example.administrator.mine.R;
import com.google.gson.Gson;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;
import org.xutils.common.Callback;

public class MyLoginActivity extends AppCompatActivity {
LinearLayout llback;
    ImageView img_login_back_icon;
    EditText login_phone;
    EditText login_pwd;
    Button btn_login;
    ImageView login_QQ;
    ImageView login_WeiXin;
    Tencent mTencent;
    UserInfo mInfo;
    TextView btn_register;
    TextView btn_forget_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
//        View inflater = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
//        LinearLayout daohanglan = (LinearLayout) inflater.findViewById(R.id.daohanglan);
//        daohanglan.setVisibility(View.GONE);
        mTencent = Tencent.createInstance("1105515761", this.getApplicationContext());
         btn_register = (TextView) findViewById(R.id.denglu_btn_register);
        btn_forget_password = (TextView)findViewById(R.id.btn_forget_password);
        llback = (LinearLayout) findViewById(R.id.img_login_back_icon);
        login_phone = (EditText)findViewById(R.id.login_phone);
        login_pwd = (EditText) findViewById(R.id.login_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        login_QQ = (ImageView) findViewById(R.id.login_QQ);
        login_WeiXin = (ImageView) findViewById(R.id.login_WeiXin);
        //用户注册
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyLoginActivity.this,MyzhuceActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //忘记密码
        btn_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyLoginActivity.this,MywjmmActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //返回我的页面
        llback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyLoginActivity.this,MineActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getLogin();//用户登录；
        getQQLogin();//QQ登录
    }
       //登录
    private void getLogin() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login_phone.getText().toString().length() != 11) {
                    Toast.makeText(MyLoginActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                } else if (login_pwd.getText().toString().length() < 6) {
                    Toast.makeText(MyLoginActivity.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                } else {

                    NetworkData.getInstance().getisLogin(login_phone.getText().toString(), login_pwd.getText().toString(), "0", new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Log.v("登录：", "数据：" + s);
                            Gson gson = new Gson();
                            LoginEntity json = gson.fromJson(s, LoginEntity.class);
                            String lxfss=login_phone.getText().toString();
                            StaticDataEntity.lxfs=lxfss;
                            if (json.getResult() == 200) {
                                StaticDataEntity.loginentity = json;//实体类保存静态变量

                                StaticDataEntity.Login = 1;
                                StaticDataEntity.Loginx = 1;
                                Intent intent = new Intent(MyLoginActivity.this, MyyhzlActivity.class);
                                startActivity(intent);


                                Toast.makeText(MyLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MyLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onError(Throwable throwable, boolean b) {
                            Log.v("登录：", "失败" + throwable.getMessage());
                        }

                        @Override
                        public void onCancelled(CancelledException e) {

                        }

                        @Override
                        public void onFinished() {
                            Log.v("登录：", "完成");
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode,resultCode,data,loginListener);
    }

    private void getQQLogin() {
        login_QQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTencent.login(MyLoginActivity.this, "all", loginListener);
            }

        });
    }

    public void initOpenidAndToken(JSONObject jsonObject) {
        try {
            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
            Log.e("Login", (token + "," + expires + "," + openId));
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)&& !TextUtils.isEmpty(openId)) {
                mTencent.setAccessToken(token, expires);
                mTencent.setOpenId(openId);
                Log.d("Login", mTencent.getAccessToken());
                Log.d("Login", mTencent.getOpenId());
                Log.d("Login", "mTencent.getQQToken():" + mTencent.getQQToken());
            }
        } catch (Exception e) {
        }
    }

    private void updateUserInfo() {
        if (mTencent != null && mTencent.isSessionValid()) {
            IUiListener listener = new IUiListener() {

                @Override
                public void onError(UiError e) {


                }

                @Override
                public void onComplete(Object response) {
                    Log.d("MainActivity--", response.toString());
                    Gson gson = new Gson();
                    QQLoginEntity qqjson = gson.fromJson(response.toString(), QQLoginEntity.class);
                    StaticDataEntity.qqLoginEntity = qqjson;
//                    Toast.makeText(MyLoginActivity.this, qqjson.getNickname(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MyLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    NetworkData.getInstance().getisLogin(qqjson.getNickname(), "1", new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Log.v("QQ登录：", "数据：" + s);
                            Gson gson = new Gson();
                            LoginEntity json = gson.fromJson(s, LoginEntity.class);
                            if (json.getResult() == 200) {
                                StaticDataEntity.Login = 1;
                                StaticDataEntity.Loginx = 1;
                                Intent intent = new Intent(MyLoginActivity.this, MineActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void onError(Throwable throwable, boolean b) {
                            Log.v("QQ登录：", "失败" + throwable.getMessage());
                        }

                        @Override
                        public void onCancelled(CancelledException e) {

                        }

                        @Override
                        public void onFinished() {
                            Log.v("QQ登录：", "完成");
                        }
                    });
                }

                @Override
                public void onCancel() {

                }
            };
            mInfo = new UserInfo(MyLoginActivity.this, mTencent.getQQToken());
            mInfo.getUserInfo(listener);

        }
    }

    IUiListener loginListener = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {
            Log.e("MainActivity===", values.toString());
            initOpenidAndToken(values);
            updateUserInfo();
        }
    };

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            if (null == response) {
                Log.e("MainActivity", "返回为空登录失败");
                return;
            }
            JSONObject jsonResponse = (JSONObject) response;
            if (null != jsonResponse && jsonResponse.length() == 0) {
                Log.e("MainActivity", "返回为空登录失败");
                return;
            }
            Log.d("MainActivity", "登录成功");
            // 有奖分享处理

            doComplete((JSONObject) response);
        }

        protected void doComplete(JSONObject values) {

        }

        @Override
        public void onError(UiError e) {
            Log.e("MainActivity", "onError``````: " + e.errorMessage);
        }

        @Override
        public void onCancel() {
            Log.e("MainActivity", "取消 ");
        }
    }

}
