package com.xiaoyv.framework.main.home;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.CultureEngineManager;
import com.xiaoyv.cultureengine.module.Type;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainHomePresenter implements MainHomeContract.Presenter {

    @NonNull
    private final MainHomeContract.View view;

    public MainHomePresenter(@NonNull MainHomeContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        getBanner();
        getHomeItemData();
    }

    @Override
    public void getBanner() {
        CultureEngineManager.getBannerModule().getBanner(view::showBanner);
    }

    @Override
    public void getHomeItemData() {
        CultureEngineManager.getHomeItemModule().getHomeItem(Type.DANCE, view::showFeaturedItem);

        CultureEngineManager.getHomeItemModule().getHomeItem(Type.SKILL, view::showArtistryItem);
    }

}
