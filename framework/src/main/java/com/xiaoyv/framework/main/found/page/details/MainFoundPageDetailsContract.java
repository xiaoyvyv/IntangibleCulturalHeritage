package com.xiaoyv.framework.main.found.page.details;

import com.xiaoyv.cultureengine.module.main.found.comment.FoundCommentBean;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
import com.xiaoyv.cultureengine.module.main.found.page.FoundPageBean;
import com.xiaoyv.cultureengine.module.main.found.page.works.FoundPageDetailsBean;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainFoundPageDetailsContract {
    interface View extends BaseView<Presenter> {

        /**
         * 展示评论数据
         */
        void showWorksItem(FoundPageDetailsBean foundPageDetailsBean);

        /**
         * 展示父窗口传递的数据
         */
        void showParentData(FoundPageBean.FoundPage  foundPage);
    }

    interface Presenter extends BasePresenter {
        /**
         * 获取评论数据
         */
        void getWorksItemData();
    }
}
