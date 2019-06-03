package com.example.lenovo.shopping.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

public class MainVpAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragment;
    private ArrayList<String> title;

    public MainVpAdapter(FragmentManager fm, ArrayList<Fragment> fragment, ArrayList<String> title) {
        super(fm);
        this.fragment = fragment;
        this.title = title;
    }

    @Override
    public Fragment getItem(int i) {
        return fragment.get(i);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
