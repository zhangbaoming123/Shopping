package com.example.lenovo.shopping.view;

import com.example.lenovo.shopping.base.BaseView;
import com.example.lenovo.shopping.bean.ShopBean;

public interface ShopV extends BaseView {
    void onSucces(ShopBean bean);

    void onFails(String data);
}
