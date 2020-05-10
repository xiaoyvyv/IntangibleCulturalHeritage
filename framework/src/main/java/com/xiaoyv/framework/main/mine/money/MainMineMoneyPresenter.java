package com.xiaoyv.framework.main.mine.money;

import androidx.annotation.NonNull;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainMineMoneyPresenter implements MainMineMoneyContract.Presenter {

    @NonNull
    private final MainMineMoneyContract.View view;

    MainMineMoneyPresenter(@NonNull MainMineMoneyContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
