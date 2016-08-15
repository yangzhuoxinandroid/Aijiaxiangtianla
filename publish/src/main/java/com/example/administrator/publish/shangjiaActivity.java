package com.example.administrator.publish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class shangjiaActivity extends AppCompatActivity {
       TextView titie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangjia);
        titie=(TextView)findViewById(R.id.title_changle);
        Intent intent=getIntent();
        String string=intent.getStringExtra("s");
        titie.setText(string);
    }
}
