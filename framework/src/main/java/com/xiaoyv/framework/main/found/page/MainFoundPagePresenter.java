package com.xiaoyv.framework.main.found.page;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.CultureEngineManager;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainFoundPagePresenter implements MainFoundPageContract.Presenter {

    @NonNull
    private final MainFoundPageContract.View view;

    public MainFoundPagePresenter(@NonNull MainFoundPageContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        getItemData();
    }

    @Override
    public void getItemData() {
        CultureEngineManager.getFoundPageModule().getFoundPage(view::showItem);
    }
}
