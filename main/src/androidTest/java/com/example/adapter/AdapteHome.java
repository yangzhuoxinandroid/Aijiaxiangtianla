package com.example.adapter;

import java.util.List;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class AdapteHome extends PagerAdapter {
	List<View> vpList;
	public AdapteHome(List<View> vpList) {
		this.vpList = vpList;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(vpList.get(position%vpList.size()));
		//container.removeView(vpList.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
	container.addView(vpList.get(position%vpList.size()));
		//container.addView(vpList.get(position));
		
		return vpList.get(position%vpList.size());
		//return vpList.get(position);
	}
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
		//return vpList.size();
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

}
