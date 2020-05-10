package com.xiaoyv.framework.main.mine.fans;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.xiaoyv.cultureengine.module.main.mine.fans.MineFansBean;
import com.xiaoyv.cultureengine.module.main.mine.message.MineMessageBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.mine.message.page.MainMineMessagePageAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainMineFansFragment extends BaseFragment<MainMineFansContract.Presenter> implements MainMineFansContract.View {
    private RecyclerView mainMineFansRecyclerView;
    private MainMineFansAdapter mainMineFansAdapter;

    static MainMineFansFragment newInstance() {
        return new MainMineFansFragment();
    }

    @Override
    public void setPresenter(MainMineFansContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_fans;
    }


    @Override
    public void initView() {
        mainMineFansRecyclerView = findView(R.id.main_mine_fans_recycler_view);
    }

    @Override
    public void initData() {
        mainMineFansAdapter = new MainMineFansAdapter(R.layout.fragment_main_mine_fans_item, new ArrayList<>());
        mainMineFansAdapter.bindToRecyclerView(mainMineFansRecyclerView);
        mainMineFansRecyclerView.setAdapter(mainMineFansAdapter);
    }


    @Override
    public void showFans(MineFansBean bean) {
        List<MineFansBean.MineFans> mineFans = bean.getMineFans();
        if (ObjectUtils.isNotEmpty(mineFans)) {
            mainMineFansAdapter.setNewData(mineFans);
        }
    }
}