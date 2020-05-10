package com.xiaoyv.framework.main.mine.dynamic;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.xiaoyv.cultureengine.module.main.mine.dynamic.MineDynamicBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;

import java.util.ArrayList;
import java.util.List;


public class MainMineDynamicFragment extends BaseFragment<MainMineDynamicContract.Presenter> implements MainMineDynamicContract.View {
    private RecyclerView mainMineDynamicRecyclerView;
    private MainMineDynamicAdapter mainMineDynamicAdapter;

    static MainMineDynamicFragment newInstance() {
        return new MainMineDynamicFragment();
    }

    @Override
    public void setPresenter(MainMineDynamicContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_dynamic;
    }

    @Override
    public void initView() {
        mainMineDynamicRecyclerView = findView(R.id.main_mine_dynamic_recycler_view);
    }

    @Override
    public void initData() {
        mainMineDynamicAdapter = new MainMineDynamicAdapter(R.layout.fragment_main_mine_dynamic_item, new ArrayList<>());
        mainMineDynamicAdapter.bindToRecyclerView(mainMineDynamicRecyclerView);
        mainMineDynamicRecyclerView.setAdapter(mainMineDynamicAdapter);
    }

    @Override
    public void showDynamic(MineDynamicBean mineDynamicBean) {
        List<MineDynamicBean.MineDynamic> mineDynamics = mineDynamicBean.getMineDynamics();
        if (ObjectUtils.isNotEmpty(mineDynamics)) {
            mainMineDynamicAdapter.setNewData(mineDynamics);
        }
    }

}