package com.xiaoyv.framework.splash;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.Utils;
import com.xiaoyv.account.UserManager;
import com.xiaoyv.framework.BaseActivity;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.MainActivity;
import com.xiaoyv.framework.sign.login.LoginActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Utils.runOnUiThreadDelayed(() -> {
            if (UserManager.isOnline()) {
                ActivityUtils.startActivity(MainActivity.class);
            } else  {
                ActivityUtils.startActivity(LoginActivity.class);
            }
            ActivityUtils.finishActivity(SplashActivity.this);
        }, 2000);
    }

    @Override
    public void onBackPressed() {
        LogUtils.i("禁止返回操作");
    }
}
