package com.example.lenovo.shopping;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.shopping.activity.SearchActivity;
import com.example.lenovo.shopping.activity.ShoppingActivity;
import com.example.lenovo.shopping.base.BaseActivity;
import com.example.lenovo.shopping.fragment.classify.CliassifyFragment;
import com.example.lenovo.shopping.fragment.home.HomeFragment;
import com.example.lenovo.shopping.fragment.my.MyFragment;
import com.example.lenovo.shopping.fragment.special.SpecialFragment;
import com.example.lenovo.shopping.presenter.MainP;
import com.example.lenovo.shopping.view.MainV;
import com.example.lenovo.shopping.weghit.StatusBarManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainV, MainP> implements MainV {

    @BindView(R.id.tool)
    Toolbar tool;
    @BindView(R.id.main_fra)
    FrameLayout fram;
    @BindView(R.id.main_tab)
    TabLayout mainTab;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentManager manager;
    private int mLastposition;
    private FragmentTransaction transaction;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected void initView() {
        tool.setTitle("");
        setSupportActionBar(tool);
        int color = ContextCompat.getColor(this, R.color.white);
        StatusBarManager.setStatusBarColor(this, color);
        manager = getSupportFragmentManager();
        initOpen();
        initFragmetn();
        addMainPageFragment();
    }

    private void addMainPageFragment() {
        transaction = manager.beginTransaction();
        transaction.add(R.id.main_fra, fragments.get(0));
        transaction.commit();
    }

    private void initFragmetn() {
        fragments.add(new HomeFragment());
        fragments.add(new CliassifyFragment());
        fragments.add(new SpecialFragment());
        fragments.add(new MyFragment());
    }

    private void initOpen() {
        mainTab.setSelectedTabIndicatorHeight(0);
        for (int i = 0; i < 4; i++) {
            mainTab.addTab(mainTab.newTab().setCustomView(getTab(i)));
        }
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switchFragment(position);
                mLastposition = position;

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void switchFragment(int position) {
        Fragment fragment = fragments.get(position);
        transaction = manager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.main_fra, fragment);
        }
        transaction.show(fragment);
        transaction.hide(fragments.get(mLastposition));
        transaction.commit();

    }

    private View getTab(int i) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.main_layout, null, false);
        ImageView layout_iv = inflate.findViewById(R.id.layout_iv);
        TextView layout_tv = inflate.findViewById(R.id.layout_tv);
        if (i == 0) {
            layout_iv.setImageResource(R.drawable.home_iv);
            layout_tv.setText("主页");
        } else if (i == 1) {
            layout_iv.setImageResource(R.drawable.clia_iv);
            layout_tv.setText("分类");
        } else if (i == 2) {
            layout_iv.setImageResource(R.drawable.hot_iv);
            layout_tv.setText("专题");
        } else if (i == 3) {
            layout_iv.setImageResource(R.drawable.my_iv);
            layout_tv.setText("我的");
        }

        return inflate;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1://搜索
                Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu2://购物
                Intent intent = new Intent(MainActivity.this, ShoppingActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
