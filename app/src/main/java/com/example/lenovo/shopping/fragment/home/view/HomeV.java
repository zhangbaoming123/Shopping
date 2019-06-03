package com.example.lenovo.shopping.fragment.home.view;

import com.example.lenovo.shopping.base.BaseView;
import com.example.lenovo.shopping.fragment.home.bean.LikeBean;
import com.example.lenovo.shopping.fragment.home.bean.MiaoBean;
import com.example.lenovo.shopping.fragment.home.bean.PingpaiBean;
import com.example.lenovo.shopping.fragment.home.bean.RenBean;
import com.example.lenovo.shopping.fragment.home.bean.XinxainBean;
import com.example.lenovo.shopping.fragment.home.bean.ZhuanBean;

public interface HomeV extends BaseView {
 void onSucces(PingpaiBean bean);
 void onSucces(MiaoBean bean);
 void onXinSucces(XinxainBean bean);
 void onRenSucces(RenBean bean);
 void onzhuanSucces(ZhuanBean bean);
 void onLikeSucces(LikeBean bean);
 void onFails(String s);
}
