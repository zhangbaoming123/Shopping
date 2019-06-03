package com.example.lenovo.shopping.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.shopping.R;
import com.example.lenovo.shopping.adapter.ShopReAdapter;
import com.example.lenovo.shopping.base.BaseActivity;
import com.example.lenovo.shopping.presenter.MainP;
import com.example.lenovo.shopping.view.MainV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShoppingActivity extends BaseActivity<MainV, MainP> implements MainV {

    @BindView(R.id.sho_tool)
    Toolbar shoTool;
    @BindView(R.id.listview)
    ListView listView;
    @BindView(R.id.con)
    Button con;
    @BindView(R.id.dibu_cb)
    CheckBox cb;
    @BindView(R.id.dibu_price)
    TextView price;
    private List<HashMap<String, String>> listmap = new ArrayList<>();
    private ShopReAdapter adapter;


    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shopping;
    }

    @Override
    protected void initData() {
        shoTool.setTitle("");
        setSupportActionBar(shoTool);

        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", "购物车第" + (i + 1) + "个商品");
            hashMap.put("type", (i + 20) + "码");
            hashMap.put("price", "10");
            hashMap.put("count", "10");
            listmap.add(hashMap);
        }


        initAdapter();
    }

    private void initAdapter() {
        adapter = new ShopReAdapter(this, listmap);
        listView.setAdapter(adapter);
        adapter.setRefreshPriceInterface(this);
    }

    @OnClick(R.id.dibu_cb)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dibu_cb:
                AllCheck();
                break;
        }
    }

    private void AllCheck() {
        HashMap<String, Integer> map = adapter.getPitchOnMap();
        boolean isCheck = false;
        boolean isUnCheck = false;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();

            if (Integer.valueOf(entry.getValue().toString()) == 1) {
                isCheck = true;
            } else {
                isUnCheck = true;
            }
        }
        if (isCheck == true && isUnCheck == false) {//已经全选,做反选
            for (int i = 0; i < listmap.size(); i++) {
                map.put(listmap.get(i).get("id"), 0);
            }
            cb.setChecked(false);
        } else if (isCheck == true && isUnCheck == true) {//部分选择,做全选
            for (int i = 0; i < listmap.size(); i++) {
                map.put(listmap.get(i).get("id"), 1);
            }
            cb.setChecked(true);
        } else if (isCheck == false && isUnCheck == true) {//一个没选,做全选
            for (int i = 0; i < listmap.size(); i++) {
                map.put(listmap.get(i).get("id"), 1);
            }
            cb.setChecked(true);
        }
        priceControl(map);
        adapter.setPitchOnMap(map);
        adapter.notifyDataSetChanged();
    }

    public void refreshPrice(HashMap<String, Integer> pitchOnMap) {
        priceControl(pitchOnMap);
    }

    private int totalCount = 0;
    private double totalPrice = 0.00;

    private void priceControl(Map<String, Integer> pitchOnMap) {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < listmap.size(); i++) {
            if (pitchOnMap.get(listmap.get(i).get("id")) == 1) {
                totalCount = totalCount + Integer.valueOf(listmap.get(i).get("count"));
                double goodsPrice = Integer.valueOf(listmap.get(i).get("count")) * Double.valueOf(listmap.get(i).get("price"));
                totalPrice = totalPrice + goodsPrice;
            }
        }
        price.setText(" ¥ " + totalPrice);
        con.setText("付款(" + totalCount + ")");
    }
}
