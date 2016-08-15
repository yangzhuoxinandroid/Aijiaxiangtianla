package com.example.administrator.publish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.x;

public class publishActivity extends AppCompatActivity {
    GridView grid;
    int[] img=new int[]{R.drawable.meishi, R.drawable.yule,R.drawable.fangchan, R.drawable.che, R.drawable.hunqing,R.drawable.zhuangxiu, R.drawable.jiaoyu,R.drawable.gongzuo,R.drawable.baihuo
            ,R.drawable.tiaozhao,R.drawable.shangwu,R.drawable.bianmin,R.drawable.laoxianghui,R.drawable.qita};
    String[] name=new String[]{"美食","娱乐","房产","车","婚庆","装修","教育","工作","百货","跳蚤","商务","便民","老乡会","其他"};
    SelectPicPopupWindow menuWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        x.view().inject(this);
        grid= (GridView) findViewById(R.id.grid_one);
        grid.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return img.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = LayoutInflater.from(publishActivity.this).inflate(R.layout.fabu_view, null);
                ImageView gridView_image = (ImageView) convertView.findViewById(R.id.iv_img);
                TextView gridView_text = (TextView) convertView.findViewById(R.id.iv_name);
                gridView_image.setImageResource(img[position]);
                gridView_text.setText(name[position]);
                return convertView;
            }
        });


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                staticclass.position = position;
                staticclass.pop = 1;
                //实例化SelectPicPopupWindow
                menuWindow = new SelectPicPopupWindow(publishActivity.this, itemsOnClick);
//                显示窗口
                menuWindow.showAtLocation(publishActivity.this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

            }
        });

    }

    //为弹出窗口实现监听类
    public AdapterView.OnItemClickListener itemsOnClick=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            menuWindow.dismiss();

            Toast.makeText(publishActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            String string = staticclass.list.getList().get(staticclass.position).getChildCategoryList().get(position).getChild_category_name();
            Log.v("sss", string);
            intent.putExtra("s", string);
            intent.setClass(publishActivity.this, shangjiaActivity.class);
            startActivity(intent);
        }

    };
}
