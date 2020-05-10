package com.xiaoyv.framework.main.mine.works;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineWorksActivity extends BaseFragmentActivity<MainMineWorksFragment> {

    @Override
    protected void createPresenter(MainMineWorksFragment fragment) {
        new MainMineWorksPresenter(fragment);
    }

    @Override
    protected MainMineWorksFragment createFragment() {
        return MainMineWorksFragment.newInstance();
    }

}
