package com.xiaoyv.framework.main.mine.money;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineMoneyActivity extends BaseFragmentActivity<MainMineMoneyFragment> {

    @Override
    protected void createPresenter(MainMineMoneyFragment fragment) {
        new MainMineMoneyPresenter(fragment);
    }

    @Override
    protected MainMineMoneyFragment createFragment() {
        return MainMineMoneyFragment.newInstance();
    }

}
