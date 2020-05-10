package com.xiaoyv.framework.main.found.page.details;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.CultureEngineManager;
import com.xiaoyv.cultureengine.callback.CultureDataCallback;
import com.xiaoyv.cultureengine.module.main.found.page.FoundPageBean;
import com.xiaoyv.cultureengine.module.main.found.page.works.FoundPageDetailsBean;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainFoundPageDetailsPresenter implements MainFoundPageDetailsContract.Presenter {

    @NonNull
    private final MainFoundPageDetailsContract.View view;
    private final FoundPageBean.FoundPage foundPage;

    public MainFoundPageDetailsPresenter(@NonNull MainFoundPageDetailsContract.View view, FoundPageBean.FoundPage foundPage) {
        this.view = view;
        this.foundPage = foundPage;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        getWorksItemData();
        view.showParentData(foundPage);
    }


    @Override
    public void getWorksItemData() {
        CultureEngineManager.getFoundPageDetailsModule().getPageDetailsModule(view::showWorksItem);
    }
}
