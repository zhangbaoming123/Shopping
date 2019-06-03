package com.example.lenovo.shopping.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter> extends Fragment implements BaseView {

    private Unbinder bind;
    public P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        bind = ButterKnife.bind(this, inflate);
        presenter = initPresenter();
        presenter.BasePresenter();
        if (presenter != null){
            presenter.bind((V)this);
        }
        initView();
        initData();
        initLisenter();
        return inflate;
    }

    protected void initLisenter() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
