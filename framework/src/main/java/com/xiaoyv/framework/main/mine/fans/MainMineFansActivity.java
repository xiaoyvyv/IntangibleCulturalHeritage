package com.xiaoyv.framework.main.mine.fans;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineFansActivity extends BaseFragmentActivity<MainMineFansFragment> {

    @Override
    protected void createPresenter(MainMineFansFragment fragment) {
        new MainMineFansPresenter(fragment);
    }

    @Override
    protected MainMineFansFragment createFragment() {
        return MainMineFansFragment.newInstance();
    }

}
