package com.example.administrator.aijiaxiangtianla;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.mine.MineActivity;
import com.example.lovehome.HomeMainActivity;

import java.net.InterfaceAddress;

public class MainActivity extends AppCompatActivity {
   RadioGroup  rg_radiogroup;
    FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_radiogroup=(RadioGroup)findViewById(R.id.rg_radiogroup);
        Toast.makeText(MainActivity.this, "333", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent();
        intent.setClass(MainActivity.this, HomeMainActivity.class);
        startActivity(intent);
    }
    public void click(){
        rg_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main :
                        Toast.makeText(MainActivity.this, "333", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this,HomeMainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.publish:

                        break;
                    case R.id.mine:
                        Intent intent1=new Intent();
                        intent1.setClass(MainActivity.this, MineActivity.class);
                        startActivity(intent1);
                        break;
                }
            }
        });


    }


}
