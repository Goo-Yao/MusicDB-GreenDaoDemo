package com.goo.musicdb.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.goo.musicdb.R;


/**
 * Created by Goo on 2016-10-19.
 */

public class RVDefaultViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public TextView tvSub;

    public RVDefaultViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvSub = (TextView) itemView.findViewById(R.id.tv_sub_title);
    }
}
