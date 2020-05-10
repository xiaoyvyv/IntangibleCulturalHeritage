package com.xiaoyv.framework.main.mine.works;

import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;


public class MainMineWorksFragment extends BaseFragment<MainMineWorksContract.Presenter> implements MainMineWorksContract.View {

    static MainMineWorksFragment newInstance() {
        return new MainMineWorksFragment();
    }

    @Override
    public void setPresenter(MainMineWorksContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_works;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


}