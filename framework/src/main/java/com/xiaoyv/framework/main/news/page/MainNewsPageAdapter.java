package com.xiaoyv.framework.main.news.page;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.news.NewsPageBean;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.found.hot.details.MainFoundHotDetailsActivity;
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
public class MainNewsPageAdapter extends BaseQuickAdapter<NewsPageBean.NewsPage, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainNewsPageAdapter(int layoutResId, @Nullable List<NewsPageBean.NewsPage> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsPageBean.NewsPage itemBean) {
        ImageView imageView = holder.getView(R.id.main_news_page_item_image);
        ImageView headerImageView = holder.getView(R.id.main_news_page_header);
        Glide.with(mContext).load(itemBean.getBackground()).into(imageView);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerImageView);

        holder.setText(R.id.main_news_page_item_title, itemBean.getTitle());
        holder.setText(R.id.main_news_page_item_desc, itemBean.getDesc());
        holder.setText(R.id.main_news_page_item_name, itemBean.getName());

        holder.addOnClickListener(R.id.main_news_page_item_layout);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_news_page_item_layout) {
            Intent intent = new Intent(mContext, MainNewsPageDetailsActivity.class);
            intent.putExtra("data", getData().get(position));
            ActivityUtils.startActivity(intent);
        }
    }
}
