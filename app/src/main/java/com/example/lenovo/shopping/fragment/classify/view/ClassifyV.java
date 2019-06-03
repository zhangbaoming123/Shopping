package com.example.lenovo.shopping.fragment.classify.view;

import com.example.lenovo.shopping.base.BaseView;
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;

public interface ClassifyV extends BaseView {
    void onSucces(ClassifyReBean da);
    void onFails(String s);
}
