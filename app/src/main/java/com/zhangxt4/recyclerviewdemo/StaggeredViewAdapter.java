package com.zhangxt4.recyclerviewdemo;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxt4 on 2016/2/19.
 */
public class StaggeredViewAdapter extends MyRecyclerViewAdapter {
    protected List<Integer> mItemHeight;
    public StaggeredViewAdapter(Context context, List<String> datas) {
        super(context, datas);
        mItemHeight = new ArrayList<Integer>();
        for (int i = 0; i < datas.size(); i ++){
            mItemHeight.add((int) (100+Math.random()*300));
        }
    }

    //重写onBindViewHolder(),设定itemView的高度
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mItemHeight.get(position);
        holder.itemView.setLayoutParams(lp);
    }
}
