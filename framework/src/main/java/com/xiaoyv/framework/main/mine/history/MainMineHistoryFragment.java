package com.xiaoyv.framework.main.mine.history;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.xiaoyv.cultureengine.module.main.mine.collection.MineCollectionBean;
import com.xiaoyv.cultureengine.module.main.mine.history.MineHistoryBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.mine.collection.MainMineCollectionAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainMineHistoryFragment extends BaseFragment<MainMineHistoryContract.Presenter> implements MainMineHistoryContract.View {
    private RecyclerView mainMineHistoryRecyclerView;
    private MainMineHistoryAdapter mainMineHistoryAdapter;

    static MainMineHistoryFragment newInstance() {
        return new MainMineHistoryFragment();
    }

    @Override
    public void setPresenter(MainMineHistoryContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_history;
    }

    @Override
    public void initView() {
        mainMineHistoryRecyclerView = findView(R.id.main_mine_history_recycler_view);
    }

    @Override
    public void initData() {
        mainMineHistoryAdapter = new MainMineHistoryAdapter(R.layout.fragment_main_mine_history_item, new ArrayList<>());
        mainMineHistoryAdapter.bindToRecyclerView(mainMineHistoryRecyclerView);
        mainMineHistoryRecyclerView.setAdapter(mainMineHistoryAdapter);
    }

    @Override
    public void showHistory(MineHistoryBean mineHistoryBean) {
        List<MineHistoryBean.MineHistory> mineHistories = mineHistoryBean.getMineHistories();
        if (ObjectUtils.isNotEmpty(mineHistories)) {
            mainMineHistoryAdapter.setNewData(mineHistories);
        }
    }

}