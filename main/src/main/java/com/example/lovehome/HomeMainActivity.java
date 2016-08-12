package com.example.lovehome;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.adapter.AdapteHome;

import java.util.ArrayList;
import java.util.List;

public class HomeMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
//        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
//   com.example.lovehome.HomeFragment homeFragment=new com.example.lovehome.HomeFragment();
//        ft.replace(R.id.ly,homeFragment,"ss");
//        ft.commit();
    }


}
