package com.xiaoyv.framework.main.news;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.xiaoyv.cultureengine.module.Type;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.BaseFragmentAdapter;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.news.page.MainNewsPageFragment;
import com.xiaoyv.framework.main.news.page.MainNewsPagePresenter;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainNewsFragment extends BaseFragment<MainNewsContract.Presenter> implements MainNewsContract.View {
    private TabLayout mainNewsTabLayout;
    public ViewPager mainNewsViewpager;

    public static MainNewsFragment newInstance() {
        return new MainNewsFragment();
    }

    @Override
    public void setPresenter(MainNewsContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_news;
    }

    @Override
    public void initView() {
        mainNewsTabLayout = findView(R.id.main_news_tab_layout);
        mainNewsViewpager = findView(R.id.main_news_viewpager);
    }

    @Override
    public void initData() {
        MainNewsPageFragment fragment0 = MainNewsPageFragment.newInstance(Type.WORD);
        MainNewsPageFragment fragment1 = MainNewsPageFragment.newInstance(Type.DANCE);
        MainNewsPageFragment fragment2 = MainNewsPageFragment.newInstance(Type.SONG);
        MainNewsPageFragment fragment3 = MainNewsPageFragment.newInstance(Type.ART);
        MainNewsPageFragment fragment4 = MainNewsPageFragment.newInstance(Type.MEDICINE);
        MainNewsPageFragment fragment5 = MainNewsPageFragment.newInstance(Type.MUSIC);
        MainNewsPageFragment fragment6 = MainNewsPageFragment.newInstance(Type.DRAMA);
        MainNewsPageFragment fragment7 = MainNewsPageFragment.newInstance(Type.ACROBATICS);
        MainNewsPageFragment fragment8 = MainNewsPageFragment.newInstance(Type.SKILL);
        MainNewsPageFragment fragment9 = MainNewsPageFragment.newInstance(Type.FOLKORE);

        BaseFragmentAdapter fragmentAdapter = new BaseFragmentAdapter(activity.getSupportFragmentManager());
        fragmentAdapter.addFragment(getString(R.string.main_home_word), fragment0);
        fragmentAdapter.addFragment(getString(R.string.main_home_dance), fragment1);
        fragmentAdapter.addFragment(getString(R.string.main_home_song), fragment2);
        fragmentAdapter.addFragment(getString(R.string.main_home_art), fragment3);
        fragmentAdapter.addFragment(getString(R.string.main_home_medicine), fragment4);
        fragmentAdapter.addFragment(getString(R.string.main_home_music), fragment5);
        fragmentAdapter.addFragment(getString(R.string.main_home_drama), fragment6);
        fragmentAdapter.addFragment(getString(R.string.main_home_acrobatics), fragment7);
        fragmentAdapter.addFragment(getString(R.string.main_home_skill), fragment8);
        fragmentAdapter.addFragment(getString(R.string.main_home_folklore), fragment9);

        new MainNewsPagePresenter(fragment0);
        new MainNewsPagePresenter(fragment1);
        new MainNewsPagePresenter(fragment2);
        new MainNewsPagePresenter(fragment3);
        new MainNewsPagePresenter(fragment4);
        new MainNewsPagePresenter(fragment5);
        new MainNewsPagePresenter(fragment6);
        new MainNewsPagePresenter(fragment7);
        new MainNewsPagePresenter(fragment8);
        new MainNewsPagePresenter(fragment9);

        mainNewsViewpager.setOffscreenPageLimit(fragmentAdapter.getCount());
        mainNewsViewpager.setAdapter(fragmentAdapter);
        mainNewsTabLayout.setupWithViewPager(mainNewsViewpager);
    }
}
