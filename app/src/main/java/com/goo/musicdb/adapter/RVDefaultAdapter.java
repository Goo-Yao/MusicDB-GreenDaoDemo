package com.goo.musicdb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goo.musicdb.R;
import com.goo.musicdb.entity.RVDefaultItem;
import com.goo.musicdb.holder.RVDefaultViewHolder;

import java.util.ArrayList;

/**
 * Created by Goo on 2016-12-28.
 */

public class RVDefaultAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<RVDefaultItem> mData;

    public RVDefaultAdapter(Context context, ArrayList<RVDefaultItem> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<RVDefaultItem> data) {
        mData.clear();
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = mLayoutInflater.inflate(R.layout.layout_rv_item_default, parent, false);
        RVDefaultViewHolder holder = new RVDefaultViewHolder(rootView);
        rootView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RVDefaultItem tempInfo = mData.get(position);
        if (holder instanceof RVDefaultViewHolder) {
            ((RVDefaultViewHolder) holder).tvTitle.setText(tempInfo.getTitle());
            ((RVDefaultViewHolder) holder).tvSub.setText(tempInfo.getSubTitle());
            holder.itemView.setTag(mData.get(position));
        }
    }

    public void setOnRvItemClickListener(OnRvItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static interface OnRvItemClickListener {
        void onItemClick(View view, RVDefaultItem rvDefaultItem);
    }

    private OnRvItemClickListener mOnItemClickListener = null;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (RVDefaultItem) v.getTag());
        }
    }
}
