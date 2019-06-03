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
import com.example.lenovo.shopping.fragment.home.bean.MiaoBean;
import com.example.lenovo.shopping.fragment.home.bean.RenBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_RenReAdapter extends RecyclerView.Adapter<Home_RenReAdapter.ViewHolder> {
   ArrayList<RenBean.DlistBean> list;
   Context context;

    public Home_RenReAdapter(ArrayList<RenBean.DlistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setRenlist(ArrayList<RenBean.DlistBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ren, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RenBean.DlistBean dlistBean = list.get(i);
        Glide.with(context).load(list.get(i).getPrice()).into(viewHolder.iv);
        viewHolder.tv1.setText(dlistBean.getName());
        viewHolder.tv2.setText(dlistBean.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ren_iv)
        ImageView iv;
        @BindView(R.id.ren_tv1)
        TextView tv1;
        @BindView(R.id.ren_tv2)
        TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
