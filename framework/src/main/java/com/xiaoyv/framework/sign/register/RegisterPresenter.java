package com.xiaoyv.framework.sign.register;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.StringUtils;
import com.xiaoyv.account.UserManager;
import com.xiaoyv.account.datebase.User;
import com.xiaoyv.account.listener.OnUserDataListener;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class RegisterPresenter implements RegisterContract.Presenter {

    @NonNull
    private final RegisterContract.View view;

    RegisterPresenter(@NonNull RegisterContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void register(String phone, String password, String password_conf) {

        if (!StringUtils.equals(password, password_conf)) {
            view.showError("两次密码输入不一致");
            return;
        }
        User user = User.newUser(phone, password);

        UserManager.register(user, new OnUserDataListener() {
            @Override
            public void onError(String error) {
                view.showError(error);
            }

            @Override
            public void onSuccess() {
                view.showSuccess();
            }
        });

    }
}
