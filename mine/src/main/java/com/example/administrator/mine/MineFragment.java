package com.example.administrator.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

//    public void MyOnclick(View view) {
//        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//        int i = view.getId();
//        //点击登录
//        if (i == R.id.wode_qingdenglu) {
//            LoginFragment  loginFragment = new LoginFragment();
//            ft.replace(R.id.conten,loginFragment,"Introduce");
//            ft.commit();
//        }
//        //我的发布
//        else if (i == R.id.wode_fabu){
//
//        }
//        //我的草稿
//        else if (i == R.id.wode_caogao){
//
//        }
//        //我的收藏
//        else if (i == R.id.wode_shoucang){
//
//        }
//        //我的消息
//        else if (i == R.id.wode_xiaoxi){
//
//        }
//        //平台声明
//        else if (i == R.id.wode_shengming){
//
//        }
//        //关于爱家乡
//        else if (i == R.id.wode_aijiaxiang){
//
//        }
//        //分享软件
//        else if (i == R.id.wode_fenxiang){
//
//        }
//        //修改密码
//        else if (i == R.id.wode_xiugaimima){
//
//        }
//        //清除缓存
//        else if (i == R.id.wode_qingchuhuancun){
//
//        }
//        //退出登录
//        else if (i == R.id.wode_tuichudenglu){
//
//        }
//    }
}
