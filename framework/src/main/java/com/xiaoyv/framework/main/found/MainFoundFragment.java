package com.xiaoyv.framework.main.found;

import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.LogUtils;
import com.google.android.material.tabs.TabLayout;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.BaseFragmentAdapter;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.found.hot.MainFoundHotFragment;
import com.xiaoyv.framework.main.found.hot.MainFoundHotPresenter;
import com.xiaoyv.framework.main.found.page.MainFoundPageFragment;
import com.xiaoyv.framework.main.found.page.MainFoundPagePresenter;
import com.xiaoyv.framework.main.found.video.MainFoundVideoFragment;
import com.xiaoyv.framework.main.found.video.MainFoundVideoPresenter;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainFoundFragment extends BaseFragment<MainFoundContract.Presenter> implements MainFoundContract.View {
    private TabLayout mainFoundTabLayout;
    private ViewPager mainFoundViewpager;
    private MainFoundVideoFragment fragment1;


    public static MainFoundFragment newInstance() {
        return new MainFoundFragment();
    }

    @Override
    public void setPresenter(MainFoundContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_found;
    }

    @Override
    public void initView() {
        mainFoundTabLayout = findView(R.id.main_found_tab_layout);
        mainFoundViewpager = findView(R.id.main_found_viewpager);
    }

    @Override
    public void initData() {
        MainFoundHotFragment fragment0 = MainFoundHotFragment.newInstance();
        fragment0.setUserVisibleHint(true);
        fragment1 = MainFoundVideoFragment.newInstance();
        MainFoundPageFragment fragment2 = MainFoundPageFragment.newInstance();

        BaseFragmentAdapter fragmentAdapter = new BaseFragmentAdapter(activity.getSupportFragmentManager());
        fragmentAdapter.addFragment(getString(R.string.main_found_hot), fragment0);
        fragmentAdapter.addFragment(getString(R.string.main_found_video), fragment1);
        fragmentAdapter.addFragment(getString(R.string.main_found_inherited), fragment2);

        new MainFoundHotPresenter(fragment0);
        new MainFoundVideoPresenter(fragment1);
        new MainFoundPagePresenter(fragment2);

        mainFoundViewpager.setOffscreenPageLimit(fragmentAdapter.getCount());
        mainFoundViewpager.setAdapter(fragmentAdapter);
        mainFoundTabLayout.setupWithViewPager(mainFoundViewpager);
    }

    @Override
    public boolean onBackPressed() {
        return fragment1 != null && fragment1.onBackPressed();
    }
}
