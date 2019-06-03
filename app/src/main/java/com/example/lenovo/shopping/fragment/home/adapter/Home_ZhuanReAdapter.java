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
import com.example.lenovo.shopping.fragment.home.bean.ZhuanBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_ZhuanReAdapter extends RecyclerView.Adapter<Home_ZhuanReAdapter.ViewHolder> {
    ArrayList<ZhuanBean.DlistBean> list;
    Context context;

    public Home_ZhuanReAdapter(ArrayList<ZhuanBean.DlistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<ZhuanBean.DlistBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhuan, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ZhuanBean.DlistBean dlistBean = list.get(i);
        Glide.with(context).load(list.get(i).getPrice()).error(R.mipmap.ic_launcher).into(viewHolder.iv);
        viewHolder.tv1.setText(dlistBean.getTitle());
        viewHolder.tv2.setText(dlistBean.getPrice());
        viewHolder.te3.setText(dlistBean.getCategory_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.zhuan_iv)
        ImageView iv;
        @BindView(R.id.zhuan_tv1)
        TextView tv1;
        @BindView(R.id.zhuan_tv2)
        TextView tv2;
        @BindView(R.id.zhuan_tv3)
        TextView te3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
