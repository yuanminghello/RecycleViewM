package com.example.yuan.moreitem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * date:2018/12/01
 * author:yuan(123)
 * function:
 */
public abstract  class TypeHolder extends RecyclerView.ViewHolder {
    public TypeHolder(@NonNull View itemView) {
        super(itemView);
    }



    public abstract void bindHolder(Bean.DataBean dataBean);
}
