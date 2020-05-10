package com.xiaoyv.framework.main.found.video.details;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.CultureEngineManager;
import com.xiaoyv.cultureengine.module.main.found.video.FoundVideoBean;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainFoundVideoDetailsPresenter implements MainFoundVideoDetailsContract.Presenter {

    @NonNull
    private final MainFoundVideoDetailsContract.View view;
    @NonNull
    private final FoundVideoBean.FoundVideo foundVideo;

    MainFoundVideoDetailsPresenter(@NonNull MainFoundVideoDetailsContract.View view, @NonNull FoundVideoBean.FoundVideo foundVideo) {
        this.view = view;
        this.foundVideo = foundVideo;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        getCommentItemData();
        view.showParentData(foundVideo);
    }

    @Override
    public void getCommentItemData() {
        CultureEngineManager.getFoundCommentModule().getFoundComment(view::showCommentItem);

    }
}
