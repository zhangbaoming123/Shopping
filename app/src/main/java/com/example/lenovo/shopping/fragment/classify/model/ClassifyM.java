package com.example.lenovo.shopping.fragment.classify.model;

import com.example.lenovo.shopping.base.BaseMode;
import com.example.lenovo.shopping.base.ResultCallBack;
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;
import com.example.lenovo.shopping.server.ApiServer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClassifyM extends BaseMode {
    public void getData(final ResultCallBack<ClassifyReBean> back) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.api)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer server = retrofit.create(ApiServer.class);
        final Observable<ClassifyReBean> cla = server.getCla();
        cla.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassifyReBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(ClassifyReBean classifyReBean) {
                        back.onSucces(classifyReBean);
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
