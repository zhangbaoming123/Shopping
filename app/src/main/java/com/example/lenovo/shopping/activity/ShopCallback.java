package com.example.lenovo.shopping.activity;

import com.example.lenovo.shopping.bean.ShopBean;

public interface ShopCallback<T> {
    void onSucces(T bean);
    void onFails(String s);
}
