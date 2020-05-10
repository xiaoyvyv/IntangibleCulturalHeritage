package com.xiaoyv.framework.main;

import androidx.annotation.NonNull;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainPresenter implements MainContract.Presenter {

    @NonNull
    private final MainContract.View view;

    MainPresenter( @NonNull MainContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
