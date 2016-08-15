package com.example.administrator.mine.Wode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mine.Entity.StaticDataEntity;
import com.example.administrator.mine.Entity.UpdateUserEntity;
import com.example.administrator.mine.Network.NetworkData;
import com.example.administrator.mine.R;
import com.google.gson.Gson;

import org.xutils.common.Callback;

public class MyxglxdizhiActivity extends AppCompatActivity {
    Button btn;
    EditText editText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myxglxdizhi);
        btn = (Button) findViewById(R.id.xgdz_btn);
        editText = (EditText) findViewById(R.id.xgdz_text);
          final String xgdz=editText.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkData.getInstance().getupdateUser(StaticDataEntity.updateUserEntity.getUser_id(), StaticDataEntity.updateUserEntity.getUser_name(), StaticDataEntity.updateUserEntity.getMobile(),xgdz,
                        new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String s) {
                                Log.v("联系地址：", "数据：" + s);
                                Gson gson = new Gson();
                                UpdateUserEntity json = gson.fromJson(s, UpdateUserEntity.class);
                                if (json.getResult() == 200) {
                                    StaticDataEntity.updateUserEntity = json;//实体类保存静态变量
                                    Intent intent = new Intent(MyxglxdizhiActivity.this, MyyhzlActivity.class);
                                    intent.putExtra("修改地址",xgdz);
                                    startActivity(intent);
                                   finish();
                                    Toast.makeText(MyxglxdizhiActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MyxglxdizhiActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(Throwable throwable, boolean b) {

                            }

                            @Override
                            public void onCancelled(CancelledException e) {

                            }

                            @Override
                            public void onFinished() {

                            }
                        });
            }
        });
    }
}
