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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_miaoReAdapter extends RecyclerView.Adapter<Home_miaoReAdapter.ViewHolder> {
    ArrayList<MiaoBean.DlistBean> list;
    Context context;

    public Home_miaoReAdapter(ArrayList<MiaoBean.DlistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<MiaoBean.DlistBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.miao, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getPrice()).error(R.drawable.hua).into(viewHolder.iv);
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.price.setText(list.get(i).getPrice());
        viewHolder.tv.setText(list.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.miao_iv)
        ImageView iv;
        @BindView(R.id.miao_price)
        TextView price;
        @BindView(R.id.miao_tv)
        TextView tv;
        @BindView(R.id.miao_name)
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
