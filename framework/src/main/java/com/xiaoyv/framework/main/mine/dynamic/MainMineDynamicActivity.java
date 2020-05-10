package com.xiaoyv.framework.main.mine.dynamic;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineDynamicActivity extends BaseFragmentActivity<MainMineDynamicFragment> {

    @Override
    protected void createPresenter(MainMineDynamicFragment fragment) {
        new MainMineDynamicPresenter(fragment);
    }

    @Override
    protected MainMineDynamicFragment createFragment() {
        return MainMineDynamicFragment.newInstance();
    }

}
