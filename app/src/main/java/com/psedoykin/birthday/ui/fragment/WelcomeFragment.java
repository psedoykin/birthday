package com.psedoykin.birthday.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.Decorator.RecyclerViewItemDecorator;
import com.psedoykin.birthday.ui.adapter.DotsListViewAdapter;
import com.psedoykin.birthday.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WelcomeFragment extends BaseFragment {

    public final static String TAG = WelcomeFragment.class.getSimpleName();

    private DotsListViewAdapter mDotsListViewAdapter;
    private static final int WELCOME_PAGES_COUNT = 3;

    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @BindView(R.id.root_view) View mRootView;
    @BindView(R.id.welcome_view_pager) ViewPager mViewPager;
    @BindView(R.id.indicator_list) RecyclerView mIndicatorList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewPager.setAdapter(new SectionsPagerAdapter(getChildFragmentManager()));

        mDotsListViewAdapter = new DotsListViewAdapter(WELCOME_PAGES_COUNT);
        mIndicatorList.setAdapter(mDotsListViewAdapter);
        mIndicatorList.addItemDecoration(new RecyclerViewItemDecorator(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.dot_margin)));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mIndicatorList.setLayoutManager(layoutManager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    }

    @OnClick({R.id.login_button, R.id.auth_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.auth_button:
                showFragment(RegistrationFragment.newInstance(), RegistrationFragment.TAG);
                break;
            case R.id.login_button:
                showFragment(LoginFragment.newInstance(), LoginFragment.TAG);
                break;
        }

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
    }
}
