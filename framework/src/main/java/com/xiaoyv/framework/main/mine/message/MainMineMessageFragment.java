package com.xiaoyv.framework.main.mine.message;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.xiaoyv.cultureengine.module.Type;
import com.xiaoyv.cultureengine.module.main.mine.message.MineMessageType;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.BaseFragmentAdapter;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.mine.message.page.MainMineMessagePageFragment;
import com.xiaoyv.framework.main.mine.message.page.MainMineMessagePagePresenter;
import com.xiaoyv.framework.main.news.page.MainNewsPageFragment;
import com.xiaoyv.framework.main.news.page.MainNewsPagePresenter;


public class MainMineMessageFragment extends BaseFragment<MainMineMessageContract.Presenter> implements MainMineMessageContract.View {
    private TabLayout mainMineMessageTabLayout;
    private ViewPager mainMineMessageViewpager;

    static MainMineMessageFragment newInstance() {
        return new MainMineMessageFragment();
    }

    @Override
    public void setPresenter(MainMineMessageContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_message;
    }

    @Override
    public void initView() {
        mainMineMessageTabLayout = findView(R.id.main_mine_message_tab_layout);
        mainMineMessageViewpager = findView(R.id.main_mine_message_viewpager);
    }

    @Override
    public void initData() {
        MainMineMessagePageFragment fragment0 = MainMineMessagePageFragment.newInstance();
        MainMineMessagePageFragment fragment1= MainMineMessagePageFragment.newInstance();
        MainMineMessagePageFragment fragment2 = MainMineMessagePageFragment.newInstance();

        BaseFragmentAdapter fragmentAdapter = new BaseFragmentAdapter(activity.getSupportFragmentManager());
        fragmentAdapter.addFragment(getString(R.string.main_mine_message_notice), fragment0);
        fragmentAdapter.addFragment(getString(R.string.main_mine_message_comment), fragment1);
        fragmentAdapter.addFragment(getString(R.string.main_mine_message_chat), fragment2);

        new MainMineMessagePagePresenter(fragment0, MineMessageType.NOTICE);
        new MainMineMessagePagePresenter(fragment1, MineMessageType.COMMENT);
        new MainMineMessagePagePresenter(fragment2, MineMessageType.CHAT);

        mainMineMessageViewpager.setOffscreenPageLimit(fragmentAdapter.getCount());
        mainMineMessageViewpager.setAdapter(fragmentAdapter);
        mainMineMessageTabLayout.setupWithViewPager(mainMineMessageViewpager);
    }


}