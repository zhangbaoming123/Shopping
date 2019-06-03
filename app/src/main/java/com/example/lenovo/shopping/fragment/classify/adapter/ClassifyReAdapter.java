package com.example.lenovo.shopping.fragment.classify.adapter;

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
import com.example.lenovo.shopping.fragment.classify.bean.ClassifyReBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassifyReAdapter extends RecyclerView.Adapter<ClassifyReAdapter.ViewHolder> {
    ArrayList<ClassifyReBean.DlistBean> data;
    Context context;

    public ClassifyReAdapter(ArrayList<ClassifyReBean.DlistBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void setData(ArrayList<ClassifyReBean.DlistBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(data.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cla_iv)
        ImageView iv;
        @BindView(R.id.cla_tv)
        TextView tv;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
