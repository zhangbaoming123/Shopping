package com.example.lenovo.shopping.base;

public interface ResultCallBack<T> {
    void onSucces(T bean);
    void onFails(String data);

}
