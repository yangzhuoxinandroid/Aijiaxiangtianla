package com.example.handler;

import com.example.lovehome.HomeFragment;

public class Xiancheng implements Runnable {

	@Override
	public void run() {
		HomeFragment homeFragment=new HomeFragment();
		homeFragment.init();
		homeFragment.setview();
	}

}
