package com.xiaoyv.framework;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2016 on 2017/12/24.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mFragments_name;

    public BaseFragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragments_name = new ArrayList<>();
    }

    public void addFragment(String title, Fragment fragment) {
        mFragments_name.add(title);
        mFragments.add(fragment);
    }

    public void clear() {
        mFragments.clear();
        mFragments_name.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int arg0) {
        return mFragments.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return mFragments.hashCode();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments_name.get(position);
    }
}