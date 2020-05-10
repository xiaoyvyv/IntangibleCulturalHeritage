package com.xiaoyv.framework.main.mine.collection;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineCollectionActivity extends BaseFragmentActivity<MainMineCollectionFragment> {

    @Override
    protected void createPresenter(MainMineCollectionFragment fragment) {
        new MainMineCollectionPresenter(fragment);
    }

    @Override
    protected MainMineCollectionFragment createFragment() {
        return MainMineCollectionFragment.newInstance();
    }

}
