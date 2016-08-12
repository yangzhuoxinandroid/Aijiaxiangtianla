package com.example.administrator.mine;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        MineFragment  mineFragment = new MineFragment();
//        ft.replace(R.id.lvtihuan,mineFragment,"Introduce");
//        ft.commit();
    }
    public void MyOnclick(View view) {
  //      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        int i = view.getId();
        //点击登录
        if (i == R.id.wode_qingdenglu) {
//            LoginFragment  loginFragment = new LoginFragment();
//            ft.replace(R.id.conten,loginFragment,"Introduce");
//            ft.commit();
            Intent intent=new Intent(MineActivity.this,MyLoginActivity.class);
            startActivity(intent);
        }
        //我的发布
        else if (i == R.id.wode_fabu){
            Intent intent=new Intent(MineActivity.this,MyfabuActivity.class);
            startActivity(intent);
        }
        //我的草稿
        else if (i == R.id.wode_caogao){
            Intent intent=new Intent(MineActivity.this,MycaogaoActivity.class);
            startActivity(intent);
        }
        //我的收藏
        else if (i == R.id.wode_shoucang){
            Intent intent=new Intent(MineActivity.this,MyshoucangActivity.class);
            startActivity(intent);
        }
        //我的消息
        else if (i == R.id.wode_xiaoxi){
            Intent intent=new Intent(MineActivity.this,MyxiaoxiActivity.class);
            startActivity(intent);
        }
        //平台声明
        else if (i == R.id.wode_shengming){
            Intent intent=new Intent(MineActivity.this,MypingtaiActivity.class);
            startActivity(intent);
        }
        //关于爱家乡
        else if (i == R.id.wode_aijiaxiang){
            Intent intent=new Intent(MineActivity.this,MyguanyuajxActivity.class);
            startActivity(intent);
        }
        //分享软件
        else if (i == R.id.wode_fenxiang){
            Intent intent=new Intent(MineActivity.this,MyfenxiangActivity.class);
            startActivity(intent);
        }
        //修改密码
        else if (i == R.id.wode_xiugaimima){
            Intent intent=new Intent(MineActivity.this,MyxiugaimmActivity.class);
            startActivity(intent);
        }
        //清除缓存
        else if (i == R.id.wode_qingchuhuancun){
            Intent intent=new Intent(MineActivity.this,MyqingchuActivity.class);
            startActivity(intent);
        }
//        //退出登录
//        else if (i == R.id.wode_tuichudenglu){
//
//        }
    }
}
