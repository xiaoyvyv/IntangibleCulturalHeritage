package com.xiaoyv.framework.main.found.page;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.xiaoyv.cultureengine.module.main.found.page.FoundPageBean;
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
public class MainFoundPageFragment extends BaseFragment<MainFoundPageContract.Presenter> implements MainFoundPageContract.View {
    private RecyclerView mainFoundPageRecyclerView;
    private MainFoundPageAdapter mainFoundPageAdapter;

    public static MainFoundPageFragment newInstance() {
        return new MainFoundPageFragment();
    }


    @Override
    public void setPresenter(MainFoundPageContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_found_page;
    }

    @Override
    public void initView() {
        mainFoundPageRecyclerView = findView(R.id.main_found_page_recycler_view);
    }

    @Override
    public void initData() {
        mainFoundPageAdapter = new MainFoundPageAdapter(R.layout.fragment_main_found_page_item, new ArrayList<>());
        mainFoundPageRecyclerView.setAdapter(mainFoundPageAdapter);
    }

    @Override
    public void showItem(FoundPageBean foundPageBean) {
        List<FoundPageBean.FoundPage> foundPages = foundPageBean.getFoundPages();
        if (ObjectUtils.isNotEmpty(foundPages)) {
            mainFoundPageAdapter.setNewData(foundPages);
        }
    }

}
