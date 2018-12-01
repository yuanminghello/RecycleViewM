package com.example.yuan.moreitem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuan.moreitem.holder.TypeOne;
import com.example.yuan.moreitem.holder.TypeThree;
import com.example.yuan.moreitem.holder.TypeTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/12/01
 * author:yuan(123)
 * function:
 */
class RecycleViewAdapter extends RecyclerView.Adapter {

    int TYPE_ONE = 1;
    int TYPE_TWO = 2;
    int TYPE_THREE = 3;

    private LayoutInflater mLayoutInflater;

    private List<Bean.DataBean> mList = new ArrayList<>();
    public RecycleViewAdapter(Context context, List<Bean.DataBean> data) {
        mLayoutInflater = LayoutInflater.from(context);
        mList.addAll(data);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       if(i==TYPE_ONE){
            TypeOne typeOne = new TypeOne(mLayoutInflater.inflate(R.layout.item_type_one, viewGroup, false));

            return typeOne;
        }else if( i==TYPE_TWO){
            TypeTwo typeTwo = new TypeTwo(mLayoutInflater.inflate(R.layout.item_type_two, viewGroup, false));
            return typeTwo;
        }else {
            TypeThree typeThree = new TypeThree(mLayoutInflater.inflate(R.layout.item_type_three, viewGroup, false));
            return typeThree;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((TypeHolder)viewHolder).bindHolder(mList.get(i));
    }

    @Override
    public int getItemViewType(int position) {

        if (position % 3 == 0) {
            return TYPE_ONE;
        } else if (position%3 == 1) {
            return TYPE_TWO;
        } else {
            return TYPE_THREE;
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
