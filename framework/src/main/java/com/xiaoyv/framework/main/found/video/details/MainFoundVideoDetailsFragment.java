package com.xiaoyv.framework.main.found.video.details;

import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.bumptech.glide.Glide;
import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.VideoView;
import com.xiaoyv.cultureengine.module.main.found.comment.FoundCommentBean;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
import com.xiaoyv.cultureengine.module.main.found.video.FoundVideoBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainFoundVideoDetailsFragment extends BaseFragment<MainFoundVideoDetailsContract.Presenter> implements MainFoundVideoDetailsContract.View {
    private RecyclerView mainFoundVideoDetailsRecyclerView;
    private MainFoundVideoDetailsAdapter mainFoundVideoDetailsAdapter;

    private VideoView mainFoundVideoDetailsAv;
    private ImageView mainFoundVideoDetailsHeader;
    private AppCompatImageView mainFoundVideoDetailsLike;
    private AppCompatImageView mainFoundVideoDetailsDislike;
    private AppCompatTextView mainFoundVideoDetailsTitle;
    private AppCompatTextView mainFoundVideoDetailsName;
    private AppCompatTextView mainFoundVideoDetailsTimes;
    private AppCompatTextView mainFoundVideoDetailsLikeCount;
    private AppCompatTextView mainFoundVideoDetailsDislikeCount;

    public static MainFoundVideoDetailsFragment newInstance() {
        return new MainFoundVideoDetailsFragment();
    }


    @Override
    public void setPresenter(MainFoundVideoDetailsContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_found_video_details;
    }

    @Override
    public void initView() {
        mainFoundVideoDetailsRecyclerView = findView(R.id.main_found_video_details_recycler_view);


        mainFoundVideoDetailsAv = findView(R.id.main_found_video_details_av);
        mainFoundVideoDetailsHeader = findView(R.id.main_found_video_details_header);
        mainFoundVideoDetailsTitle = findView(R.id.main_found_video_details_title);
        mainFoundVideoDetailsName = findView(R.id.main_found_video_details_name);
        mainFoundVideoDetailsLike = findView(R.id.main_found_video_details_like);
        mainFoundVideoDetailsDislike = findView(R.id.main_found_video_details_dislike);
        mainFoundVideoDetailsTimes = findView(R.id.main_found_video_details_times);
        mainFoundVideoDetailsLikeCount = findView(R.id.main_found_video_details_like_count);
        mainFoundVideoDetailsDislikeCount = findView(R.id.main_found_video_details_dislike_count);

    }

    @Override
    public void initData() {
        mainFoundVideoDetailsAdapter = new MainFoundVideoDetailsAdapter(R.layout.fragment_main_found_video_details_item, new ArrayList<>());
        mainFoundVideoDetailsAdapter.bindToRecyclerView(mainFoundVideoDetailsRecyclerView);
        mainFoundVideoDetailsRecyclerView.setAdapter(mainFoundVideoDetailsAdapter);
    }


    @Override
    public void showParentData(FoundVideoBean.FoundVideo foundVideo) {
        Glide.with(activity).load(foundVideo.getHeader()).into(mainFoundVideoDetailsHeader);
        mainFoundVideoDetailsName.setText(foundVideo.getName());
        mainFoundVideoDetailsTitle.setText(foundVideo.getTitle());
        mainFoundVideoDetailsLikeCount.setText(String.valueOf(foundVideo.getLike()));
        mainFoundVideoDetailsDislikeCount.setText(String.valueOf(foundVideo.getDislike()));

        mainFoundVideoDetailsAv.release();
        mainFoundVideoDetailsAv.setUrl(foundVideo.getVideo());
        StandardVideoController controller = new StandardVideoController(activity) ;
        controller.addDefaultControlComponent(foundVideo.getTitle(), false);
        mainFoundVideoDetailsAv.setVideoController(controller);

        toolbar.setTitle(foundVideo.getTitle());
    }

    @Override
    public void showCommentItem(FoundCommentBean foundCommentBean) {
        List<FoundCommentBean.FoundComment> comments = foundCommentBean.getFoundComments();
        if (ObjectUtils.isNotEmpty(comments)) {
            mainFoundVideoDetailsAdapter.setNewData(comments);
        }
    }

    @Override
    public void onPause() {
        mainFoundVideoDetailsAv.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mainFoundVideoDetailsAv.resume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mainFoundVideoDetailsAv.release();
        super.onDestroy();
    }

    @Override
    public boolean onBackPressed() {
        return mainFoundVideoDetailsAv.onBackPressed();
    }
}
