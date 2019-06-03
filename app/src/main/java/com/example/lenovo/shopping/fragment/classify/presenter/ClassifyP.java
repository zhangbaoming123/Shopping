package com.example.lenovo.shopping.fragment.classify.presenter;

import com.example.lenovo.shopping.base.BasePresenter;
import com.example.lenovo.shopping.base.ResultCallBack;
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;
import com.example.lenovo.shopping.fragment.classify.model.ClassifyM;
import com.example.lenovo.shopping.fragment.classify.view.ClassifyV;

public class ClassifyP extends BasePresenter<ClassifyV> {

    private ClassifyM classifyM;

    @Override
    protected void initModel() {
        classifyM = new ClassifyM();
        mModel.add(classifyM);
    }

    public void getData() {
        classifyM.getData(new ResultCallBack<ClassifyReBean>() {
            @Override
            public void onSucces(ClassifyReBean bean) {
                mView.onSucces(bean);
            }

            @Override
            public void onFails(String data) {
                mView.onFails(data);
            }
        });
    }
}
