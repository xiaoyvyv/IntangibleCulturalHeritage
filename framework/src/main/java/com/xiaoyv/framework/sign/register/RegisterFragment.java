package com.xiaoyv.framework.sign.register;

import android.widget.Button;
import android.widget.CheckBox;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;


public class RegisterFragment extends BaseFragment<RegisterContract.Presenter> implements RegisterContract.View {

    private TextInputEditText registerPhone;
    private TextInputEditText registerPassword;
    private TextInputEditText registerPasswordConf;
    private Button registerButton;
    private CheckBox registerCheckBox;

    static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void initView() {
        registerPhone = findView(R.id.register_phone);
        registerPassword = findView(R.id.register_password);
        registerPasswordConf = findView(R.id.register_password_conf);
        registerButton = findView(R.id.register_button);
        registerCheckBox = findView(R.id.register_check);
    }

    @Override
    public void initData() {
        registerButton.setOnClickListener(v -> {
            if (registerCheckBox.isChecked()) {
                KeyboardUtils.hideSoftInput(activity);
                presenter.register(String.valueOf(registerPhone.getText()), String.valueOf(registerPassword.getText()), String.valueOf(registerPasswordConf.getText()));

            } else {
                ToastUtils.showShort(activity.getString(R.string.register_rule));
            }
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
    public void showSuccess() {
        ToastUtils.showShort(activity.getString(R.string.register_success));
        activity.onBackPressed();
    }
}