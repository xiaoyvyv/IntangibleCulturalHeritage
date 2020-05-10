package com.xiaoyv.framework.main.found.hot;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.found.hot.details.MainFoundHotDetailsActivity;
import com.xiaoyv.open.adapter.base.BaseQuickAdapter;
import com.xiaoyv.open.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/23
 */
public class MainFoundHotAdapter extends BaseQuickAdapter<FoundHotBean.FoundHot, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainFoundHotAdapter(int layoutResId, @Nullable List<FoundHotBean.FoundHot> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, FoundHotBean.FoundHot itemBean) {

        ImageView headerView = holder.getView(R.id.main_found_hot_item_header);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerView);

        ImageView imageView = holder.getView(R.id.main_found_hot_item_image);
        Glide.with(mContext).load(itemBean.getBackground()).into(imageView);

        holder.setText(R.id.main_found_hot_item_title, itemBean.getTitle());
        holder.setText(R.id.main_found_hot_item_name, itemBean.getName());
        holder.setText(R.id.main_found_hot_item_like_count, String.valueOf(itemBean.getLike()));

        holder.addOnClickListener(R.id.main_found_hot_item_like);
        holder.addOnClickListener(R.id.main_found_hot_item_layout);
    }


    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_found_hot_item_like) {
            AppCompatTextView likeCount = (AppCompatTextView) getViewByPosition(position, R.id.main_found_hot_item_like_count);
            if (likeCount != null) {
                ToastUtils.showShort(mContext.getString(R.string.tips_like));
                likeCount.setText(String.valueOf(Integer.valueOf(likeCount.getText().toString()) + 1));
            }
        } else if (view.getId() == R.id.main_found_hot_item_layout) {
            Intent intent = new Intent(mContext, MainFoundHotDetailsActivity.class);
            intent.putExtra("data", getData().get(position));
            ActivityUtils.startActivity(intent);
        }
    }
}
