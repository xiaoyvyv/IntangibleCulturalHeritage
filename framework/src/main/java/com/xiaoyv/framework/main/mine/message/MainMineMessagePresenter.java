package com.xiaoyv.framework.main.mine.message;

import androidx.annotation.NonNull;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainMineMessagePresenter implements MainMineMessageContract.Presenter {

    @NonNull
    private final MainMineMessageContract.View view;

    MainMineMessagePresenter(@NonNull MainMineMessageContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
