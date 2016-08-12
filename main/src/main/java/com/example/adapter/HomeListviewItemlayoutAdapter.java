package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entity.ListItemEntity;
import com.example.lovehome.R;

public class HomeListviewItemlayoutAdapter extends BaseAdapter {

    private List<ListItemEntity> objects;

    private Context context;
    private LayoutInflater layoutInflater;

    public HomeListviewItemlayoutAdapter(Context context,List<ListItemEntity> objects) {
        this.context = context;
        this.objects=objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public ListItemEntity getItem(int position) {
        return objects.get(position);
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
        initializeViews((ListItemEntity)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(ListItemEntity object, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
    private LinearLayout listviewItemLinearLayout;
    private ImageView listviewItemImg;
    private TextView listviewItemTextview;
    private TextView listviewItemMoney;
    private ImageView imgPhone;
    private TextView listviewItemAddress;
    private TextView itemAddress;
    private TextView openTime;
    private TextView endTime;

        public ViewHolder(View view) {
            listviewItemLinearLayout = (LinearLayout) view.findViewById(R.id.listview_item_LinearLayout);
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
