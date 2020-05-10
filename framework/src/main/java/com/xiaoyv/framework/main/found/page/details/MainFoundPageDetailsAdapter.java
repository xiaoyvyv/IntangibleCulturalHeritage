package com.xiaoyv.framework.main.found.page.details;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
import com.xiaoyv.cultureengine.module.main.found.page.works.FoundPageDetailsBean;
import com.xiaoyv.framework.R;
import com.xiaoyv.open.adapter.base.BaseQuickAdapter;
import com.xiaoyv.open.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/23
 */
public class MainFoundPageDetailsAdapter extends BaseQuickAdapter<FoundPageDetailsBean.FoundPageDetails, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainFoundPageDetailsAdapter(int layoutResId, @Nullable List<FoundPageDetailsBean.FoundPageDetails> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder,FoundPageDetailsBean.FoundPageDetails itemBean) {
        ImageView headerView = holder.getView(R.id.main_found_page_details_item_image);
        Glide.with(mContext).load(itemBean.getBackground()).into(headerView);
        holder.setText(R.id.main_found_page_details_item_title, itemBean.getTitle());
        holder.setText(R.id.main_found_page_details_item_like, "喜欢：" + itemBean.getLike());
    }
    

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
