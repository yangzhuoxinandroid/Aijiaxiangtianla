package com.example.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapter.HomeGvAdapter;
import com.example.adapter.HomeListviewItemlayoutAdapter;
import com.example.adapter.LunboAdapter;
import com.example.entity.ListItemEntity;
import com.example.entity.LunboEntity;
import com.example.lovehome.R;

import java.util.ArrayList;
import java.util.List;

class LunboActivity extends AppCompatActivity {
    public List<LunboEntity> list;
    public ViewPager view;
    public List<ListItemEntity> like;
    ListView home_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunbo);

        View view =LayoutInflater.from(this).inflate(R.layout.activity_home_main,null);
        home_listview=(ListView)view.findViewById(R.id.home_listview);


    }


    // 准备数据
    String[] name = new String[] { "美食", "娱乐", "房产", "车", "婚庆", "装修", "教育", "工作", "百货", "跳蚤", "商务", "便民", "老乡会", "其他" };
    // 设置ListView和GridView
    public GridView getGridView(int page) {// 专门读取GriView
        GridView gv = new GridView(this);
        gv.setNumColumns(5);// 设置列数
        // 尖括号里面放的是对象的实体类
        list = new ArrayList<LunboEntity>();
        // 获取类
        Class c = R.drawable.class;
        for (int i = (page - 1) * 10; i < page * 10; i++) {
            try {
                LunboEntity g = new LunboEntity();
                int img = c.getField("img_" + i).getInt(null);
                g.setImage(img);
                g.setName(name[i]);
                list.add(g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 设置适配器
        HomeGvAdapter gvAdapter = new HomeGvAdapter(list, this);
        gv.setAdapter(gvAdapter);
        return gv;
    }

    // 2
    public View getHeadView() {// 3
        View vw = LayoutInflater.from(this).inflate(R.layout.activity_lunbo, null);
        view = (ViewPager) vw.findViewById(R.id.vp_home_top);

        // 设置ViewPager里面放的是GridView
        List<View> vp = new ArrayList<View>();// 存放view的是ViewPager
        // 加进集合之前一定要把GridView设置好
        vp.add(getGridView(1));// 添加的是GridView（设置0-10的数据)
        vp.add(getGridView(2));// 添加的是GridView（设置10-20的数据)
        // 给view设置适配器
        view.setAdapter(new LunboAdapter(vp));
        home_listview.setAdapter(new HomeListviewItemlayoutAdapter(LunboActivity.this,like ));
        //给view设置监听事件
        view.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int arg0) {// 当前页
                Log.v("Tag", "这是第" + arg0 + "页");
                if (arg0 == 0) {
                    ImageView view = (ImageView) findViewById(R.id.bg_one);
                    ImageView view1 = (ImageView) findViewById(R.id.bg_two);
                    view.setImageResource(R.drawable.index_indicator_selected);
                    view1.setImageResource(R.drawable.index_indicator_no);
                } else if (arg0 == 1) {
                    ImageView view = (ImageView) findViewById(R.id.bg_one);
                    ImageView view1 = (ImageView) findViewById(R.id.bg_two);
                    view.setImageResource(R.drawable.index_indicator_no);
                    view1.setImageResource(R.drawable.index_indicator_selected);
                }
            }
            public void onPageScrolled(int arg0, float arg1, int arg2) {// 正在滑动监听
                Log.v("Tag", "这是第" + arg0 + "页"+"滑动了"+arg1+"次"+"这是第" + arg2 + "页");
            }
            public void onPageScrollStateChanged(int arg0) {
                Log.v("Tag", "滚动的状态：" + arg0);
            }
        });
        return vw;
    }









}
