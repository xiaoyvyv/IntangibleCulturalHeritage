package com.xiaoyv.framework.main.found.video;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.VideoView;
import com.xiaoyv.cultureengine.module.main.found.video.FoundVideoBean;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.found.hot.details.MainFoundHotDetailsActivity;
import com.xiaoyv.framework.main.found.video.details.MainFoundVideoDetailsActivity;
import com.xiaoyv.open.adapter.base.BaseQuickAdapter;
import com.xiaoyv.open.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/23
 */
public class MainFoundVideoAdapter extends BaseQuickAdapter<FoundVideoBean.FoundVideo, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {

    private VideoView currentVideo;

    MainFoundVideoAdapter(int layoutResId, @Nullable List<FoundVideoBean.FoundVideo> data) {
        super(layoutResId, data);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder holder, FoundVideoBean.FoundVideo itemBean) {
        ImageView headerView = holder.getView(R.id.main_found_video_item_header);
        Glide.with(mContext).load(itemBean.getHeader()).into(headerView);

        currentVideo = null;
        VideoView videoView = holder.getView(R.id.main_found_video_item_av);
        videoView.release();
        videoView.setUrl(itemBean.getVideo());
        StandardVideoController controller = new StandardVideoController(mContext) {
            @Override
            protected void onPlayStateChanged(int playState) {
                super.onPlayStateChanged(playState);
                currentVideo = videoView;
            }
        };

        controller.addDefaultControlComponent(itemBean.getTitle(), false);
        videoView.setVideoController(controller);


        holder.setText(R.id.main_found_video_item_title, itemBean.getTitle());
        holder.setText(R.id.main_found_video_item_name, itemBean.getName());
        holder.setText(R.id.main_found_video_item_times, "浏览：" + itemBean.getTimes());
        holder.setText(R.id.main_found_video_item_like_count, String.valueOf(itemBean.getLike()));
        holder.setText(R.id.main_found_video_item_dislike_count, String.valueOf(itemBean.getDislike()));

        holder.addOnClickListener(R.id.main_found_video_item_like);
        holder.addOnClickListener(R.id.main_found_video_item_dislike);
        holder.addOnClickListener(R.id.main_found_video_item_layout);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.main_found_video_item_like) {
            TextView likeCount = (TextView) getViewByPosition(position, R.id.main_found_video_item_like_count);
            if (likeCount != null) {
                ToastUtils.showShort(mContext.getString(R.string.tips_like));
                likeCount.setText(String.valueOf(Integer.valueOf(likeCount.getText().toString()) + 1));
            }
        } else if (view.getId() == R.id.main_found_video_item_dislike) {
            TextView disLikeCount = (TextView) getViewByPosition(position, R.id.main_found_video_item_dislike_count);
            if (disLikeCount != null) {
                ToastUtils.showShort(mContext.getString(R.string.tips_dislike));
                disLikeCount.setText(String.valueOf(Integer.valueOf(disLikeCount.getText().toString()) + 1));
            }
        } else if (view.getId() == R.id.main_found_video_item_layout) {
            // 暂停播放
            if (getCurrentVideo() != null) {
                getCurrentVideo().pause();
                getCurrentVideo().release();
            }
            Intent intent = new Intent(mContext, MainFoundVideoDetailsActivity.class);
            intent.putExtra("data", getData().get(position));
            ActivityUtils.startActivity(intent);
        }
    }

    VideoView getCurrentVideo() {
        return currentVideo;
    }
}
