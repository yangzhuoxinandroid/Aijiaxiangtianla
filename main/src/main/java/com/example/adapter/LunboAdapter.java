package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


public class LunboAdapter extends PagerAdapter{
	public List<View> vp;
	public LunboAdapter(List<View> vp){
		this.vp=vp;
	}
	
	public int getCount() {
		return vp.size();
	}

	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	public void destroyItem(ViewGroup container, int position, Object object) {
		 container.removeView(vp.get(position));
	}

	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(vp.get(position));
		return vp.get(position);
	}
	

}
