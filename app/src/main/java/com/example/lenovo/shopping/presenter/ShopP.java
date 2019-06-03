package com.example.lenovo.shopping.presenter;

import com.example.lenovo.shopping.activity.ShopCallback;
import com.example.lenovo.shopping.base.BasePresenter;
import com.example.lenovo.shopping.base.ResultCallBack;
import com.example.lenovo.shopping.bean.ShopBean;
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;
import com.example.lenovo.shopping.model.ShopM;
import com.example.lenovo.shopping.view.ShopV;

public class ShopP extends BasePresenter<ShopV> {

    private ShopM shopM;

    @Override
    protected void initModel() {
        shopM = new ShopM();
        mModel.add(shopM);
    }

    public void getData() {
        shopM.getDa(new ShopCallback<ShopBean>() {
            @Override
            public void onSucces(ShopBean bean) {
                mView.onSucces(bean);
            }

            @Override
            public void onFails(String s) {

            }
        });
    }
}
