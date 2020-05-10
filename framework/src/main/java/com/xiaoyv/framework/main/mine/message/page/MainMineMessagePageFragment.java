package com.xiaoyv.framework.main.mine.message.page;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.xiaoyv.cultureengine.module.main.home.HomeItemBean;
import com.xiaoyv.cultureengine.module.main.mine.message.MineMessageBean;
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
public class MainMineMessagePageFragment extends BaseFragment<MainMineMessagePageContract.Presenter> implements MainMineMessagePageContract.View {
    private RecyclerView mainMineMessagePageRecyclerView;
    private MainMineMessagePageAdapter mainMineMessagePageAdapter;

    public static MainMineMessagePageFragment newInstance() {
        return  new MainMineMessagePageFragment();
    }


    @Override
    public void setPresenter(MainMineMessagePageContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_message_page;
    }

    @Override
    public void initView() {
        mainMineMessagePageRecyclerView = findView(R.id.main_mine_message_page_recycler_view);
    }

    @Override
    public void initData() {
        mainMineMessagePageAdapter = new MainMineMessagePageAdapter(R.layout.fragment_main_mine_message_page_item, new ArrayList<>());
        mainMineMessagePageRecyclerView.setAdapter(mainMineMessagePageAdapter);
    }


    @Override
    public void showMessage(MineMessageBean mineMessageBean) {
        List<MineMessageBean.MineMessage> mineMessages = mineMessageBean.getMineMessages();
        if (ObjectUtils.isNotEmpty(mineMessages)) {
            mainMineMessagePageAdapter.setNewData(mineMessages);
        }
    }
}
