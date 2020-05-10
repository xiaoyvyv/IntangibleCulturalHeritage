package com.xiaoyv.framework.main.mine.fans;

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
import com.xiaoyv.cultureengine.module.main.mine.fans.MineFansBean;
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
public class MainMineFansAdapter extends BaseQuickAdapter<MineFansBean.MineFans, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainMineFansAdapter(int layoutResId, @Nullable List<MineFansBean.MineFans> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, MineFansBean.MineFans itemBean) {

        ImageView headerView = holder.getView(R.id.main_mine_fans_item_header);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerView);

        holder.setText(R.id.main_mine_fans_item_title, itemBean.getDesc());
        holder.setText(R.id.main_mine_fans_item_name, itemBean.getName());
        if (itemBean.isAttention()) {
            holder.setEnabled(R.id.main_mine_fans_item_attention, false);
            holder.setText(R.id.main_mine_fans_item_attention, mContext.getString(R.string.main_mine_fans_attention_each));
        } else {
            holder.setEnabled(R.id.main_mine_fans_item_attention, true);
            holder.setText(R.id.main_mine_fans_item_attention, mContext.getString(R.string.main_mine_fans_attention_ta));
        }

        holder.addOnClickListener(R.id.main_mine_fans_item_attention);
        holder.addOnClickListener(R.id.main_mine_fans_item_layout);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_mine_fans_item_layout) {

            MineFansBean.MineFans mineFans = getData().get(position);

            FoundPageBean.FoundPage foundPage = new FoundPageBean.FoundPage();
            foundPage.setBackground(mineFans.getHeader());
            foundPage.setHeader(mineFans.getHeader());
            foundPage.setDesc(mineFans.getDesc());
            foundPage.setAttention(getData().get(position).isAttention());
            foundPage.setName(mineFans.getName());

            Intent intent = new Intent(mContext, MainFoundPageDetailsActivity.class);
            intent.putExtra("data", foundPage);
            ActivityUtils.startActivity(intent);
        } else if (view.getId() == R.id.main_mine_fans_item_attention) {
            // 关注
            AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                    .setTitle(R.string.dialog_attention)
                    .setMessage(R.string.dialog_is_attention)
                    .setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                        view.setEnabled(false);
                        ((Button) view).setText(mContext.getString(R.string.main_mine_fans_attention_each));
                        ToastUtils.showShort(mContext.getString(R.string.tips_attention_success));
                    })
                    .setNegativeButton(R.string.dialog_no, null)
                    .create();
            alertDialog.show();
        }
    }
}
