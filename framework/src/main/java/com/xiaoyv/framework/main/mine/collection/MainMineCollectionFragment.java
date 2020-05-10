package com.xiaoyv.framework.main.mine.collection;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.xiaoyv.cultureengine.module.main.mine.collection.MineCollectionBean;
import com.xiaoyv.cultureengine.module.main.mine.fans.MineFansBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.mine.fans.MainMineFansAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainMineCollectionFragment extends BaseFragment<MainMineCollectionContract.Presenter> implements MainMineCollectionContract.View {
    private RecyclerView mainMineCollectionRecyclerView;
    private MainMineCollectionAdapter mainMineCollectionAdapter;

    static MainMineCollectionFragment newInstance() {
        return new MainMineCollectionFragment();
    }

    @Override
    public void setPresenter(MainMineCollectionContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_collection;
    }

    @Override
    public void initView() {
        mainMineCollectionRecyclerView = findView(R.id.main_mine_collection_recycler_view);
    }

    @Override
    public void initData() {
        mainMineCollectionAdapter = new MainMineCollectionAdapter(R.layout.fragment_main_mine_collection_item, new ArrayList<>());
        mainMineCollectionAdapter.bindToRecyclerView(mainMineCollectionRecyclerView);
        mainMineCollectionRecyclerView.setAdapter(mainMineCollectionAdapter);
    }

    @Override
    public void showCollection(MineCollectionBean mineCollectionBean) {
        List<MineCollectionBean.MineCollection> mineCollections = mineCollectionBean.getMineCollections();
        if (ObjectUtils.isNotEmpty(mineCollections)) {
            mainMineCollectionAdapter.setNewData(mineCollections);
        }
    }
}