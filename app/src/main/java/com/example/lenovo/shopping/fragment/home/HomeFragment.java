package com.example.lenovo.shopping.fragment.home;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.shopping.R;
import com.example.lenovo.shopping.base.BaseFragment;
import com.example.lenovo.shopping.fragment.home.adapter.Home_RenReAdapter;
import com.example.lenovo.shopping.fragment.home.adapter.Home_ZhuanReAdapter;
import com.example.lenovo.shopping.fragment.home.adapter.Home_miaoReAdapter;
import com.example.lenovo.shopping.fragment.home.adapter.Home_pingReAdapter;
import com.example.lenovo.shopping.fragment.home.adapter.Home_xinReAdapter;
import com.example.lenovo.shopping.fragment.home.bean.BannerBean;
import com.example.lenovo.shopping.fragment.home.bean.LikeBean;
import com.example.lenovo.shopping.fragment.home.bean.MiaoBean;
import com.example.lenovo.shopping.fragment.home.bean.PingpaiBean;
import com.example.lenovo.shopping.fragment.home.bean.RenBean;
import com.example.lenovo.shopping.fragment.home.bean.XinxainBean;
import com.example.lenovo.shopping.fragment.home.bean.ZhuanBean;
import com.example.lenovo.shopping.fragment.home.presenter.HomeP;
import com.example.lenovo.shopping.fragment.home.view.HomeV;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomeV, HomeP> implements HomeV {

    @BindView(R.id.home_banner)
    Banner homeBanner;
    Unbinder unbinder;
    @BindView(R.id.home_re)
    RecyclerView ping_re;
    @BindView(R.id.miao_re)
    RecyclerView miao_re;
    @BindView(R.id.xin_re)
    RecyclerView xian_re;
    @BindView(R.id.renqi_re)
    RecyclerView ren_re;
    @BindView(R.id.zhuan)
    RecyclerView zhuan_re;
    @BindView(R.id.like_Re)
    RecyclerView like_re;
    private GridLayoutManager manager;
    private ArrayList<PingpaiBean.DlistBean> dlistBeans;
    private Home_pingReAdapter pingReAdapter;
    private ArrayList<MiaoBean.DlistBean> miaobean;
    private Home_miaoReAdapter miaoReAdapter;
    private ArrayList<XinxainBean.ListBean> xinlist;
    private Home_xinReAdapter xinReAdapter;
    private ArrayList<RenBean.DlistBean> renBean;
    private Home_RenReAdapter renadapter;
    private ArrayList<ZhuanBean.DlistBean> zhuanlist;
    private Home_ZhuanReAdapter zhuanReAdapter;

    @Override
    protected HomeP initPresenter() {
        return new HomeP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        initBanner();

        //品牌
        initPing();
        //秒杀
        initMiao();
        //新鲜
        initXin();
        //人气
        initRen();
        //专题
        initZhuan();
        //猜你喜欢
        initCai();

    }

    @Override
    protected void initData() {
        //品牌
        presenter.getPing();
        //秒杀
        presenter.getMiao();
        //新鲜
        presenter.getXin();
        //人气
        presenter.getRen();
        //专题
        presenter.getZhuan();
        //猜你喜欢
        presenter.getCai();
    }

    private void initBanner() {
        ArrayList<BannerBean> bean = new ArrayList<>();
        homeBanner.setImages(bean)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BannerBean.DlistBean banner = (BannerBean.DlistBean) path;
                        Glide.with(context).load(banner.getPic()).into(imageView);
                    }
                }).setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //品牌
    private void initPing() {
        dlistBeans = new ArrayList<>();
        manager = new GridLayoutManager(getContext(), 2);
        ping_re.setLayoutManager(manager);
        pingReAdapter = new Home_pingReAdapter(dlistBeans, getContext());
        ping_re.setAdapter(pingReAdapter);
    }

    @Override
    public void onSucces(PingpaiBean bean) {
        List<PingpaiBean.DlistBean> dlist = bean.getDlist();
        dlistBeans.addAll(dlist);
        pingReAdapter.setList(dlistBeans);
        pingReAdapter.notifyDataSetChanged();
    }

    //秒杀
    private void initMiao() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        miao_re.setLayoutManager(gridLayoutManager);
        miaobean = new ArrayList<>();
        miaoReAdapter = new Home_miaoReAdapter(miaobean, getContext());
        miao_re.setAdapter(miaoReAdapter);
    }

    @Override
    public void onSucces(MiaoBean bean) {
        List<MiaoBean.DlistBean> dlist = bean.getDlist();
        miaobean.addAll(dlist);
        miaoReAdapter.setList(miaobean);
        miaoReAdapter.notifyDataSetChanged();
    }


    //新鲜
    private void initXin() {
        GridLayoutManager xianmanger = new GridLayoutManager(getContext(), 2);
        xian_re.setLayoutManager(xianmanger);
        xinlist = new ArrayList<>();
        xinReAdapter = new Home_xinReAdapter(xinlist, getContext());
        xian_re.setAdapter(xinReAdapter);
    }

    @Override
    public void onXinSucces(XinxainBean bean) {
        List<XinxainBean.ListBean> list = bean.getList();
        xinlist.addAll(list);
        xinReAdapter.setListBeans(xinlist);
        xinReAdapter.notifyDataSetChanged();
    }


    //人气
    private void initRen() {
        renBean = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        ren_re.setLayoutManager(manager);
        renadapter = new Home_RenReAdapter(renBean, getContext());
        ren_re.setAdapter(renadapter);


    }
    @Override
    public void onRenSucces(RenBean bean) {
        List<RenBean.DlistBean> ren = bean.getDlist();
        renBean.addAll(ren);
        renadapter.setRenlist(renBean);
        renadapter.notifyDataSetChanged();
    }



    //专题
    private void initZhuan() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        zhuan_re.setLayoutManager(manager);
        zhuanlist = new ArrayList<>();
        zhuanReAdapter = new Home_ZhuanReAdapter(zhuanlist, getContext());
        zhuan_re.setAdapter(zhuanReAdapter);
    }
    @Override
    public void onzhuanSucces(ZhuanBean bean) {
        List<ZhuanBean.DlistBean> dlist = bean.getDlist();
        zhuanlist.addAll(dlist);
        zhuanReAdapter.setList(zhuanlist);
        zhuanReAdapter.notifyDataSetChanged();

    }

    private void initCai() {
        GridLayoutManager caimanger = new GridLayoutManager(getContext(), 2);
        like_re.setLayoutManager(caimanger);


    }
    @Override
    public void onLikeSucces(LikeBean bean) {

    }

    @Override
    public void onFails(String s) {
        Log.i(TAG, "onFails: " + s);
    }
}
