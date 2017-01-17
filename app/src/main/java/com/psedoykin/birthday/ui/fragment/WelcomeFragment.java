package com.psedoykin.birthday.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.databinding.FragmentWelcomeBinding;
import com.psedoykin.birthday.ui.adapter.DotsListViewAdapter;
import com.psedoykin.birthday.ui.base.BaseFragment;


public class WelcomeFragment extends BaseFragment {

    public final static String TAG = WelcomeFragment.class.getSimpleName();

    private FragmentWelcomeBinding mBinding;
    private DotsListViewAdapter mDotsListViewAdapter;
    private static final int WELCOME_PAGES_COUNT = 3;

    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);
        mBinding.welcomeViewPager.setAdapter(new SectionsPagerAdapter(getChildFragmentManager()));
        mDotsListViewAdapter = new DotsListViewAdapter(WELCOME_PAGES_COUNT);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mBinding.imagesIndicatorList.setAdapter(mDotsListViewAdapter);
        mBinding.imagesIndicatorList.setLayoutManager(layoutManager);
        mBinding.welcomeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mDotsListViewAdapter.updatePosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return mBinding.getRoot();
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return WelcomePageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return WELCOME_PAGES_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "test";
        }
    }

    public void login(){

    }

    public void registration(){

    }
}
