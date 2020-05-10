package com.xiaoyv.framework.sign.login;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xiaoyv.framework.BaseFragmentActivity;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.home.MainHomeFragment;
import com.xiaoyv.framework.main.home.MainHomePresenter;
import com.xiaoyv.framework.sign.register.RegisterActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class LoginActivity extends BaseFragmentActivity<LoginFragment> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void createPresenter(LoginFragment fragment) {
        new LoginPresenter(fragment);
    }

    @Override
    protected LoginFragment createFragment() {
        return LoginFragment.newInstance();
    }


    public void onLoginClick(View view) {
        if (view.getId() == R.id.login_register) {
            ActivityUtils.startActivity(RegisterActivity.class);
        } else if (view.getId() == R.id.login_forget) {
            ToastUtils.showShort("暂不支持密码找回，请重新注册");
        } else if (view.getId() == R.id.login_qq) {
            ToastUtils.showShort("暂不支持QQ授权登录");
        } else if (view.getId() == R.id.login_zone) {
            ToastUtils.showShort("暂不支持QQ空间授权登录");
        } else if (view.getId() == R.id.login_wechat) {
            ToastUtils.showShort("暂不支持微信授权登录");
        } else if (view.getId() == R.id.login_weibo) {
            ToastUtils.showShort("暂不支持微博授权登录");
        }
    }
}
