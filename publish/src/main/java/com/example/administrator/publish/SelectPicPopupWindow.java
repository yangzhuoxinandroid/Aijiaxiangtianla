package com.example.administrator.publish;

import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.List;
import android.widget.PopupWindow;

import com.google.gson.Gson;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2016/8/15.
 */
public class SelectPicPopupWindow extends PopupWindow{
    private Button btn_take_photo, btn_pick_photo;
    private ImageView btn_cancel;
    private View mMenuView;
    public List<listviewEntity.ListBean.ChildCategoryListBean> list;
    ListView listView;
    LvadapterAdapter adapter;
    public SelectPicPopupWindow(final Activity context,AdapterView.OnItemClickListener itemsOnClick) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.alert_dialog, null);
        LinearLayout layout=(LinearLayout)mMenuView.findViewById(R.id.pop_layout);
        btn_cancel = (ImageView) mMenuView.findViewById(R.id.btn_cancel);
        listView=(ListView)mMenuView.findViewById(R.id.lv_pop);
        listView.setOnItemClickListener(itemsOnClick);
        net.getInstance().getdata(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                Log.v("s", s);
                listviewEntity json = gson.fromJson(s, listviewEntity.class);
                staticclass.list = json;
                list = json.getList().get(staticclass.position).getChildCategoryList();
                adapter = new LvadapterAdapter(context, list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(Callback.CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });



        //取消按钮
        btn_cancel.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                //销毁弹出框
                dismiss();
            }
        });
        //设置按钮监听
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(animationSet);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }


}
