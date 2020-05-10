package com.xiaoyv.framework.sign.register;

import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface RegisterContract {
    interface View extends BaseView<Presenter> {

        void showError(String error);

        void showSuccess();
    }

    interface Presenter extends BasePresenter {

        void register(String phone, String password, String password_conf);
    }
}
