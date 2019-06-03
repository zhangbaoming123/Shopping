package com.example.lenovo.shopping.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        presenter = initPresenter();
        ButterKnife.bind(this);
        if (presenter != null) {
            presenter.bind(this);
        }
        initView();
        initData();
        initListener();
    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected abstract P initPresenter();

    protected abstract int getLayoutId();
}
