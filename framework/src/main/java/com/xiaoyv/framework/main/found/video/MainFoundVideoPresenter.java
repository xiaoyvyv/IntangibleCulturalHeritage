package com.xiaoyv.framework.main.found.video;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.CultureEngineManager;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainFoundVideoPresenter implements MainFoundVideoContract.Presenter {

    @NonNull
    private final MainFoundVideoContract.View view;

    public MainFoundVideoPresenter(@NonNull MainFoundVideoContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        getItemData();
    }

    @Override
    public void getItemData() {
        CultureEngineManager.getFoundVideoModule().getFoundVideo(view::showItem);
    }
}
