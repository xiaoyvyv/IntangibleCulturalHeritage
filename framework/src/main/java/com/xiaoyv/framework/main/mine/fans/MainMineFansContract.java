package com.xiaoyv.framework.main.mine.fans;

import com.xiaoyv.cultureengine.module.main.mine.attention.MineAttentionBean;
import com.xiaoyv.cultureengine.module.main.mine.fans.MineFansBean;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainMineFansContract {
    interface View extends BaseView<Presenter> {

        /**
         * 显示我的粉丝数据
         */
        void showFans(MineFansBean bean);
    }

    interface Presenter extends BasePresenter {

        /**
         * 获取我的粉丝数据
         */
        void getFansData();
    }
}
