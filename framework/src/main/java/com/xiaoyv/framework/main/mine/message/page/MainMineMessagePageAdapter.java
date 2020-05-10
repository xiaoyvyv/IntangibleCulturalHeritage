package com.xiaoyv.framework.main.mine.message.page;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.mine.message.MineMessageBean;
import com.xiaoyv.cultureengine.module.main.news.NewsPageBean;
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
public class MainMineMessagePageAdapter extends BaseQuickAdapter<MineMessageBean.MineMessage, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainMineMessagePageAdapter(int layoutResId, @Nullable List<MineMessageBean.MineMessage> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, MineMessageBean.MineMessage itemBean) {
        ImageView headerView = holder.getView(R.id.main_mine_message_item_header);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerView);

        holder.setText(R.id.main_mine_message_item_title, itemBean.getTitle());
        holder.setText(R.id.main_mine_message_item_name, itemBean.getName());
        holder.setText(R.id.main_mine_message_item_time, itemBean.getTime());
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
