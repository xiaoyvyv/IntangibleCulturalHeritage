package com.xiaoyv.framework.main.mine.history;

import androidx.annotation.NonNull;

import com.xiaoyv.cultureengine.CultureEngineManager;
import com.xiaoyv.cultureengine.module.main.mine.history.MineHistoryType;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainMineHistoryPresenter implements MainMineHistoryContract.Presenter {

    @NonNull
    private final MainMineHistoryContract.View view;

    MainMineHistoryPresenter(@NonNull MainMineHistoryContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        getHistoryDate(MineHistoryType.ARTICLE);
    }

    @Override
    public void getHistoryDate(MineHistoryType type) {
        CultureEngineManager.getMineHistoryModule().getMineHistoryModule(type, view::showHistory);
    }
}
