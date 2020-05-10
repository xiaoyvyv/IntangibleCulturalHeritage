package com.xiaoyv.framework;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setPortrait(this);
        setContentView(getLayoutId());
        initView();
        initAnimate();
        initToolbar();
        initData();
        initListener();
    }

    /**
     * @return 获取布局文件ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 载入数据
     */
    protected abstract void initData();

    /**
     * 设置监听器
     */
    public void initListener() {

    }

    /**
     * 界面动画
     */
    public void initAnimate() {

    }

    /**
     * 查找控件
     */
    @SuppressWarnings("unchecked")
    public <VIEW extends View> VIEW findView(@IdRes int viewId) {
        return (VIEW) findViewById(viewId);
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
            toolbar.setNavigationOnClickListener(view ->
                    onBackPressed());
        }
    }

    private boolean isToolbarCanBack() {
        return true;
    }

    public int getToolbarId() {
        return R.id.toolbar;
    }

}
