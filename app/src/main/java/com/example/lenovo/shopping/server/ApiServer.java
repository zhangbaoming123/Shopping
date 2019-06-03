package com.example.lenovo.shopping.server;

import com.example.lenovo.shopping.bean.ShopBean;
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;
import com.example.lenovo.shopping.fragment.home.bean.LikeBean;
import com.example.lenovo.shopping.fragment.home.bean.MiaoBean;
import com.example.lenovo.shopping.fragment.home.bean.PingpaiBean;
import com.example.lenovo.shopping.fragment.home.bean.RenBean;
import com.example.lenovo.shopping.fragment.home.bean.XinxainBean;
import com.example.lenovo.shopping.fragment.home.bean.ZhuanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {

    //http://47.92.105.146:8002/category
    String api = "http://47.92.105.146:8002/";

    //分类
    @GET("brand")
    Observable<ClassifyReBean> getCla();

    //品牌
    @GET("brand")
    Observable<PingpaiBean> getPing();

    //秒杀
    @GET("ceckil_goods")
    Observable<MiaoBean> getMiao();

    //新鲜
    @GET("fresgh_goods")
    Observable<XinxainBean> getXin();

    //购物车
    @GET("sentiment")
    Observable<ShopBean> getShop();

    //人气
    @GET("sentiment")
    Observable<RenBean> getRen();

    //人气
    @GET("youxuan")
    Observable<ZhuanBean> getZhuan();

    //人气
    @GET("you_like")
    Observable<LikeBean> getLike();



}
