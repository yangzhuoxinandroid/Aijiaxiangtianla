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

public class MyxgyhnameActivity extends AppCompatActivity {
    Button btn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myxgyhname);
        btn= (Button) findViewById(R.id.xgyhm_btn);
        editText= (EditText) findViewById(R.id.xgyhm_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkData.getInstance().getupdateUser(StaticDataEntity.loginentity.getUser_id(),editText.getText().toString() , StaticDataEntity.updateUserEntity.getMobile(),StaticDataEntity.updateUserEntity.getContact_site(),
                        new Callback.CommonCallback<String>() {

                    @Override
                    public void onSuccess(String s) {
                        Log.v("用户名称：", "数据：" + s);
                        Gson gson = new Gson();
                        UpdateUserEntity json= gson.fromJson(s, UpdateUserEntity.class);
                        if (json.getResult() == 200) {
                            StaticDataEntity.updateUserEntity = json;//实体类保存静态变量
                            Intent intent = new Intent(MyxgyhnameActivity.this, MyyhzlActivity.class);
                           // intent.putExtra("name",editText.getText().toString());
                            startActivity(intent);

                            finish();
                            Toast.makeText(MyxgyhnameActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MyxgyhnameActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
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
