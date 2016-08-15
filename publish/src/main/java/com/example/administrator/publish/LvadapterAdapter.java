package com.example.administrator.publish;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/15.
 */
public class LvadapterAdapter extends BaseAdapter {
    private List<listviewEntity.ListBean.ChildCategoryListBean> objects = new ArrayList<listviewEntity.ListBean.ChildCategoryListBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public LvadapterAdapter(Context context,List<listviewEntity.ListBean.ChildCategoryListBean> objects) {
        this.context = context;
        this.objects=objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public listviewEntity.ListBean.ChildCategoryListBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.lvadapter, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((listviewEntity.ListBean.ChildCategoryListBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(listviewEntity.ListBean.ChildCategoryListBean object, ViewHolder holder) {
        holder.popTv.setText(object.getChild_category_name());
    }

    protected class ViewHolder {
        private TextView popTv;

        public ViewHolder(View view) {
            popTv = (TextView) view.findViewById(R.id.pop_tv);
        }
    }
}
