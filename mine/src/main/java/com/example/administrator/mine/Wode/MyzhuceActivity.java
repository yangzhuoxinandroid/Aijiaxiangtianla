package com.example.administrator.mine.Wode;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mine.Entity.ScanCodeEntity;
import com.example.administrator.mine.Entity.StaticDataEntity;
import com.example.administrator.mine.Network.NetworkData;
import com.example.administrator.mine.R;
import com.google.gson.Gson;

import org.xutils.common.Callback;

//import org.xutils.common.Callback;

public class MyzhuceActivity extends AppCompatActivity {
    ImageView img_back_icon;
    Button btn_register_send_code;
    EditText edt_register_phone;
    EditText edt_register_phone_code;
    EditText edt_register_password;
    EditText edt_register_ensure_password;
    TextView btn_agreement_context;
    CheckBox check_agreement;
    Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myzhuce);
        img_back_icon = (ImageView) findViewById(R.id.img_back_icon);
        btn_register_send_code = (Button)findViewById(R.id.btn_register_send_code);
        edt_register_phone = (EditText)findViewById(R.id.edt_register_phone);
        edt_register_phone_code = (EditText)findViewById(R.id.edt_register_phone_code);
        edt_register_password = (EditText)findViewById(R.id.edt_register_password);
        edt_register_ensure_password= (EditText)findViewById(R.id.edt_register_ensure_password);
        btn_agreement_context = (TextView)findViewById(R.id.btn_agreement_context);
        check_agreement = (CheckBox)findViewById(R.id.check_agreement);
        btn_register= (Button)findViewById(R.id.btn_register);
        getScanCode();//获取验证码;
        getRegisterUsers();//注册;
    }
    private void getScanCode(){
        btn_register_send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_register_phone.getText().toString().length()==11){
                    btn_register_send_code.setClickable(false);
                    String phone = edt_register_phone.getText().toString();
                    NetworkData.getInstance().getScanCode(phone, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Log.v("获取验证码：", "数据：" + s);
                            Gson gson = new Gson();
                            ScanCodeEntity json = gson.fromJson(s, ScanCodeEntity.class);
                            if (json.getMsg().equals("发送成功")){
                                timeSec = 60;
                                handler.sendEmptyMessageDelayed(0, 1000);
                            }else {
                                btn_register_send_code.setClickable(true);
                            }
                            Toast.makeText(MyzhuceActivity.this, json.getMsg(), Toast.LENGTH_SHORT).show();
                            Log.v("register", "json.getCode():" + json.getCode());
                        }

                        @Override
                        public void onError(Throwable throwable, boolean b) {
                            Log.v("获取验证码：", "失败" + throwable.getMessage());
                        }

                        @Override
                        public void onCancelled(CancelledException e) {

                        }

                        @Override
                        public void onFinished() {
                            Log.v("获取验证码：", "完成");
                        }
                    });
                }else {
                    Toast.makeText(MyzhuceActivity.this, "手机号码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void  getRegisterUsers(){
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_register_phone.getText().toString().length()!=11){
                    Toast.makeText(MyzhuceActivity.this, "手机号码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }else if(edt_register_phone_code.getText().toString()==null){
                    Toast.makeText(MyzhuceActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }else if(edt_register_password.getText().toString().length()<6){
                    Toast.makeText(MyzhuceActivity.this, "请输入6位以上的密码", Toast.LENGTH_SHORT).show();
                }else if (!edt_register_ensure_password.getText().toString().equals(edt_register_password.getText().toString())){
                    Toast.makeText(MyzhuceActivity.this, "输入密码不一致", Toast.LENGTH_SHORT).show();
                }else if(check_agreement.isChecked()==false){
                    Toast.makeText(MyzhuceActivity.this, "请阅读并同意服务条款", Toast.LENGTH_SHORT).show();
                }else {
                    NetworkData.getInstance().getRegisterUser(edt_register_phone.getText().toString(),edt_register_ensure_password.getText().toString(),edt_register_phone_code.getText().toString(),new Callback.CommonCallback<String>() {

                        @Override
                        public void onSuccess(String s) {
                            Log.v("注册：", "数据：" + s);
                            Gson gson = new Gson();
                            ScanCodeEntity json = gson.fromJson(s, ScanCodeEntity.class);
                            StaticDataEntity.scanCodeEntity = json;//实体类保存静态变量
                            Toast.makeText(MyzhuceActivity.this, json.getMsg(), Toast.LENGTH_SHORT).show();
                            if(json.getResult()==200){
                                Intent intent = new Intent(MyzhuceActivity.this, MyLoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }

                        @Override
                        public void onError(Throwable throwable, boolean b) {
                            Log.v("注册：", "失败" + throwable.getMessage());
                        }

                        @Override
                        public void onCancelled(CancelledException e) {

                        }

                        @Override
                        public void onFinished() {
                            Log.v("注册：", "完成");
                        }
                    });
                }
            }
        });

    }

    int timeSec = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            timeSec--;
            if(timeSec>=0){
                if (timeSec>0) {
                    btn_register_send_code.setText( timeSec + "秒后重发");
                }else {
                    btn_register_send_code.setClickable(true);
                    btn_register_send_code.setText("重新获取");
                }
                handler.sendEmptyMessageDelayed(0, 1000);
            }

        }
    };
}
