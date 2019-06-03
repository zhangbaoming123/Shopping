package com.example.lenovo.shopping.model;

import com.example.lenovo.shopping.activity.ShopCallback;
import com.example.lenovo.shopping.base.BaseMode;
import com.example.lenovo.shopping.base.ResultCallBack;
import com.example.lenovo.shopping.bean.ShopBean;
import com.example.lenovo.shopping.server.ApiServer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShopM extends BaseMode {
    public void getDa(final ShopCallback<ShopBean> back) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.api)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        Observable<ShopBean> shop = server.getShop();
        shop.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ShopBean shopBean) {
                        back.onSucces(shopBean);
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
