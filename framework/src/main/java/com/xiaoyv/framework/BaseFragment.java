package com.xiaoyv.framework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P presenter;
    protected View rootView;
    protected Toolbar toolbar;
    protected FragmentActivity activity;
    private boolean isViewBind = false;
    private boolean isLoaded = false;
    private boolean visibleHint = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        initView();
        initToolbar();

        isViewBind = true;
        lazyLoad();
        return rootView;
    }

    /**
     * 绑定 Toolbar
     */
    private void initToolbar() {
        // 查询绑定 Toolbar
        toolbar = findView(getToolbarId());
        if (toolbar != null && isToolbarCanBack()) {
            toolbar.setNavigationIcon(R.drawable.ic_back);
            // 返回键
            toolbar.setNavigationOnClickListener(view -> {
                if (activity != null)
                    activity.onBackPressed();
            });
        }
    }


    @SuppressWarnings("deprecation")
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        visibleHint = isVisibleToUser;
        lazyLoad();
    }

    private void lazyLoad() {
        if (visibleHint) {
            if (isViewBind && !isLoaded) {
                initData();
                initListener();
                startAnimate();
                isLoaded = true;

                // P 层开始
                if (presenter != null)
                    presenter.start();
            }
        }
    }

    /**
     * 查找控件
     */
    protected <T extends View> T findView(@IdRes int ids) {
        if (rootView == null) {
            throw new NullPointerException("Fragment引入的布局视图为空");
        } else {
            return rootView.findViewById(ids);
        }
    }

    /**
     * 绑定Toolbar
     */
    private @IdRes
    int getToolbarId() {
        return R.id.toolbar;
    }

    /**
     * 布局 ID
     */
    public abstract int getLayoutId();

    /**
     * 初始化界面
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 填充 P 层对象
     *
     * @param presenter presenter
     */
    public void setFragmentPresenter(P presenter) {
        this.presenter = presenter;
    }

    /**
     * 监听器
     */
    public void initListener() {

    }

    /**
     * 界面动画
     */
    public void startAnimate() {

    }

    /**
     * @return Toolbar 是否有返回按钮
     */
    public boolean isToolbarCanBack() {
        return false;
    }

    /**
     * @return 是否拦截Fragment界面的反回键
     */
    public boolean onBackPressed() {
        return false;
    }
}
