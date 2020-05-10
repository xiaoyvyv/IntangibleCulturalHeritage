package com.xiaoyv.framework;

import android.view.View;

import com.blankj.utilcode.util.FragmentUtils;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public abstract class BaseFragmentActivity<T extends BaseFragment> extends BaseActivity {
    public T fragment;
    protected View rootView;

    /**
     * @return 获取布局文件ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_root;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        // 绑定 默认布局文件
        rootView = findView(R.id.root_view);
    }

    /**
     * 载入数据
     */
    @Override
    protected void initData() {
        fragment = createFragment();
        fragment.setUserVisibleHint(true);
        FragmentUtils.add(getSupportFragmentManager(), fragment, rootView.getId(), false);
        createPresenter(fragment);
    }

    /**
     * 创建 P 层
     */
    protected abstract void createPresenter(T fragment);

    protected abstract T createFragment();

}
