package com.example.administrator.aijiaxiangtianla;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mine.MineActivity;
//import com.example.fragment.HomeFragment;
import com.example.lovehome.HomeMainActivity;

import java.net.InterfaceAddress;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getActionBar().hide();  //去掉标题栏

        setContentView(R.layout.activity_main);

        LayoutInflater inflater =LayoutInflater.from(this);
        TabHost host=getTabHost();
        TabHost.TabSpec t1=host.newTabSpec("爱家乡");
        View view1=inflater.inflate(R.layout.cone, null);
        TextView tv1=(TextView) view1.findViewById(R.id.TV2);
        tv1.setText("爱家乡");
        ImageView iv1=(ImageView) view1.findViewById(R.id.TV1);
        iv1.setImageResource(R.drawable.shouye);
        t1.setIndicator(view1);
        //选中的时候显示哪个界面
        t1.setContent(new Intent(this, HomeMainActivity.class));
        host.addTab(t1);

//        TabHost.TabSpec t2=  host.newTabSpec("发布");//创建一个选项卡，参数：就只是一个标记没有任何意义
//        //给文字或者图标
//        View view2=inflater.inflate(R.layout.cone, null);
//        TextView tv2=(TextView) view2.findViewById(R.id.TV2);
//        tv2.setText("发布");
//        ImageView iv2=(ImageView) view2.findViewById(R.id.TV1);
//        iv2.setImageResource(R.drawable.fabu);
//        t2.setIndicator(view2);
//        //选中的时候显示哪个界面
////        t2.setContent(new Intent(this,BusinessMainActivity.class));
//        host.addTab(t2);


        TabHost.TabSpec t3=  host.newTabSpec("我的");//创建一个选项卡，参数：就只是一个标记没有任何意义
        //给文字或者图标
        View view3=inflater.inflate(R.layout.cone, null);
        TextView tv3=(TextView) view3.findViewById(R.id.TV2);
        tv3.setText("我的");
        ImageView iv3=(ImageView) view3.findViewById(R.id.TV1);
        iv3.setImageResource(R.drawable.wode);
        t3.setIndicator(view3);
        //选中的时候显示哪个界面
        t3.setContent(new Intent(this,MineActivity.class));
        host.addTab(t3);
    }



}
