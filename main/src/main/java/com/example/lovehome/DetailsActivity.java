package com.example.lovehome;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Data.AyalsisData;
import com.example.Dialog.CustomDialog;
import com.example.administrator.mine.MyLoginActivity;
import com.example.entity.ListViewEntity;
import com.example.http.HttpContext;

import org.xutils.common.Callback;
import org.xutils.x;

public class DetailsActivity extends AppCompatActivity {
    ImageView iv_ten;
    TextView ktv;
    TextView money_textview;
    TextView square;
    TextView telphone;
    TextView many_text;
    ListViewEntity listViewEntity;
    LinearLayout details_phone;
    ImageView left_img;
    ImageView collect_img;
    LinearLayout details_police;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_page_layout);

        init();
        setData();
        setPhone(); //设置电话拨打
        setLeft();
    }

    public void init(){
        iv_ten=(ImageView)findViewById(R.id.iv_ten);
        ktv=(TextView)findViewById(R.id.ktv);
        money_textview=(TextView)findViewById(R.id.money_textview);
        square=(TextView)findViewById(R.id.square);
        telphone=(TextView)findViewById(R.id.telphone);
        many_text=(TextView)findViewById(R.id.many_text);
        details_phone=(LinearLayout)findViewById(R.id.details_phone);
        left_img=(ImageView)findViewById(R.id.left_img);
        collect_img=(ImageView)findViewById(R.id.collect_img);
        details_police=(LinearLayout)findViewById(R.id.details_police);

    }

    public void setData(){
        HttpContext httpContext=HttpContext.getInstance();
        httpContext.queryInformation(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                AyalsisData ayalsisData=new AyalsisData();
                listViewEntity=ayalsisData.informationData(s);
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {

                String url="http://p0.meituan.net/320.0.a/deal/602f0d65070e5973c85aabff0fb6c6ac60545.jpg";

                Log.e("地址", listViewEntity.getList().get(0).getBusiness_location());
                Log.e("电话", listViewEntity.getList().get(0).getPhone());
                Log.e("详情", listViewEntity.getList().get(0).getDetail_info());
                Log.e("钱",listViewEntity.getList().get(0).getPer_capita_consumption()+"");


                ktv.setText(listViewEntity.getList().get(0).getMerchant_name());
                money_textview.setText(listViewEntity.getList().get(0).getPer_capita_consumption()+"");
                square.setText(listViewEntity.getList().get(0).getBusiness_location());
                telphone.setText(listViewEntity.getList().get(0).getPhone());
                many_text.setText(listViewEntity.getList().get(0).getDetail_info());
                x.image().bind(iv_ten,url);
            }
        });
    }

    public void setPhone(){
        details_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.Builder builder = new CustomDialog.Builder(DetailsActivity.this);

                builder.setMessage("确定要拨打：" + telphone.getText().toString());
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //调用系统的拨号服务实现电话拨打功能
                        String phone_number = telphone.getText().toString();
                        phone_number = phone_number.trim();//删除字符串首部和尾部的空格
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.CALL");
                        intent.setData(Uri.parse("tel:"+phone_number));
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                builder.create().show();
            }
        });
    }


    public void setLeft(){
        left_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailsActivity.this,HomeMainActivity.class);
                startActivity(intent);
            }
        });
        collect_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailsActivity.this,MyLoginActivity.class);
                startActivity(intent);
            }
        });
        details_police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailsActivity.this,MyLoginActivity.class);
                startActivity(intent);
            }
        });

    }



}
