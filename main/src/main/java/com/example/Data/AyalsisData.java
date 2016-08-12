package com.example.Data;


import com.example.entity.CityEntity;
import com.example.entity.ListViewEntity;
import com.google.gson.Gson;

/**
 * Created by 文头头 on 2016/7/3.
 */
public class AyalsisData {


//    public LookSEntity Sample_extrection(String data){
//        Gson gson=new Gson();
//        LookSEntity updateSEntity=gson.fromJson(data,LookSEntity.class);
//        return updateSEntity;
//    }

    public CityEntity getCity(String data){
        Gson gson=new Gson();
        CityEntity cityEntity=gson.fromJson(data,CityEntity.class);
        return cityEntity;
    }
//查询发布信息
    public ListViewEntity informationData(String information){
        Gson gson=new Gson();
        ListViewEntity listViewEntity=gson.fromJson(information,ListViewEntity.class);
        return listViewEntity;
    }


}
