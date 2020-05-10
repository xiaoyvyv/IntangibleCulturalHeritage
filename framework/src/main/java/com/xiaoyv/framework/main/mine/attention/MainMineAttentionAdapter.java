package com.xiaoyv.framework.main.mine.attention;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.found.page.FoundPageBean;
import com.xiaoyv.cultureengine.module.main.mine.attention.MineAttentionBean;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.found.page.details.MainFoundPageDetailsActivity;
import com.xiaoyv.open.adapter.base.BaseQuickAdapter;
import com.xiaoyv.open.adapter.base.BaseViewHolder;

import java.util.List;

import static com.blankj.utilcode.util.StringUtils.getString;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/23
 */
public class MainMineAttentionAdapter extends BaseQuickAdapter<MineAttentionBean.MineAttention, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainMineAttentionAdapter(int layoutResId, @Nullable List<MineAttentionBean.MineAttention> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, MineAttentionBean.MineAttention itemBean) {

        ImageView headerView = holder.getView(R.id.main_mine_attention_item_header);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerView);

        holder.setText(R.id.main_mine_attention_item_title, itemBean.getDesc());
        holder.setText(R.id.main_mine_attention_item_name, itemBean.getName());
        holder.addOnClickListener(R.id.main_mine_attention_item_no_attention);
        holder.addOnClickListener(R.id.main_mine_attention_item_layout);

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_mine_attention_item_no_attention) {
            // 取消关注
            AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                    .setTitle(R.string.dialog_no_attention)
                    .setMessage(R.string.dialog_is_no_attention)
                    .setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                        ToastUtils.showShort(getString(R.string.tips_no_attention_success));
                        notifyItemRemoved(position);
                        getData().remove(position);
                        notifyItemRangeChanged(position, getItemCount());
                    })
                    .setNegativeButton(R.string.dialog_no, null)
                    .create();
            alertDialog.show();
        } else if (view.getId() == R.id.main_mine_attention_item_layout) {
            MineAttentionBean.MineAttention attention = getData().get(position);

            FoundPageBean.FoundPage foundPage = new FoundPageBean.FoundPage();
            foundPage.setBackground(attention.getHeader());
            foundPage.setHeader(attention.getHeader());
            foundPage.setDesc(attention.getDesc());
            foundPage.setAttention(true);
            foundPage.setName(attention.getName());

            Intent intent = new Intent(mContext, MainFoundPageDetailsActivity.class);
            intent.putExtra("data", foundPage);
            ActivityUtils.startActivity(intent);
        }
    }
}
