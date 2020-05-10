package com.xiaoyv.framework.main.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.home.HomeItemBean;
import com.xiaoyv.cultureengine.module.main.news.NewsPageBean;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.news.page.details.MainNewsPageDetailsActivity;
import com.xiaoyv.open.adapter.base.BaseQuickAdapter;
import com.xiaoyv.open.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/23
 */
public class MainHomeAdapter extends BaseQuickAdapter<HomeItemBean.HomeItem, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainHomeAdapter(int layoutResId, @Nullable List<HomeItemBean.HomeItem> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, HomeItemBean.HomeItem itemBean) {
        ImageView imageView = holder.getView(R.id.main_home_item_image);
        Glide.with(mContext).load(itemBean.getBackground()).into(imageView);

        holder.setText(R.id.main_home_item_title, itemBean.getTitle());
        holder.addOnClickListener(R.id.main_home_item_layout);
    }



    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_home_item_layout) {
            HomeItemBean.HomeItem homeItem = getData().get(position);
            NewsPageBean.NewsPage newsPage = new NewsPageBean.NewsPage();
            newsPage.setBackground(homeItem.getBackground());
            newsPage.setDesc(homeItem.getDesc());
            newsPage.setHeader(homeItem.getHeader());
            newsPage.setName(homeItem.getName());
            newsPage.setTitle(homeItem.getTitle());
            Intent intent = new Intent(mContext, MainNewsPageDetailsActivity.class);
            intent.putExtra("data", newsPage);
            ActivityUtils.startActivity(intent);
        }
    }
}
