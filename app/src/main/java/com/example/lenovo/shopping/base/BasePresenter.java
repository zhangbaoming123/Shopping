package com.example.lenovo.shopping.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    public ArrayList<BaseMode> mModel = new ArrayList<>();

    public void bind(V v) {
        this.mView = v;
    }

    public void BasePresenter() {
        initModel();
    }

    protected abstract void initModel();


}
