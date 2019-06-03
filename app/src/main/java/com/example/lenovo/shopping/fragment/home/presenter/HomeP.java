package com.example.lenovo.shopping.fragment.home.presenter;

import com.example.lenovo.shopping.R;
import com.example.lenovo.shopping.base.BasePresenter;
import com.example.lenovo.shopping.base.ResultCallBack;
import com.example.lenovo.shopping.fragment.home.bean.LikeBean;
import com.example.lenovo.shopping.fragment.home.bean.MiaoBean;
import com.example.lenovo.shopping.fragment.home.bean.PingpaiBean;
import com.example.lenovo.shopping.fragment.home.bean.RenBean;
import com.example.lenovo.shopping.fragment.home.bean.XinxainBean;
import com.example.lenovo.shopping.fragment.home.bean.ZhuanBean;
import com.example.lenovo.shopping.fragment.home.model.HomeM;
import com.example.lenovo.shopping.fragment.home.view.HomeV;

public class HomeP extends BasePresenter<HomeV> {

    private HomeM homeM;

    @Override
    protected void initModel() {

        homeM = new HomeM();
        mModel.add(homeM);
    }

    public void getPing() {
        homeM.getPingPai(new ResultCallBack<PingpaiBean>() {
            @Override
            public void onSucces(PingpaiBean bean) {
                mView.onSucces(bean);
            }

            @Override
            public void onFails(String data) {
                mView.onFails(data);
            }
        });
    }

    public void getMiao() {
        homeM.getMiao(new ResultCallBack<MiaoBean>() {
            @Override
            public void onSucces(MiaoBean bean) {
                mView.onSucces(bean);
            }

            @Override
            public void onFails(String data) {
                mView.onFails(data);
            }
        });
    }

    public void getXin() {
        homeM.getXin(new ResultCallBack<XinxainBean>() {
            @Override
            public void onSucces(XinxainBean bean) {
                mView.onXinSucces(bean);
            }

            @Override
            public void onFails(String data) {
                mView.onFails(data);
            }
        });
    }

    public void getRen() {
        homeM.getRen(new ResultCallBack<RenBean>() {
            @Override
            public void onSucces(RenBean bean) {
                mView.onRenSucces(bean);
            }

            @Override
            public void onFails(String data) {
                mView.onFails(data);
            }
        });
    }

    public void getZhuan() {
        homeM.getZhuan(new ResultCallBack<ZhuanBean>() {
            @Override
            public void onSucces(ZhuanBean bean) {
                mView.onzhuanSucces(bean);
            }

            @Override
            public void onFails(String data) {

                mView.onFails(data);
            }
        });
    }

    public void getCai() {
        homeM.getCai(new ResultCallBack<LikeBean>() {
            @Override
            public void onSucces(LikeBean bean) {
                mView.onLikeSucces(bean);
            }

            @Override
            public void onFails(String data) {
                mView.onFails(data);
            }
        });
    }
}
