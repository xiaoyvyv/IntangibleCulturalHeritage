package com.xiaoyv.framework.main.found.hot;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
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
public class MainFoundHotFragment extends BaseFragment<MainFoundHotContract.Presenter> implements MainFoundHotContract.View {
    private RecyclerView mainFoundHotRecyclerView;
    private MainFoundHotAdapter mainFoundHotAdapter;

    public static MainFoundHotFragment newInstance() {
        return new MainFoundHotFragment();
    }


    @Override
    public void setPresenter(MainFoundHotContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_found_hot;
    }

    @Override
    public void initView() {
        mainFoundHotRecyclerView = findView(R.id.main_found_hot_recycler_view);
    }

    @Override
    public void initData() {
        mainFoundHotAdapter = new MainFoundHotAdapter(R.layout.fragment_main_found_hot_item, new ArrayList<>());
        mainFoundHotAdapter.bindToRecyclerView(mainFoundHotRecyclerView);
        mainFoundHotRecyclerView.setAdapter(mainFoundHotAdapter);
    }

    @Override
    public void showItem(FoundHotBean foundHotBean) {
        List<FoundHotBean.FoundHot> foundHots = foundHotBean.getFoundHots();
        if (ObjectUtils.isNotEmpty(foundHots)) {
            mainFoundHotAdapter.setNewData(foundHots);
        }
    }

}
