package com.example.lenovo.shopping.fragment.home.model;

import com.example.lenovo.shopping.base.BaseMode;
import com.example.lenovo.shopping.base.ResultCallBack;
import com.example.lenovo.shopping.bean.ShopBean;
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;
import com.example.lenovo.shopping.fragment.home.bean.LikeBean;
import com.example.lenovo.shopping.fragment.home.bean.MiaoBean;
import com.example.lenovo.shopping.fragment.home.bean.PingpaiBean;
import com.example.lenovo.shopping.fragment.home.bean.RenBean;
import com.example.lenovo.shopping.fragment.home.bean.XinxainBean;
import com.example.lenovo.shopping.fragment.home.bean.ZhuanBean;
import com.example.lenovo.shopping.server.ApiServer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeM extends BaseMode {
    public void getPingPai(final ResultCallBack<PingpaiBean> back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<PingpaiBean> ping = server.getPing();
        ping.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PingpaiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(PingpaiBean pingpaiBean) {
                        back.onSucces(pingpaiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        back.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getMiao(final ResultCallBack<MiaoBean> back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<MiaoBean> ping = server.getMiao();
        ping.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MiaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(MiaoBean miaoBean) {
                        back.onSucces(miaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        back.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getXin(final ResultCallBack<XinxainBean> back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<XinxainBean> xin = server.getXin();
        xin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XinxainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(XinxainBean xinxainBean) {
                        back.onSucces(xinxainBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        back.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getRen(final ResultCallBack<RenBean> callBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<RenBean> ren = server.getRen();
        ren.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(RenBean shopBean) {
                        callBack.onSucces(shopBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getZhuan(final ResultCallBack<ZhuanBean> back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<ZhuanBean> ren = server.getZhuan();
        ren.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ZhuanBean zhuanBean) {
                        back.onSucces(zhuanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        back.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getCai(final ResultCallBack<LikeBean> back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<LikeBean> ren = server.getLike();
        ren.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LikeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LikeBean likeBean) {
                        back.onSucces(likeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        back.onFails(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
