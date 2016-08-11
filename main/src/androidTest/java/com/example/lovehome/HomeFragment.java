package com.example.lovehome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 文头头 on 2016/8/11.
 */
public class HomeFragment extends Fragment {
    View HomeView;
    LinearLayout linearLayout;
    RelativeLayout relativeLayout;
    ViewPager vg_ViewPager;
    int index;
    int[] img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HomeView=inflater.inflate(R.layout.activity_home_main,container,false);
        x.view().inject(this,HomeView);


        init();


        return HomeView;
    }




    public void init() {
        relativeLayout = (RelativeLayout)HomeView.findViewById(R.id.RelativeLayout);
        vg_ViewPager = (ViewPager)HomeView.findViewById(R.id.vg_ViewPager);
        linearLayout = (LinearLayout)HomeView.findViewById(R.id.LinearLayout);
    }

    public ImageView imgData(int i) {
        ImageView imgview = new ImageView(getContext());
        img = new int[] { R.drawable.ten, R.drawable.two};
        switch (i) {
            case 1:
                imgview.setImageResource(img[0]);
                break;
            case 2:
                imgview.setImageResource(img[1]);
                break;
            default:
                break;
        }
        return imgview;
    }

//    public void setview() {
//        final List<View> vplist = new ArrayList<View>();// 存放视图的容器
//        for (int i = 0; i < 5; i++) {
//            vplist.add(imgData(i + 1));
//        }
//        // vplist.add(data(1));
//        // vplist.add(data(2));
//        vg.setAdapter(new AdapteHome(vplist));// 适配器做了更改
//        vg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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






}
