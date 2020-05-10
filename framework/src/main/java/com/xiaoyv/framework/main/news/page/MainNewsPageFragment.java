package com.xiaoyv.framework.main.news.page;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xiaoyv.cultureengine.module.Type;
import com.xiaoyv.cultureengine.module.main.news.NewsPageBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainNewsPageFragment extends BaseFragment<MainNewsPageContract.Presenter> implements MainNewsPageContract.View {
    private RecyclerView mainNewsPageRecyclerView;
    private MainNewsPageAdapter mainNewsPageAdapter;
    private Type type;

    public static MainNewsPageFragment newInstance(Type type) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("type", type);
        MainNewsPageFragment mainNewsPageFragment = new MainNewsPageFragment();
        mainNewsPageFragment.setArguments(bundle);
        return mainNewsPageFragment;
    }


    @Override
    public void setPresenter(MainNewsPageContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = (Type) bundle.getSerializable("type");
        }
        return R.layout.fragment_main_news_page;
    }

    @Override
    public void initView() {
        mainNewsPageRecyclerView = findView(R.id.main_news_page_recycler_view);
    }

    @Override
    public void initData() {
        mainNewsPageAdapter = new MainNewsPageAdapter(R.layout.fragment_main_news_page_item, new ArrayList<>());
        mainNewsPageRecyclerView.setAdapter(mainNewsPageAdapter);
        ToastUtils.showShort(type.name());
    }

    @Override
    public void showItem(NewsPageBean newsPageBean) {
        List<NewsPageBean.NewsPage> newsPages = newsPageBean.getNewsPages();
        if (ObjectUtils.isNotEmpty(newsPages)) {
            mainNewsPageAdapter.setNewData(newsPages);
        }
    }

    @Override
    public Type getType() {
        return type;
    }
}
