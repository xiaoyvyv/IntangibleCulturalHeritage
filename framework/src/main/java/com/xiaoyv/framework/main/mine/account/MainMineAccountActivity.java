package com.xiaoyv.framework.main.mine.account;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineAccountActivity extends BaseFragmentActivity<MainMineAccountFragment> {

    @Override
    protected void createPresenter(MainMineAccountFragment fragment) {
        new MainMineAccountPresenter(fragment);
    }

    @Override
    protected MainMineAccountFragment createFragment() {
        return MainMineAccountFragment.newInstance();
    }

}
