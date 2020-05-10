package com.xiaoyv.framework.main.mine.money;

import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;


public class MainMineMoneyFragment extends BaseFragment<MainMineMoneyContract.Presenter> implements MainMineMoneyContract.View {

    static MainMineMoneyFragment newInstance() {
        return new MainMineMoneyFragment();
    }

    @Override
    public void setPresenter(MainMineMoneyContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_money;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


}