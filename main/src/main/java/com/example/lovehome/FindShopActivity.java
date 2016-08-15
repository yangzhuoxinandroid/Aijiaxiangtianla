package com.example.lovehome;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.Data.AyalsisData;
import com.example.adapter.HomeListviewItemlayoutAdapter;
import com.example.adapter.Popwindow01Adapter;
import com.example.entity.CategoryEntity;
import com.example.entity.ListViewEntity;
import com.example.http.HttpContext;
import org.xutils.common.Callback;
import java.util.ArrayList;
import java.util.List;

public class FindShopActivity extends AppCompatActivity {
    LinearLayout LinearLayout_beautiful;
    LinearLayout LinearLayout_allShop;
    ImageView ic_white_left;
    ListView listview_writeShop;
    List<ListViewEntity.ListBean> like;ListViewEntity listViewEntity;
    Handler handler;
    List<CategoryEntity.ListBean> categoryEntities;CategoryEntity categoryEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_shop);
        init();
        setAdapter();

        handler=new Handler(){
            public void handleMessage(Message msg){
                switch (msg.what){
                    case 1:
                        String tel= (String) msg.obj;
                        //调用系统的拨号服务实现电话拨打功能
                        String phone_number = tel;

                        phone_number = phone_number.trim();//删除字符串首部和尾部的空格

                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.CALL");
                        intent.setData(Uri.parse("tel:"+phone_number));

                        startActivity(intent);
                        break;
                }
            }
        };

//        setItemClick();
        setReturn();
    }

    public void init(){
        LinearLayout_beautiful= (LinearLayout)findViewById(R.id.LinearLayout_beautiful);
        LinearLayout_allShop= (LinearLayout)findViewById(R.id.LinearLayout_allShop);
        ic_white_left= (ImageView) findViewById(R.id.ic_white_left);
        listview_writeShop=(ListView) findViewById(R.id.listview_writeShop);

        // 给窗口设置背景
        tvView = (TextView) findViewById(R.id.tv_bg);
    }

    public void setAdapter(){
        like=new ArrayList<ListViewEntity.ListBean>();
        //传入解析的数据
        HttpContext httpContext=HttpContext.getInstance();
        httpContext.queryInformation(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("sssss", s);
                AyalsisData ayalsisData=new AyalsisData();
                listViewEntity=new ListViewEntity();
                listViewEntity=ayalsisData.informationData(s);
                like=listViewEntity.getList();
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
                listview_writeShop.setAdapter(new HomeListviewItemlayoutAdapter(FindShopActivity.this,like ,handler));
            }
        });
    }

//    public void setItemClick(){
//        listview_writeShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(FindShopActivity.this,DetailsActivity.class);
//                startActivity(intent);
//            }
//        });
//    }


    //设置泡泡窗口
    public PopupWindow allKindPopWindow;
    public View allKindPopView;
    public TextView tvView;
    int j = 0;// 用来判断点击的次数
    public void OnePopWindowClick(View v){
        if (j > 0) {// 如果是大于0 那就证明他不是第一次点击
            return;// 直接跳出这个方法
        }
        // 不进上面这个if就证明是第一次点击
        j++;// 点击的次数加一

        // 设置listView控件
        allKindPopView = setPopView();// 调用方法
        allKindPopWindow = new PopupWindow(allKindPopView, WindowManager.LayoutParams.MATCH_PARENT, 650, false);
        allKindPopWindow.showAsDropDown(v);
       // listviewone();
        tvView.setVisibility(View.VISIBLE);// 视图显示
        tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allKindPopWindow != null && allKindPopWindow.isShowing()) {
                    allKindPopWindow.dismiss();
                    allKindPopWindow = null;
                    // 关闭窗口把字体恢复
                    LinearLayout_beautiful.setBackgroundColor(Color.parseColor("#808080"));
                    j = 0;// 当关闭泡泡窗口后把点击次数重置
                }
                tvView.setVisibility(View.GONE);
            }
        });
        // 判断泡泡窗口是否为弹出状态
        if (allKindPopWindow.isShowing()) {
            LinearLayout_beautiful.setBackgroundColor(Color.parseColor("#cccccc"));
        }
    }

    ListView LVLeft;
    ListView LVRight;

    // 给泡泡窗口设置数据
    public View setPopView() {// 专门设置view。等view设置好了就把它返回出去

        View popView = LayoutInflater.from(this).inflate(R.layout.business_allkind_paopao, null);
        LVLeft = (ListView) popView.findViewById(R.id.lv_left);
        LVRight = (ListView) popView.findViewById(R.id.lv_right);

        // 给这个添加数据
        categoryEntities = new ArrayList<CategoryEntity.ListBean>();
        HttpContext httpContext=HttpContext.getInstance();
        httpContext.queryInformation(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
               AyalsisData ayalsisData=new AyalsisData();
                categoryEntity=new CategoryEntity();
                categoryEntity=ayalsisData.fatherInformationData(s);
                categoryEntities=categoryEntity.getList();
                Log.d("FindShopActivity", "categoryEntities是否有数据："+categoryEntities.size());
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
                // 设置适配器
                Popwindow01Adapter leftAdapter = new Popwindow01Adapter(FindShopActivity.this, categoryEntities);
                LVLeft.setAdapter(leftAdapter);
            }
        });
        return popView;
    }

    protected void onPause() {// 当activity停止的时候调用
        if (allKindPopWindow != null && allKindPopWindow.isShowing()) {
            allKindPopWindow.dismiss();
            allKindPopWindow = null;
        }
        LinearLayout_beautiful.setVisibility(View.GONE);
        super.onPause();
    }



    //设置返回功能
    public void setReturn(){
        ic_white_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindShopActivity.this,HomeMainActivity.class);
                startActivity(intent);
                FindShopActivity.this.finish();

            }
        });
    }





}


