//package com.example.fragment;//package com.example.lovehome;
//
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.view.ViewPager;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.example.activity.LunboActivity;
//import com.example.adapter.AdapteHome;
//import com.example.lovehome.R;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by 文头头 on 2016/8/11.
// */
//public class HomeFragment extends Fragment {
//    View HomeView;
//    LinearLayout linearLayout;
//    RelativeLayout relativeLayout;
//    ViewPager vg_ViewPager;
//    int index;
//    int[] img;
//    Handler handler;
//    ListView home_listview;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        HomeView=inflater.inflate(R.layout.activity_home_main,container,false);
//
//
//        init();
//        setview();
//        setAuto();
//        handler=new Handler(){
//            public void handleMessage(Message msg){
//                //super.handleMessage(msg);
//                if(msg.what==0){//判断是不是想要的线程发过来的通知
//                    vg_ViewPager.setCurrentItem(index++);//设置图片加一 滑动
//                    //hde.sendEmptyMessageAtTime(0, 2000);
//                }
//            }
//        };
//
//       LunboActivity lunboActivity=new LunboActivity();
//        home_listview.addHeaderView(lunboActivity.getHeadView());
//        return HomeView;
//    }
//
//
//
//
//    public void init() {
//        relativeLayout = (RelativeLayout)HomeView.findViewById(R.id.RelativeLayout);
//        vg_ViewPager = (ViewPager)HomeView.findViewById(R.id.vg_ViewPager);
//        linearLayout = (LinearLayout)HomeView.findViewById(R.id.LinearLayout);
//        //listview的id
//        home_listview=(ListView)HomeView.findViewById(R.id.home_listview);
//    }
//
//    public ImageView imgData(int i) {
//        ImageView imgview = new ImageView(getContext());
//        img = new int[] { R.drawable.ten, R.drawable.two};
//        switch (i) {
//            case 1:
//                imgview.setImageResource(img[0]);
//                break;
//            case 2:
//                imgview.setImageResource(img[1]);
//                break;
//            default:
//                break;
//        }
//        return imgview;
//    }
//    public void setview() {
//        final List<View> vplist = new ArrayList<View>();// 存放视图的容器
//        for (int i = 0; i < 2; i++) {
//            vplist.add(imgData(i + 1));
//        }
//        vg_ViewPager.setAdapter(new AdapteHome(vplist));// 适配器做了更改
//        vg_ViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int arg0) {
//                index = arg0;
//                setIndex(arg0 % vplist.size());
//            }
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//                // TODO Auto-generated method stub
//            }
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//    }
//    public void setIndex(int position) {
//        for (int i = 0; i < linearLayout.getChildCount(); i++) {
//            TextView tvs = (TextView) linearLayout.getChildAt(i);
//            if (i == position) {
//                tvs.setBackgroundColor(Color.parseColor("#ff0000"));
//            } else {
//                tvs.setBackgroundColor(Color.parseColor("#AFAFAF"));
//            }
//        }
//    }
//    /**
//     * 消息通知主线程换图片
//     */
//    public void setAuto(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    handler.sendEmptyMessage(0);//设置标识
//                }
//
//            }
//        }).start();
//    }
//
//
//
//}
