package com.zhangxt4.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhangxt4 on 2016/2/17.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<String> mDatas;

    //构造方法
    public MyRecyclerViewAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.simple_textview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //添加删除item的接口
    public void addItem(int position) {
        mDatas.add(position, "Inserted one");
        notifyItemInserted(position);
    }
    public void deleteItem(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public MyViewHolder(View view) {
        super(view);
        textView = (TextView) view.findViewById(R.id.id_textview);
    }
}