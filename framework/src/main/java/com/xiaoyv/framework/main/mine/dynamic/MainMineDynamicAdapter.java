package com.xiaoyv.framework.main.mine.dynamic;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.mine.dynamic.MineDynamicBean;
import com.xiaoyv.cultureengine.module.main.mine.dynamic.MineDynamicBean;
import com.xiaoyv.framework.R;
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
public class MainMineDynamicAdapter extends BaseQuickAdapter<MineDynamicBean.MineDynamic, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainMineDynamicAdapter(int layoutResId, @Nullable List<MineDynamicBean.MineDynamic> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, MineDynamicBean.MineDynamic itemBean) {
        ImageView headerView = holder.getView(R.id.main_mine_dynamic_item_header);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerView);
        ImageView imageView = holder.getView(R.id.main_mine_dynamic_item_image);
        Glide.with(mContext).load(itemBean.getImage()).into(imageView);

        holder.setText(R.id.main_mine_dynamic_item_content, itemBean.getContent());
        holder.setText(R.id.main_mine_dynamic_item_like_count, String.valueOf(itemBean.getLike()));
        holder.setText(R.id.main_mine_dynamic_item_dislike_count, String.valueOf(itemBean.getDislike()));
        holder.setText(R.id.main_mine_dynamic_item_comment_count, String.valueOf(itemBean.getComment()));
        holder.setText(R.id.main_mine_dynamic_item_name, itemBean.getName());

        holder.addOnClickListener(R.id.main_mine_dynamic_item_layout);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_mine_dynamic_item_layout) {
            AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                    .setTitle(R.string.dialog_delete_dynamic)
                    .setMessage(R.string.dialog_is_delete_dynamic)
                    .setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                        ToastUtils.showShort(getString(R.string.tips_delete_dynamic_success));
                        notifyItemRemoved(position);
                        getData().remove(position);
                        notifyItemRangeChanged(position, getItemCount());
                    })
                    .setNegativeButton(R.string.dialog_no, null)
                    .create();
            alertDialog.show();
        }
    }
}
