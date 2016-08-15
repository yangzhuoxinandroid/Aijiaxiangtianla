package com.example.adapter;


import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.entity.CategoryEntity;
import com.example.lovehome.R;

public class Popwindow01Adapter extends BaseAdapter {

    private List<CategoryEntity.ListBean> objects ;

    private Context context;
    private LayoutInflater layoutInflater;

    public Popwindow01Adapter(Context context,List<CategoryEntity.ListBean> objects) {
        this.objects=objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        Log.e("Popwindow01Adapter", "泡泡窗口数据的长度"+objects.size());
        return objects.size();
    }

    @Override
    public CategoryEntity.ListBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.popwindow_01, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((CategoryEntity.ListBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(CategoryEntity.ListBean object, ViewHolder holder) {
        //TODO implement
     holder.tvLeft.setText(object.getParent_cate_name());
    }

    protected class ViewHolder {
        private TextView tvLeft;

        public ViewHolder(View view) {
            tvLeft = (TextView) view.findViewById(R.id.tv_left);
        }
    }
}
