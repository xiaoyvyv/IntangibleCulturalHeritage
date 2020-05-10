package com.xiaoyv.framework.main.mine.make;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.found.comment.FoundCommentBean;
import com.xiaoyv.cultureengine.module.main.make.MineMakeBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;

import java.util.ArrayList;
import java.util.List;


public class MainMineMakeFragment extends BaseFragment<MainMineMakeContract.Presenter> implements MainMineMakeContract.View {
    private AppCompatImageView mainMineMakeImage;
    private RecyclerView mainMineMakeRecyclerView;
    private MainMineMakeAdapter mainMineMakeAdapter;

    static MainMineMakeFragment newInstance() {
        return new MainMineMakeFragment();
    }

    @Override
    public void setPresenter(MainMineMakeContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_make;
    }

    @Override
    public void initView() {
        mainMineMakeImage = findView(R.id.main_mine_make_image);
        mainMineMakeRecyclerView = findView(R.id.main_mine_make_recycler_view);

    }

    @Override
    public void initData() {
        Glide.with(activity).load("https://img.zcool.cn/community/011199577ddaeb0000012e7ed4b1f8.jpg@1280w_1l_2o_100sh.jpg").into(mainMineMakeImage);

        mainMineMakeAdapter = new MainMineMakeAdapter(R.layout.fragment_main_mine_make_item, new ArrayList<>());
        mainMineMakeAdapter.bindToRecyclerView(mainMineMakeRecyclerView);
        mainMineMakeRecyclerView.setAdapter(mainMineMakeAdapter);
    }



    @Override
    public void showCommentItem(MineMakeBean mineMakeBean) {
        List<MineMakeBean.MineMake> mineMakes = mineMakeBean.getMineMakes();
        if (ObjectUtils.isNotEmpty(mineMakes)) {
            mainMineMakeAdapter.setNewData(mineMakes);
        }
    }
}