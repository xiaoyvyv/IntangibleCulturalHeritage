package com.xiaoyv.framework.main.mine.make;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineMakeActivity extends BaseFragmentActivity<MainMineMakeFragment> {

    @Override
    protected void createPresenter(MainMineMakeFragment fragment) {
        new MainMineMakePresenter(fragment);
    }

    @Override
    protected MainMineMakeFragment createFragment() {
        return MainMineMakeFragment.newInstance();
    }

}
