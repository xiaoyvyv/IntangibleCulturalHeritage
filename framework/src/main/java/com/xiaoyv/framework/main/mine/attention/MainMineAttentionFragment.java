package com.xiaoyv.framework.main.mine.attention;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.ObjectUtils;
import com.google.android.material.tabs.TabLayout;
import com.xiaoyv.cultureengine.module.main.mine.attention.MineAttentionBean;
import com.xiaoyv.cultureengine.module.main.mine.fans.MineFansBean;
import com.xiaoyv.cultureengine.module.main.mine.message.MineMessageType;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.BaseFragmentAdapter;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.mine.fans.MainMineFansAdapter;
import com.xiaoyv.framework.main.mine.message.page.MainMineMessagePageAdapter;
import com.xiaoyv.framework.main.mine.message.page.MainMineMessagePageFragment;
import com.xiaoyv.framework.main.mine.message.page.MainMineMessagePagePresenter;

import java.util.ArrayList;
import java.util.List;


public class MainMineAttentionFragment extends BaseFragment<MainMineAttentionContract.Presenter> implements MainMineAttentionContract.View {
    private RecyclerView mainMineAttentionRecyclerView;
    private MainMineAttentionAdapter mainMineAttentionAdapter;

    static MainMineAttentionFragment newInstance() {
        return new MainMineAttentionFragment();
    }

    @Override
    public void setPresenter(MainMineAttentionContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_attention;
    }


    @Override
    public void initView() {
        mainMineAttentionRecyclerView = findView(R.id.main_mine_attention_recycler_view);
    }

    @Override
    public void initData() {
        mainMineAttentionAdapter = new MainMineAttentionAdapter(R.layout.fragment_main_mine_attention_item, new ArrayList<>());
        mainMineAttentionAdapter.bindToRecyclerView(mainMineAttentionRecyclerView);
        mainMineAttentionRecyclerView.setAdapter(mainMineAttentionAdapter);
    }


    @Override
    public void showAttention(MineAttentionBean bean) {
        List<MineAttentionBean.MineAttention> mineAttentions = bean.getMineAttentions();
        if (ObjectUtils.isNotEmpty(mineAttentions)) {
            mainMineAttentionAdapter.setNewData(mineAttentions);
        }
    }
}