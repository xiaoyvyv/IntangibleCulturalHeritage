package com.xiaoyv.framework.main.news.page.details;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.xiaoyv.cultureengine.module.main.news.NewsPageBean;
import com.xiaoyv.framework.BaseFragmentActivity;
import com.xiaoyv.framework.R;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainNewsPageDetailsActivity extends BaseFragmentActivity<MainNewsPageDetailsFragment> {
    NewsPageBean.NewsPage foundHot;

    @Override
    protected void initView() {
        foundHot = (NewsPageBean.NewsPage) getIntent().getSerializableExtra("data");
        super.initView();
    }

    @Override
    protected void createPresenter(MainNewsPageDetailsFragment fragment) {
        new MainNewsPageDetailsPresenter(fragment, foundHot);
    }

    @Override
    protected MainNewsPageDetailsFragment createFragment() {
        return MainNewsPageDetailsFragment.newInstance();
    }

    public void onHotDetailsClick(View view) {
        if (view.getId() == R.id.main_news_page_details_share_qq) {
            ToastUtils.showShort("暂不支持QQ分享");
        } else if (view.getId() == R.id.main_news_page_details_share_zone) {
            ToastUtils.showShort("暂不支持QQ空间分享");
        } else if (view.getId() == R.id.main_news_page_details_share_wechat) {
            ToastUtils.showShort("暂不支持微信分享");
        } else if (view.getId() == R.id.main_news_page_details_share_weibo) {
            ToastUtils.showShort("暂不支持微博分享");
        }
    }
}
