package com.example.yuan.moreitem.holder;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuan.moreitem.Bean;
import com.example.yuan.moreitem.R;
import com.example.yuan.moreitem.TypeHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/01
 * author:yuan(123)
 * function:
 */
public class TypeOne extends TypeHolder {
    SimpleDraweeView icon;
    TextView title;
    private GenericDraweeHierarchy build;
    public TypeOne(@NonNull View itemView) {
        super(itemView);
        icon =  itemView.findViewById(R.id.icon);
        title =  itemView.findViewById(R.id.title);

        GenericDraweeHierarchyBuilder hierarchyBuilder = new GenericDraweeHierarchyBuilder(itemView.getResources());
        RoundingParams circle = RoundingParams.asCircle();
        build = hierarchyBuilder.setRoundingParams(circle).build();
    }

    @Override
    public void bindHolder(Bean.DataBean dataBean) {
         title.setText(dataBean.getTitle());

        icon.setHierarchy(build);
        icon.setImageURI(Uri.parse(dataBean.getThumbnail_pic_s()));
    }


}
