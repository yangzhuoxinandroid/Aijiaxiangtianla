package com.example.lovehome;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.adapter.AdapteHome;
import com.example.adapter.HomeGvAdapter;
import com.example.adapter.HomeListviewItemlayoutAdapter;
import com.example.adapter.LunboAdapter;
import com.example.entity.ListViewEntity;
import com.example.entity.LunboEntity;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class HomeMainActivity extends AppCompatActivity {
    LinearLayout linearLayout;View topView;
    RelativeLayout relativeLayout;
    ViewPager vg_ViewPager;
    int index;
    int[] img;
    Handler handler;
    ListView home_listview;
    public List<LunboEntity> list;
    public ViewPager view;
    public List<ListViewEntity.ListBean> like;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        init();
        setview();
        setViewLayout();
        setAuto();
        handler=new Handler(){
            public void handleMessage(Message msg){
                //super.handleMessage(msg);
                if(msg.what==0){//判断是不是想要的线程发过来的通知
                    vg_ViewPager.setCurrentItem(index++);//设置图片加一 滑动
                    //hde.sendEmptyMessageAtTime(0, 2000);
                }
            }
        };

        //为listview添加轮播图头部
        home_listview.addHeaderView(getHeadView());

    }

    public void init() {
        topView=LayoutInflater.from(this).inflate(R.layout.activity_lunbo,null);
        relativeLayout = (RelativeLayout)topView.findViewById(R.id.RelativeLayout);
        vg_ViewPager = (ViewPager)topView.findViewById(R.id.vg_ViewPager);
        linearLayout = (LinearLayout)topView.findViewById(R.id.LinearLayout);
        //listview的id
        home_listview=(ListView)findViewById(R.id.home_listview);

    }

    public ImageView imgData(int i) {
        ImageView imgview = new ImageView(this);
        img = new int[] { R.drawable.ten, R.drawable.two,R.drawable.ten, R.drawable.two,R.drawable.ten};
        switch (i) {
            case 1:
                imgview.setImageResource(img[0]);
                break;
            case 2:
                imgview.setImageResource(img[1]);
                break;
            case 3:
                imgview.setImageResource(img[2]);
                break;
            case 4:
                imgview.setImageResource(img[3]);
                break;
            case 5:
                imgview.setImageResource(img[4]);
                break;
            default:
                break;
        }
        return imgview;
    }
    public void setview() {
        final List<View> vplist = new ArrayList<View>();// 存放视图的容器
        for (int i = 0; i <5; i++) {
            vplist.add(imgData(i + 1));
        }
        vg_ViewPager.setAdapter(new AdapteHome(vplist));// 适配器做了更改
        vg_ViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                index = arg0;
                setIndex(arg0 % vplist.size());
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    //图片进行等比例缩放
    public void setViewLayout(){
        //图片的高度和宽度
        //屏幕的宽度
        Drawable drawable=getResources().getDrawable(R.drawable.ten);
        int heigth=drawable.getIntrinsicHeight();//图片的高度
        int width=drawable.getIntrinsicWidth();//图片的宽度
        //放屏幕高度和宽度的容器
        DisplayMetrics m=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(m);
        int PWidth=m.widthPixels;//设置屏幕的宽度
        //算出相对布局的高度
        int RHeigth=PWidth*heigth/width;  //屏幕的宽度*图片的高度/图片的宽度
        //重新设置高度和宽度
        LayoutParams ll=(LayoutParams) relativeLayout.getLayoutParams();
        ll.height=RHeigth;
        relativeLayout.setLayoutParams(ll);
    }



         public void setIndex(int position) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            TextView tvs = (TextView) linearLayout.getChildAt(i);
            if (i == position) {
                tvs.setTextColor(Color.parseColor("#ff0000"));
            } else {
                tvs.setTextColor(Color.parseColor("#AFAFAF"));
            }
        }
    }
    /**
     * 消息通知主线程换图片
     */
    public void setAuto(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(0);//设置标识
                }
            }
        }).start();
    }

    //第二个轮播图
    // 准备数据
    String[]  name = new String[] { "美食", "娱乐", "房产", "车", "婚庆", "装修", "教育", "工作", "百货", "跳蚤", "商务", "便民", "老乡会", "其他" };
    // 设置ListView和GridView
    public GridView getGridView(int page) {// 专门读取GriView
        GridView gv = new GridView(this);
        gv.setNumColumns(4);// 设置列数
        // 尖括号里面放的是对象的实体类
        list = new ArrayList<LunboEntity>();
        // 获取类
        Class c = R.drawable.class;
        for (int i = (page - 1) * 8; i < page * 8; i++) {
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
        view = (ViewPager) topView.findViewById(R.id.vp_home_top);
        // 设置ViewPager里面放的是GridView
        List<View> vp = new ArrayList<View>();// 存放view的是ViewPager
        // 加进集合之前一定要把GridView设置好
        vp.add(getGridView(1));// 添加的是GridView（设置0-10的数据)
        vp.add(getGridView(2));// 添加的是GridView（设置10-20的数据)
        // 给view设置适配器
        view.setAdapter(new LunboAdapter(vp));
        like=new ArrayList<ListViewEntity.ListBean>();
       home_listview.setAdapter(new HomeListviewItemlayoutAdapter(HomeMainActivity.this,like ));
        //给view设置监听事件
        view.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int arg0) {// 当前页
                Log.v("Tag", "这是第" + arg0 + "页");
                if (arg0 == 0) {
                    ImageView viewOne = (ImageView) findViewById(R.id.bg_one);
                    ImageView viewTwo = (ImageView) findViewById(R.id.bg_two);
                    viewOne.setImageResource(R.drawable.index_indicator_selected);
                    viewTwo.setImageResource(R.drawable.index_indicator_no);
                } else if (arg0 == 1) {
                    ImageView viewOne = (ImageView) findViewById(R.id.bg_one);
                    ImageView viewTwo = (ImageView) findViewById(R.id.bg_two);
                    viewOne.setImageResource(R.drawable.index_indicator_no);
                    viewTwo.setImageResource(R.drawable.index_indicator_selected);
                }
            }
            public void onPageScrolled(int arg0, float arg1, int arg2) {// 正在滑动监听
                Log.v("Tag", "这是第" + arg0 + "页"+"滑动了"+arg1+"次"+"这是第" + arg2 + "页");
            }
            public void onPageScrollStateChanged(int arg0) {
                Log.v("Tag", "滚动的状态：" + arg0);
            }
        });
        return topView;
    }





}
