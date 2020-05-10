package com.xiaoyv.framework.main.mine.history;

import com.xiaoyv.cultureengine.module.main.mine.history.MineHistoryBean;
import com.xiaoyv.cultureengine.module.main.mine.history.MineHistoryType;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainMineHistoryContract {
    interface View extends BaseView<Presenter> {

        /**
         * 显示历史记录
         */
        void showHistory(MineHistoryBean mineHistoryBean);
    }

    interface Presenter extends BasePresenter {

        /**
         * 获取历史记录
         */
        void  getHistoryDate(MineHistoryType type);
    }
}
