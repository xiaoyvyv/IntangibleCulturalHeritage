package com.xiaoyv.framework.main.news.page;

import com.xiaoyv.cultureengine.module.Type;
import com.xiaoyv.cultureengine.module.main.news.NewsPageBean;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainNewsPageContract {
    interface View extends BaseView<Presenter> {

        void showItem(NewsPageBean newsPageBean);

        Type getType();
    }

    interface Presenter extends BasePresenter {
        void getItemData();
    }
}
