package com.example.administrator.mine;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class MineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
    }
    public void MyOnclick(View view) {
        int i = view.getId();
        //点击登录
        if (i == R.id.wode_qingdenglu) {
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
            Intent intent2=new Intent(MineActivity.this,MycaogaoActivity.class);
            startActivity(intent2);
        }
        //我的收藏
        else if (i == R.id.wode_shoucang){
            Intent intent3=new Intent(MineActivity.this,MyshoucangActivity.class);
            startActivity(intent3);
        }
        //我的消息
        else if (i == R.id.wode_xiaoxi){
            Intent intent4=new Intent(MineActivity.this,MyxiaoxiActivity.class);
            startActivity(intent4);
        }
        //平台声明
        else if (i == R.id.wode_shengming){
            Intent intent5=new Intent(MineActivity.this,MypingtaiActivity.class);
            startActivity(intent5);
        }
        //关于爱家乡
        else if (i == R.id.wode_aijiaxiang){
            Intent intent6=new Intent(MineActivity.this,MyguanyuajxActivity.class);
            startActivity(intent6);
        }
        //分享软件
        else if (i == R.id.wode_fenxiang){
            Intent intent7=new Intent(MineActivity.this,MyfenxiangActivity.class);
            startActivity(intent7);
        }
        //修改密码
        else if (i == R.id.wode_xiugaimima){
            Intent intent8=new Intent(MineActivity.this,MyxiugaimmActivity.class);
            startActivity(intent8);
        }
        //清除缓存
        else if (i == R.id.wode_qingchuhuancun){
            Intent intent9=new Intent(MineActivity.this,MyqingchuActivity.class);
            startActivity(intent9);
        }
//        //退出登录
//        else if (i == R.id.wode_tuichudenglu){
//
//        }
    }
}
