package com.example.administrator.mine.Wode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mine.Entity.StaticDataEntity;
import com.example.administrator.mine.R;

public class MyyhzlActivity extends AppCompatActivity {
    LinearLayout ll_xiugaituxiang;
    TextView yhname;
    TextView lxfangshi;
    TextView lxdizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myyhzl);
        yhname= (TextView) findViewById(R.id.yhzl_yhmc_g);
        lxfangshi= (TextView) findViewById(R.id.yhzl_lxfs_g);
        lxdizhi= (TextView) findViewById(R.id.yhzl_lxdz_g);
    //    yhname.setText(StaticDataEntity.loginentity.getUser_name());
       // lxfangshi.setText(StaticDataEntity.lxfs);
         Intent intent=getIntent();
         String dizhi=intent.getStringExtra("修改地址");
        lxdizhi.setText(dizhi);
       // lxdizhi.setText(StaticDataEntity.updateUserEntity.getContact_site());
//        lxfangshi.setText(StaticDataEntity.scanCodeEntity.getMobile());
//        Intent intent=getIntent();
//        String string= intent.getStringExtra("name");
//        yhname.setText(string);
    }
    public void MyOnclick(View view) {
        int i = view.getId();
        //用户名称
        if (i == R.id.yhzl_yhmc) {
            Intent intent=new Intent(MyyhzlActivity.this,MyxgyhnameActivity.class);
            startActivity(intent);

        }
        //联系方式
        else if (i == R.id.yhzl_lxfs){
            Intent intent=new Intent(MyyhzlActivity.this,MyxglxfsActivity.class);
            startActivity(intent);

        }
        //联系地址
        else if (i == R.id.yhzl_lxdz){
            Intent intent2=new Intent(MyyhzlActivity.this,MyxglxdizhiActivity.class);
            startActivity(intent2);

        }
        //返回我的页面
        else if (i == R.id.yhzl_back){
            Intent intent2=new Intent(MyyhzlActivity.this,MineActivity.class);
            startActivity(intent2);

        }
    }
}
