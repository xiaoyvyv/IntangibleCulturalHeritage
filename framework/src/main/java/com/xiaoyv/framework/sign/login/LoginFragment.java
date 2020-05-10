package com.xiaoyv.framework.sign.login;

import android.app.ProgressDialog;
import android.widget.Button;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.MainActivity;


public class LoginFragment extends BaseFragment<LoginContract.Presenter> implements LoginContract.View {

    private TextInputEditText loginPhone;
    private TextInputEditText loginPassword;
    private Button loginButton;
    private ProgressDialog loginDialog;

    static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initView() {
        loginPhone = findView(R.id.login_phone);
        loginPassword = findView(R.id.login_password);
        loginButton = findView(R.id.login_button);
    }

    @Override
    public void initData() {
        // 登录中对话框
        loginDialog = new ProgressDialog(activity);
        loginDialog.setMessage(activity.getString(R.string.login_logging));
        loginDialog.setCanceledOnTouchOutside(false);
        loginDialog.setCancelable(false);

        loginButton.setOnClickListener(v -> {
            KeyboardUtils.hideSoftInput(activity);
            presenter.login(String.valueOf(loginPhone.getText()), String.valueOf(loginPassword.getText()));
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void showError(String error) {
        ToastUtils.showShort(error);
    }

    @Override
    public void onSuccess() {
        ToastUtils.showShort(activity.getString(R.string.login_success));
        ActivityUtils.startActivity(MainActivity.class);
        ActivityUtils.finishActivity(activity);
    }

    @Override
    public void showProgress() {
        loginDialog.show();
    }

    @Override
    public void hideProgress() {
        loginDialog.dismiss();
    }
}