package com.example.administrator.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyLoginActivity extends AppCompatActivity {
    ImageView dlback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        dlback= (ImageView) findViewById(R.id.denglu_back);

    }
    public void MyOnclick(View view){
        int i = view.getId();
        //点击返回我的页面
        if (i == R.id.denglu_back) {
            Intent intent=new Intent(this,MineActivity.class);
            startActivity(intent);
        }//点击登录
        else if (i == R.id.denglu_login){
            Intent intent=new Intent(this,MineActivity.class);
            startActivity(intent);
        }//用户注册
        else if (i == R.id.denglu_login){
            Intent intent=new Intent(this,MyzhuceActivity.class);
            startActivity(intent);
        }//忘记密码
        else if (i == R.id.denglu_login){
            Intent intent=new Intent(this,MywjmmActivity.class);
            startActivity(intent);
        }
    }
}
