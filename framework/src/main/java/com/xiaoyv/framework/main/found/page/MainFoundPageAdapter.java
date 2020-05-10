package com.xiaoyv.framework.main.found.page;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.found.page.FoundPageBean;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.found.page.details.MainFoundPageDetailsActivity;
import com.xiaoyv.open.adapter.base.BaseQuickAdapter;
import com.xiaoyv.open.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/23
 */
public class MainFoundPageAdapter extends BaseQuickAdapter<FoundPageBean.FoundPage, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainFoundPageAdapter(int layoutResId, @Nullable List<FoundPageBean.FoundPage> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, FoundPageBean.FoundPage itemBean) {

        ImageView headerView = holder.getView(R.id.main_found_page_item_header);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerView);

        ImageView imageView = holder.getView(R.id.main_found_page_item_image);
        Glide.with(mContext).load(itemBean.getBackground()).into(imageView);

        holder.setText(R.id.main_found_page_item_desc, itemBean.getDesc());
        holder.setText(R.id.main_found_page_item_name, itemBean.getName());
        holder.addOnClickListener(R.id.main_found_page_item_attention);
        holder.addOnClickListener(R.id.main_found_page_item_layout);

        if (itemBean.isAttention()) {
            holder.setText(R.id.main_found_page_item_attention, mContext.getString(R.string.main_found_page_attention_ed));
            holder.setEnabled(R.id.main_found_page_item_attention, false);
        } else {
            holder.setText(R.id.main_found_page_item_attention, mContext.getString(R.string.main_found_page_attention));
            holder.setEnabled(R.id.main_found_page_item_attention, true);
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_found_page_item_attention) {
            AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                    .setTitle(R.string.dialog_attention)
                    .setMessage(R.string.dialog_is_attention)
                    .setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                        view.setEnabled(false);
                        ((Button) view).setText(mContext.getString(R.string.main_found_page_attention_ed));
                        ToastUtils.showShort(mContext.getString(R.string.tips_attention_success));
                    })
                    .setNegativeButton(R.string.dialog_no, null)
                    .create();
            alertDialog.show();
        } else if (view.getId() == R.id.main_found_page_item_layout) {
            Intent intent = new Intent(mContext, MainFoundPageDetailsActivity.class);
            intent.putExtra("data", getData().get(position));
            ActivityUtils.startActivity(intent);
        }
    }
}
