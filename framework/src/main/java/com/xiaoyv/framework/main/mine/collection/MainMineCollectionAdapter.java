package com.xiaoyv.framework.main.mine.collection;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.mine.collection.MineCollectionBean;
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
public class MainMineCollectionAdapter extends BaseQuickAdapter<MineCollectionBean.MineCollection, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    MainMineCollectionAdapter(int layoutResId, @Nullable List<MineCollectionBean.MineCollection> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, MineCollectionBean.MineCollection itemBean) {
        ImageView headerView = holder.getView(R.id.main_mine_collection_item_image);
        Glide.with(mContext).load(itemBean.getImage()).into(headerView);

        holder.setText(R.id.main_mine_collection_item_title, itemBean.getTitle());
        holder.setText(R.id.main_mine_collection_item_times, "阅读量：" + itemBean.getTimes() + "次");
        holder.setText(R.id.main_mine_collection_item_kind, "来自：" + "精选文章");

        holder.addOnClickListener(R.id.main_mine_collection_item_layout);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_mine_collection_item_layout) {
            AlertDialog alertDialog = new AlertDialog.Builder(mContext)
                    .setTitle(R.string.dialog_delete_collection)
                    .setMessage(R.string.dialog_is_delete_collection)
                    .setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                        ToastUtils.showShort(getString(R.string.tips_delete_collection_success));
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
