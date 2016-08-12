package com.example.adapter;

import java.util.List;
import com.example.entity.LunboEntity;
import com.example.lovehome.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeGvAdapter extends BaseAdapter{
	public	List<LunboEntity> list;
	public  LayoutInflater inflater;

	public HomeGvAdapter(List<LunboEntity> list,Context context){
		inflater=LayoutInflater.from(context);
		 this.list=list;
	}
	@Override
	public int getCount() {
		return list.size();
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
		Homeview h=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.shouye, null);
			h=new Homeview();
			h.ivName=(ImageView) convertView.findViewById(R.id.img_first);
			h.txName=(TextView) convertView.findViewById(R.id.tv_first);
			convertView.setTag(h);
		}else{
			h=(Homeview) convertView.getTag();
		}
		LunboEntity gv=list.get(position);
		h.txName.setText(gv.getName());
		h.ivName.setImageResource(gv.getImage());
		return convertView;
	}
	public class Homeview{
		ImageView ivName;
		TextView txName;
	}
}
  