package com.xiaoyv.framework.main.mine.works;

import androidx.annotation.NonNull;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainMineWorksPresenter implements MainMineWorksContract.Presenter {

    @NonNull
    private final MainMineWorksContract.View view;

    MainMineWorksPresenter(@NonNull MainMineWorksContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
