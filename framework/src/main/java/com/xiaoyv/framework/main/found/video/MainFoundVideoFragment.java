package com.xiaoyv.framework.main.found.video;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.dueeeke.videoplayer.player.VideoView;
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
public class MainFoundVideoFragment extends BaseFragment<MainFoundVideoContract.Presenter> implements MainFoundVideoContract.View {
    private RecyclerView mainFoundVideoRecyclerView;
    private MainFoundVideoAdapter mainFoundVideoAdapter;

    public static MainFoundVideoFragment newInstance() {
        return new MainFoundVideoFragment();
    }


    @Override
    public void setPresenter(MainFoundVideoContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_found_video;
    }

    @Override
    public void initView() {
        mainFoundVideoRecyclerView = findView(R.id.main_found_video_recycler_view);
    }

    @Override
    public void initData() {
        mainFoundVideoAdapter = new MainFoundVideoAdapter(R.layout.fragment_main_found_video_item, new ArrayList<>());
        mainFoundVideoAdapter.bindToRecyclerView(mainFoundVideoRecyclerView);
        mainFoundVideoRecyclerView.setAdapter(mainFoundVideoAdapter);
    }

    @Override
    public void showItem(FoundVideoBean foundVideoBean) {
        List<FoundVideoBean.FoundVideo> foundVideos = foundVideoBean.getFoundVideos();
        if (ObjectUtils.isNotEmpty(foundVideos)) {
            mainFoundVideoAdapter.setNewData(foundVideos);
        }
    }

    @Override
    public boolean onBackPressed() {
        if (mainFoundVideoAdapter == null) {
            return false;
        }
        VideoView currentVideo = mainFoundVideoAdapter.getCurrentVideo();
        if (currentVideo == null) {
            return false;
        }
        return currentVideo.onBackPressed();
    }


    @Override
    public void onDestroyView() {
        if (mainFoundVideoAdapter != null) {
            VideoView currentVideo = mainFoundVideoAdapter.getCurrentVideo();
            if (currentVideo != null) {
                currentVideo.pause();
                currentVideo.release();
            }
        }
        super.onDestroyView();
    }
}
