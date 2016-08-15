package com.example.adapter;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entity.CategoryEntity;
import com.example.entity.ListViewEntity;
import com.example.lovehome.R;

import org.xutils.x;

public class HomeListviewItemlayoutAdapter extends BaseAdapter {

    private List<ListViewEntity.ListBean> like;
    Handler handler;
    private Context context;
    private LayoutInflater layoutInflater;

    public HomeListviewItemlayoutAdapter(Context context,List<ListViewEntity.ListBean> like,Handler handler) {
        this.context = context;
        this.handler=handler;
        this.like=like;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return like.size();
    }

    @Override
    public ListViewEntity.ListBean getItem(int position) {
        return like.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.home_listview_itemlayout, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((ListViewEntity.ListBean)getItem(position), (ViewHolder) convertView.getTag(),position);
        return convertView;
    }

    private void initializeViews(final ListViewEntity.ListBean object, ViewHolder holder, int i) {
        //TODO implement
        String url="http://p0.meituan.net/320.0.a/deal/602f0d65070e5973c85aabff0fb6c6ac60545.jpg";
        x.image().bind(holder.listviewItemImg,url);
        holder.listviewItemTextview.setText(object.getMerchant_name());
        holder.listviewItemMoney.setText("￥"+object.getPer_capita_consumption()+"/起");
        holder.listviewItemAddress.setText(object.getBusiness_location());

        holder.imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message=new Message();
                message.what=1;
                message.obj=object.getPhone();
                handler.sendMessage(message);
            }
        });


    }

    protected class ViewHolder {
    private ImageView listviewItemImg;
    private TextView listviewItemTextview;
    private TextView listviewItemMoney;
    private ImageView imgPhone;
    private TextView listviewItemAddress;
    private TextView itemAddress;
    private TextView openTime;
    private TextView endTime;

        public ViewHolder(View view) {
            listviewItemImg = (ImageView) view.findViewById(R.id.listview_item_Img);
            listviewItemTextview = (TextView) view.findViewById(R.id.listview_item_textview);
            listviewItemMoney = (TextView) view.findViewById(R.id.listview_item_money);
            imgPhone = (ImageView) view.findViewById(R.id.img_phone);
            listviewItemAddress = (TextView) view.findViewById(R.id.listview_item_address);
            itemAddress = (TextView) view.findViewById(R.id.item_address);
            openTime = (TextView) view.findViewById(R.id.open_time);
            endTime = (TextView) view.findViewById(R.id.end_time);
        }
    }
}
