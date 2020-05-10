package com.xiaoyv.framework.main.mine.account;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatTextView;

import com.bumptech.glide.Glide;
import com.xiaoyv.account.datebase.User;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;


public class MainMineAccountFragment extends BaseFragment<MainMineAccountContract.Presenter> implements MainMineAccountContract.View {
    private ImageView mainMineAccountHeader;
    private AppCompatTextView mainMineAccountId;
    private AppCompatTextView mainMineAccountName;
    private AppCompatTextView mainMineAccountDesc;
    private AppCompatTextView mainMineAccountSex;
    private AppCompatTextView mainMineAccountAge;
    private AppCompatTextView mainMineAccountPhone;
    private AppCompatTextView mainMineAccountEmail;
    private AppCompatTextView mainMineAccountWork;
    private AppCompatTextView mainMineAccountCard;

    static MainMineAccountFragment newInstance() {
        return new MainMineAccountFragment();
    }

    @Override
    public void setPresenter(MainMineAccountContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine_account;
    }

    @Override
    public void initView() {
        mainMineAccountHeader = findView(R.id.main_mine_account_header);
        mainMineAccountId = findView(R.id.main_mine_account_id);
        mainMineAccountName= findView(R.id.main_mine_account_name);
        mainMineAccountDesc= findView(R.id.main_mine_account_desc);
        mainMineAccountSex = findView(R.id.main_mine_account_sex);
        mainMineAccountAge = findView(R.id.main_mine_account_age);
        mainMineAccountPhone = findView(R.id.main_mine_account_phone);
        mainMineAccountEmail = findView(R.id.main_mine_account_email);
        mainMineAccountWork = findView(R.id.main_mine_account_work);
        mainMineAccountCard = findView(R.id.main_mine_account_card);
    }

    @Override
    public void initData() {


    }

    @Override
    public void showUser(User currentUser) {
        Glide.with(activity).load(currentUser.getHeader()).into(mainMineAccountHeader);
        mainMineAccountId.setText(currentUser.getPhone());
        mainMineAccountName.setText(currentUser.getName());
        mainMineAccountDesc.setText(currentUser.getDesc());
        mainMineAccountSex.setText(currentUser.getSex() == 0 ? "男" : "女");
        mainMineAccountAge.setText(String.valueOf(currentUser.getAge()));
        mainMineAccountPhone.setText(currentUser.getPhone());
        mainMineAccountEmail.setText(currentUser.getEmail());
        mainMineAccountWork.setText(currentUser.getWork());
        mainMineAccountCard.setText(currentUser.getCard());

    }
}