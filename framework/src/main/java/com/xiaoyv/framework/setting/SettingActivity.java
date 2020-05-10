package com.xiaoyv.framework.setting;

import android.app.AlertDialog;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.CleanUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xiaoyv.account.UserManager;
import com.xiaoyv.framework.BaseActivity;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.sign.login.LoginActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/5/7
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private View settingChangePassword;
    private View settingSecrecy;
    private View settingClear;
    private View settingLike;
    private View settingUpdate;
    private View settingLoginOut;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        settingChangePassword = findView(R.id.setting_change_password);
        settingSecrecy = findView(R.id.setting_secrecy);
        settingClear = findView(R.id.setting_clear);
        settingLike = findView(R.id.setting_like);
        settingUpdate = findView(R.id.setting_update);
        settingLoginOut = findView(R.id.setting_logout);
    }

    @Override
    protected void initData() {
        settingChangePassword.setOnClickListener(this);
        settingSecrecy.setOnClickListener(this);
        settingClear.setOnClickListener(this);
        settingLike.setOnClickListener(this);
        settingUpdate.setOnClickListener(this);
        settingLoginOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == settingChangePassword.getId()) {
            ToastUtils.showShort("暂不支持改密操作");
        } else if (v.getId() == settingSecrecy.getId()) {
            ToastUtils.showShort("暂不支持隐私设置");
        } else if (v.getId() == settingClear.getId()) {
            CleanUtils.cleanExternalCache();
            CleanUtils.cleanInternalCache();
            ToastUtils.showShort(getString(R.string.setting_clean_cache_success));
        } else if (v.getId() == settingLike.getId()) {
            ToastUtils.showShort(getString(R.string.setting_like_success));
        } else if (v.getId() == settingUpdate.getId()) {
            ToastUtils.showShort(getString(R.string.setting_update_new));
        } else if (v.getId() == settingLoginOut.getId()) {
            // 注销登录
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_logout)
                    .setMessage(R.string.dialog_is_logout)
                    .setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                        ToastUtils.showShort(getString(R.string.setting_logout_success));
                        UserManager.setOnline(false);
                        ActivityUtils.finishAllActivities(true);
                        ActivityUtils.startActivity(LoginActivity.class);
                    })
                    .setNegativeButton(R.string.dialog_no,null)
                    .create();
            alertDialog.show();

        }
    }
}
