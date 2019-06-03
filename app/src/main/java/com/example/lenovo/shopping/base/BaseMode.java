package com.example.lenovo.shopping.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseMode {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void onDestory() {
        compositeDisposable.clear();
    }
}
