package com.xiaoyv.framework.main.found.page.details;

import android.app.AlertDialog;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.found.page.FoundPageBean;
import com.xiaoyv.cultureengine.module.main.found.page.works.FoundPageDetailsBean;
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
public class MainFoundPageDetailsFragment extends BaseFragment<MainFoundPageDetailsContract.Presenter> implements MainFoundPageDetailsContract.View {
    private RecyclerView mainFoundPageDetailsRecyclerView;
    private MainFoundPageDetailsAdapter mainFoundPageDetailsAdapter;
    private Button mainFoundPageDetailsAttention;
    private ImageView mainFoundPageDetailsHeader;
    private AppCompatImageView mainFoundPageDetailsImage;
    private AppCompatTextView mainFoundPageDetailsName;
    private AppCompatTextView mainFoundPageDetailsDesc;


    public static MainFoundPageDetailsFragment newInstance() {
        return new MainFoundPageDetailsFragment();
    }


    @Override
    public void setPresenter(MainFoundPageDetailsContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_found_page_details;
    }

    @Override
    public void initView() {
        mainFoundPageDetailsRecyclerView = findView(R.id.main_found_page_details_recycler_view);
        mainFoundPageDetailsAttention = findView(R.id.main_found_page_details_attention);
        mainFoundPageDetailsHeader = findView(R.id.main_found_page_details_header);
        mainFoundPageDetailsName = findView(R.id.main_found_page_details_name);
        mainFoundPageDetailsDesc = findView(R.id.main_found_page_details_desc);
        mainFoundPageDetailsImage = findView(R.id.main_found_page_details_image);

    }

    @Override
    public void initData() {
        mainFoundPageDetailsAdapter = new MainFoundPageDetailsAdapter(R.layout.fragment_main_found_page_details_item, new ArrayList<>());
        mainFoundPageDetailsAdapter.bindToRecyclerView(mainFoundPageDetailsRecyclerView);
        mainFoundPageDetailsRecyclerView.setAdapter(mainFoundPageDetailsAdapter);
    }


    @Override
    public void showWorksItem(FoundPageDetailsBean foundPageDetailsBean) {
        List<FoundPageDetailsBean.FoundPageDetails> foundPageDetails = foundPageDetailsBean.getFoundPageDetails();
        if (ObjectUtils.isNotEmpty(foundPageDetails)) {
            mainFoundPageDetailsAdapter.setNewData(foundPageDetails);
        }
    }

    @Override
    public void showParentData(FoundPageBean.FoundPage foundPage) {
        Glide.with(activity).load(foundPage.getHeader()).into(mainFoundPageDetailsHeader);
        Glide.with(activity).load(foundPage.getBackground()).into(mainFoundPageDetailsImage);
        mainFoundPageDetailsName.setText(foundPage.getName());
        mainFoundPageDetailsDesc.setText(foundPage.getDesc());
        if (foundPage.isAttention()) {
            mainFoundPageDetailsAttention.setText(getString(R.string.main_found_page_attention_ed));
            mainFoundPageDetailsAttention.setEnabled( false);
        } else {
            mainFoundPageDetailsAttention.setText(getString(R.string.main_found_page_attention));
            mainFoundPageDetailsAttention.setEnabled( true);
        }
        mainFoundPageDetailsAttention.setOnClickListener(v -> {
            AlertDialog alertDialog = new AlertDialog.Builder(activity)
                    .setTitle(R.string.dialog_attention)
                    .setMessage(R.string.dialog_is_attention)
                    .setPositiveButton(R.string.dialog_yes, (dialog, which) -> {
                        mainFoundPageDetailsAttention.setEnabled(false);
                        mainFoundPageDetailsAttention.setText(getString(R.string.main_found_page_attention_ed));
                        ToastUtils.showShort(getString(R.string.tips_attention_success));
                    })
                    .setNegativeButton(R.string.dialog_no, null)
                    .create();
            alertDialog.show();
        });
    }

}
