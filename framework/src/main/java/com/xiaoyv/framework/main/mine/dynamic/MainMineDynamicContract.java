package com.xiaoyv.framework.main.mine.dynamic;

import com.xiaoyv.cultureengine.module.main.mine.dynamic.MineDynamicBean;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainMineDynamicContract {
    interface View extends BaseView<Presenter> {

        /**
         * 展示我的动态
         */
        void showDynamic(MineDynamicBean mineDynamicBean);
    }

    interface Presenter extends BasePresenter {

        /**
         * 获取我的动态数据
         */
        void getDynamicData();
    }
}
