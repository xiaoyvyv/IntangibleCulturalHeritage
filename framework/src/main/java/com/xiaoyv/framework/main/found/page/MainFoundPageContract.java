package com.xiaoyv.framework.main.found.page;

import com.xiaoyv.cultureengine.module.main.found.page.FoundPageBean;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainFoundPageContract {
    interface View extends BaseView<Presenter> {

        void showItem(FoundPageBean foundPageBean);

    }

    interface Presenter extends BasePresenter {
        void getItemData();
    }
}
