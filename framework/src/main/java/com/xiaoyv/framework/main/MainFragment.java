package com.xiaoyv.framework.main;

import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;

import com.blankj.utilcode.util.FragmentUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.found.MainFoundFragment;
import com.xiaoyv.framework.main.found.MainFoundPresenter;
import com.xiaoyv.framework.main.home.MainHomeFragment;
import com.xiaoyv.framework.main.home.MainHomePresenter;
import com.xiaoyv.framework.main.mine.MainMineFragment;
import com.xiaoyv.framework.main.mine.MainMinePresenter;
import com.xiaoyv.framework.main.news.MainNewsFragment;
import com.xiaoyv.framework.main.news.MainNewsPresenter;


public class MainFragment extends BaseFragment<MainContract.Presenter> implements MainContract.View {
    public BottomNavigationView mainBottomView;
    private FrameLayout mainContainer;
    private MainHomeFragment homeFragment;
    public MainNewsFragment newsFragment;
    private MainFoundFragment foundFragment;
    private MainMineFragment mineFragment;

    static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView() {
        mainContainer = findView(R.id.main_container);
        mainBottomView = findView(R.id.main_bottom_view);
    }

    @Override
    public void initData() {
        FragmentManager manager = activity.getSupportFragmentManager();

        homeFragment = MainHomeFragment.newInstance();
        newsFragment = MainNewsFragment.newInstance();
        foundFragment = MainFoundFragment.newInstance();
        mineFragment = MainMineFragment.newInstance();

        FragmentUtils.add(manager, homeFragment, mainContainer.getId(), false);
        homeFragment.setUserVisibleHint(true);
        FragmentUtils.add(manager, newsFragment, mainContainer.getId(), true);
        FragmentUtils.add(manager, foundFragment, mainContainer.getId(), true);
        FragmentUtils.add(manager, mineFragment, mainContainer.getId(), true);

        new MainHomePresenter(homeFragment);
        new MainNewsPresenter(newsFragment);
        new MainFoundPresenter(foundFragment);
        new MainMinePresenter(mineFragment);

    }

    @Override
    public void initListener() {
        mainBottomView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.main_bottom_home) {
                FragmentUtils.showHide(homeFragment, newsFragment, foundFragment, mineFragment);
                homeFragment.setUserVisibleHint(true);
                return true;
            } else if (item.getItemId() == R.id.main_bottom_news) {
                FragmentUtils.showHide(newsFragment, homeFragment, foundFragment, mineFragment);
                newsFragment.setUserVisibleHint(true);
                return true;
            } else if (item.getItemId() == R.id.main_bottom_found) {
                FragmentUtils.showHide(foundFragment, homeFragment, newsFragment, mineFragment);
                foundFragment.setUserVisibleHint(true);
                return true;
            } else if (item.getItemId() == R.id.main_bottom_mine) {
                FragmentUtils.showHide(mineFragment, homeFragment, newsFragment, foundFragment);
                mineFragment.setUserVisibleHint(true);
                return true;
            }
            return false;
        });
    }

    @Override
    public boolean onBackPressed() {
        return foundFragment != null && foundFragment.onBackPressed();
    }
}