package com.xiaoyv.framework.main.mine;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatTextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.IntentUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.account.UserManager;
import com.xiaoyv.account.datebase.User;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;
import com.xiaoyv.framework.main.mine.account.MainMineAccountActivity;
import com.xiaoyv.framework.main.mine.attention.MainMineAttentionActivity;
import com.xiaoyv.framework.main.mine.collection.MainMineCollectionActivity;
import com.xiaoyv.framework.main.mine.dynamic.MainMineDynamicActivity;
import com.xiaoyv.framework.main.mine.fans.MainMineFansActivity;
import com.xiaoyv.framework.main.mine.history.MainMineHistoryActivity;
import com.xiaoyv.framework.main.mine.make.MainMineMakeActivity;
import com.xiaoyv.framework.main.mine.message.MainMineMessageActivity;
import com.xiaoyv.framework.main.mine.money.MainMineMoneyActivity;
import com.xiaoyv.framework.main.mine.works.MainMineWorksActivity;
import com.xiaoyv.framework.setting.SettingActivity;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainMineFragment extends BaseFragment<MainMineContract.Presenter> implements MainMineContract.View, View.OnClickListener {

    private ImageView mainMineAccount;
    private View mainMineSetting;
    private View mainMineShare;
    private View mainMineContact;
    private View mainMineMessage;
    private View mainMineDynamic;
    private View mainMineFans;
    private View mainMineAttention;
    private View mainMineCollection;
    private View mainMineWorks;
    private View mainMineMake;
    private View mainMineMoney;
    private View mainMineHistory;
    private AppCompatTextView mainMineAccountName;
    private AppCompatTextView mainMineAccountDesc;

    public static MainMineFragment newInstance() {
        return new MainMineFragment();
    }

    @Override
    public void setPresenter(MainMineContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_mine;
    }

    @Override
    public void initView() {
        mainMineSetting = findView(R.id.main_mine_setting);

        mainMineAccount = findView(R.id.main_mine_account);
        mainMineAccountName = findView(R.id.main_mine_account_name);
        mainMineAccountDesc = findView(R.id.main_mine_account_desc);
        mainMineDynamic = findView(R.id.main_mine_dynamic);
        mainMineFans = findView(R.id.main_mine_fans);
        mainMineAttention = findView(R.id.main_mine_attention);
        mainMineMessage = findView(R.id.main_mine_message);
        mainMineCollection = findView(R.id.main_mine_collection);
        mainMineWorks = findView(R.id.main_mine_works);
        mainMineMake = findView(R.id.main_mine_make);
        mainMineMoney = findView(R.id.main_mine_money);
        mainMineHistory = findView(R.id.main_mine_history);

        mainMineContact = findView(R.id.main_mine_contact);
        mainMineShare = findView(R.id.main_mine_share);

    }

    @Override
    public void initData() {
        User currentUser = UserManager.getCurrentUser();
        Glide.with(activity).load(currentUser.getHeader()).into(mainMineAccount);
        mainMineAccountName.setText(currentUser.getName());
        mainMineAccountDesc.setText(currentUser.getDesc());
        
        mainMineSetting.setOnClickListener(this);
        mainMineAccount.setOnClickListener(this);
        mainMineShare.setOnClickListener(this);
        mainMineContact.setOnClickListener(this);
        mainMineMessage.setOnClickListener(this);
        mainMineDynamic.setOnClickListener(this);
        mainMineFans.setOnClickListener(this);
        mainMineAttention.setOnClickListener(this);
        mainMineCollection.setOnClickListener(this);
        mainMineWorks.setOnClickListener(this);
        mainMineMake.setOnClickListener(this);
        mainMineMoney.setOnClickListener(this);
        mainMineHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mainMineSetting.getId()) {
            ActivityUtils.startActivity(SettingActivity.class);
        } else if (v.getId() == mainMineAccount.getId()) {
            ActivityUtils.startActivity(MainMineAccountActivity.class);
        } else if (v.getId() == mainMineDynamic.getId()) {
            ActivityUtils.startActivity(MainMineDynamicActivity.class);
        } else if (v.getId() == mainMineFans.getId()) {
            ActivityUtils.startActivity(MainMineFansActivity.class);
        } else if (v.getId() == mainMineAttention.getId()) {
            ActivityUtils.startActivity(MainMineAttentionActivity.class);
        } else if (v.getId() == mainMineMessage.getId()) {
            ActivityUtils.startActivity(MainMineMessageActivity.class);
        } else if (v.getId() == mainMineCollection.getId()) {
            ActivityUtils.startActivity(MainMineCollectionActivity.class);
        } else if (v.getId() == mainMineWorks.getId()) {
            ActivityUtils.startActivity(MainMineWorksActivity.class);
        } else if (v.getId() == mainMineMake.getId()) {
            ActivityUtils.startActivity(MainMineMakeActivity.class);
        } else if (v.getId() == mainMineMoney.getId()) {
            ActivityUtils.startActivity(MainMineMoneyActivity.class);
        } else if (v.getId() == mainMineHistory.getId()) {
            ActivityUtils.startActivity(MainMineHistoryActivity.class);
        } else if (v.getId() == mainMineShare.getId()) {
            Intent intent = IntentUtils.getShareTextIntent(getString(R.string.main_mine_share_app), true);
            ActivityUtils.startActivity(intent);
        } else if (v.getId() == mainMineContact.getId()) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("https://qm.qq.com/cgi-bin/qm/qr?k=KIp2SFt0ooWGn9UAqwBYx5b44SvQmsQg&noverify=0"));
            ActivityUtils.startActivity(intent);
        }

    }
}
