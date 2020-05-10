package com.xiaoyv.framework.main.mine.attention;

import com.xiaoyv.framework.BaseFragmentActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineAttentionActivity extends BaseFragmentActivity<MainMineAttentionFragment> {

    @Override
    protected void createPresenter(MainMineAttentionFragment fragment) {
        new MainMineAttentionPresenter(fragment);
    }

    @Override
    protected MainMineAttentionFragment createFragment() {
        return MainMineAttentionFragment.newInstance();
    }

}
