package com.xiaoyv.framework.main.mine.message;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineMessageActivity extends BaseFragmentActivity<MainMineMessageFragment> {

    @Override
    protected void createPresenter(MainMineMessageFragment fragment) {
        new MainMineMessagePresenter(fragment);
    }

    @Override
    protected MainMineMessageFragment createFragment() {
        return MainMineMessageFragment.newInstance();
    }

}
