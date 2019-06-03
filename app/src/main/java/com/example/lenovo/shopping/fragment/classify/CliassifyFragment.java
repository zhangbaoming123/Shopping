package com.example.lenovo.shopping.fragment.classify;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.shopping.R;
import com.example.lenovo.shopping.base.BaseFragment;
import com.example.lenovo.shopping.fragment.classify.adapter.ClassifyReAdapter;
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;
import com.example.lenovo.shopping.fragment.classify.presenter.ClassifyP;
import com.example.lenovo.shopping.fragment.classify.view.ClassifyV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CliassifyFragment extends BaseFragment<ClassifyV, ClassifyP> implements ClassifyV {


    @BindView(R.id.ver_tab)
    VerticalTabLayout verTab;
    @BindView(R.id.cla_re)
    RecyclerView claRe;
    Unbinder unbinder;
    private ArrayList<ClassifyReBean.DlistBean> list;
    private ClassifyReAdapter adapter;
    private boolean move;
    private int mIndex;
    private List<ClassifyReBean.DlistBean> dlist;
    private GridLayoutManager manager;

    @Override
    protected ClassifyP initPresenter() {
        return new ClassifyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cliassify;
    }

    @Override
    protected void initView() {
        manager = new GridLayoutManager(getContext(),2);
        claRe.setLayoutManager(manager);
        list = new ArrayList<>();
        adapter = new ClassifyReAdapter(list, getContext());
        claRe.setAdapter(adapter);

        claRe.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //在这里进行第二次滚动（最后的100米！）
                if (move) {
                    move = false;
                    //获取要置顶的项在当前屏幕的位置，mIndex是记录的要置顶项在RecyclerView中的位置
                    int n = mIndex - manager.findFirstVisibleItemPosition();
                    if (0 <= n && n < claRe.getChildCount()) {
                        //获取要置顶的项顶部离RecyclerView顶部的距离
                        int top = claRe.getChildAt(n).getTop();
                        //最后的移动
                        claRe.scrollBy(0, top);
                    }
                }
            }
        });

    }

    @Override
    protected void initData() {
        presenter.getData();
    }


    @Override
    public void onSucces(final ClassifyReBean da) {
        dlist = da.getDlist();
        for (int i = 0; i < dlist.size(); i++) {
            verTab.addTab(new QTabView(getContext()));
        }
     verTab.setTabAdapter(new TabAdapter() {
         @Override
         public int getCount() {
             return dlist.size();
         }

         @Override
         public ITabView.TabBadge getBadge(int position) {
             return null;
         }

         @Override
         public ITabView.TabIcon getIcon(int position) {
             return null;
         }

         @Override
         public ITabView.TabTitle getTitle(int position) {
             return new QTabView.TabTitle.Builder()
                     .setContent(da.getDlist().get(position).getName())
                     .setTextColor(Color.BLUE,Color.BLACK)
                     .build();
         }

         @Override
         public int getBackground(int position) {
             return 0;
         }
     });
       list.addAll(dlist);
       adapter.setData(list);
       adapter.notifyDataSetChanged();
        verTab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                moveToPosition(position);
                mIndex = position;
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }
    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = manager.findFirstVisibleItemPosition();
        int lastItem = manager.findLastVisibleItemPosition();
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            claRe.scrollToPosition(n);
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = claRe.getChildAt(n - firstItem).getTop();
            claRe.scrollBy(0, top);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            claRe.scrollToPosition(n);
            //这里这个变量是用在RecyclerView滚动监听里面的
            move = true;
        }

    }
    @Override
    public void onFails(String s) {
        Log.e("tag", "onFails: " + s);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
