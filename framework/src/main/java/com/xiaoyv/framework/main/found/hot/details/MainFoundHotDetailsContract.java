package com.xiaoyv.framework.main.found.hot.details;

import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
import com.xiaoyv.cultureengine.module.main.found.comment.FoundCommentBean;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainFoundHotDetailsContract {
    interface View extends BaseView<Presenter> {

        /**
         * 展示评论数据
         */
        void showCommentItem(FoundCommentBean foundCommentBean);

        /**
         * 展示父窗口传递的数据
         */
        void showParentData(FoundHotBean.FoundHot foundHot);
    }

    interface Presenter extends BasePresenter {
        /**
         * 获取评论数据
         */
        void getCommentItemData();
    }
}
