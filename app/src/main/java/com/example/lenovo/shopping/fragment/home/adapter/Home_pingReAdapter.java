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
import com.example.lenovo.shopping.fragment.home.bean.PingpaiBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_pingReAdapter extends RecyclerView.Adapter<Home_pingReAdapter.ViewHolder> {

    ArrayList<PingpaiBean.DlistBean> list;
    Context context;

    public Home_pingReAdapter(ArrayList<PingpaiBean.DlistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<PingpaiBean.DlistBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pingpai, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.name.setText(list.get(i).getName());
//        viewHolder.jiage.setText(list.get(i).getZuidijia());
        Glide.with(context).load(list.get(i).getBigPic()).into(viewHolder.iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pingpai_iv)
        ImageView iv;
        @BindView(R.id.pingpai_jiage)
        TextView jiage;
        @BindView(R.id.pingpai_name)
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
