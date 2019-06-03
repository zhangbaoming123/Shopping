package com.example.lenovo.shopping.fragment.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.shopping.R;
import com.example.lenovo.shopping.fragment.home.bean.XinxainBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_xinReAdapter extends RecyclerView.Adapter<Home_xinReAdapter.ViewHolder> {
    ArrayList<XinxainBean.ListBean> listBeans;
    Context context;

    public Home_xinReAdapter(ArrayList<XinxainBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    public void setListBeans(ArrayList<XinxainBean.ListBean> listBeans) {
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public Home_xinReAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xin, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Home_xinReAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context).load(listBeans.get(i).getPic()).error(R.drawable.hua).into(viewHolder.iv);
        viewHolder.name.setText(listBeans.get(i).getName());
        viewHolder.price.setText(listBeans.get(i).getPrice());
        viewHolder.tv.setText(listBeans.get(i).getSubTitle());
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.xin_iv)
        ImageView iv;
        @BindView(R.id.xin_price)
        TextView price;
        @BindView(R.id.xin_tv)
        TextView tv;
        @BindView(R.id.xin_name)
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
