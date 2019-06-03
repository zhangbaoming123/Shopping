package com.example.lenovo.shopping.fragment.my;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lenovo.shopping.R;
import com.example.lenovo.shopping.activity.my.GuanActivity;
import com.example.lenovo.shopping.activity.my.HeaderActivity;
import com.example.lenovo.shopping.activity.my.JiFenActivity;
import com.example.lenovo.shopping.activity.my.YouActivity;
import com.example.lenovo.shopping.base.BaseFragment;
import com.example.lenovo.shopping.presenter.MainP;
import com.example.lenovo.shopping.view.MainV;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment<MainV, MainP> implements MainV, View.OnClickListener {


    Unbinder unbinder;
    @BindView(R.id.center_jifen)
    LinearLayout centerJifen;
    @BindView(R.id.center_you)
    LinearLayout centerYou;
    @BindView(R.id.center_guan)
    LinearLayout centerGuan;
    Unbinder unbinder1;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.header, R.id.center_guan, R.id.center_jifen, R.id.center_you})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.header:
                Intent intent = new Intent(getContext(), HeaderActivity.class);
                startActivity(intent);
                break;
            case R.id.center_guan:  //关注
                Intent guan = new Intent(getContext(), GuanActivity.class);
                startActivity(guan);
                break;
            case R.id.center_jifen: //积分
                Intent jifen = new Intent(getContext(), JiFenActivity.class);
                startActivity(jifen);
                break;
            case R.id.center_you: //优惠券
                Intent you = new Intent(getContext(), YouActivity.class);
                startActivity(you);
                break;
        }
    }


}
