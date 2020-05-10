package com.xiaoyv.framework.main.home;

import com.xiaoyv.cultureengine.module.main.home.BannerBean;
import com.xiaoyv.cultureengine.module.main.home.HomeItemBean;
import com.xiaoyv.framework.BasePresenter;
import com.xiaoyv.framework.BaseView;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public interface MainHomeContract {
    interface View extends BaseView<Presenter> {
        void showBanner(BannerBean cultureData);

        void showFeaturedItem(HomeItemBean homeItemBean);

        void showArtistryItem(HomeItemBean homeItemBean);
    }

    interface Presenter extends BasePresenter {
        /**
         * 获取Banner数据
         */
        void getBanner();

        /**
         * 获取Item数据
         */
        void getHomeItemData();
    }
}
