package com.xiaoyv.framework.main.mine.history;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineHistoryActivity extends BaseFragmentActivity<MainMineHistoryFragment> {

    @Override
    protected void createPresenter(MainMineHistoryFragment fragment) {
        new MainMineHistoryPresenter(fragment);
    }

    @Override
    protected MainMineHistoryFragment createFragment() {
        return MainMineHistoryFragment.newInstance();
    }

}
