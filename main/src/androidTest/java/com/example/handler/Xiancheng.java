package com.example.handler;

import com.example.lovehome.HomeMainActivity;

public class Xiancheng implements Runnable {

	@Override
	public void run() {
		HomeMainActivity homeMainActivity=new HomeMainActivity();
		homeMainActivity.init();
		homeMainActivity.setview();
	}

}
