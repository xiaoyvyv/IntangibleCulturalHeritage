package com.xiaoyv.framework.main.found.hot.details;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
import com.xiaoyv.framework.BaseFragmentActivity;
import com.xiaoyv.framework.R;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainFoundHotDetailsActivity extends BaseFragmentActivity<MainFoundHotDetailsFragment> {
    FoundHotBean.FoundHot foundHot;

    @Override
    protected void initView() {
        foundHot = (FoundHotBean.FoundHot) getIntent().getSerializableExtra("data");
        super.initView();
    }

    @Override
    protected void createPresenter(MainFoundHotDetailsFragment fragment) {
        new MainFoundHotDetailsPresenter(fragment, foundHot);
    }

    @Override
    protected MainFoundHotDetailsFragment createFragment() {
        return MainFoundHotDetailsFragment.newInstance();
    }

    public void onHotDetailsClick(View view) {
        if (view.getId() == R.id.main_found_hot_details_share_qq) {
            ToastUtils.showShort("暂不支持QQ分享");
        } else if (view.getId() == R.id.main_found_hot_details_share_zone) {
            ToastUtils.showShort("暂不支持QQ空间分享");
        } else if (view.getId() == R.id.main_found_hot_details_share_wechat) {
            ToastUtils.showShort("暂不支持微信分享");
        } else if (view.getId() == R.id.main_found_hot_details_share_weibo) {
            ToastUtils.showShort("暂不支持微博分享");
        }
    }
}
