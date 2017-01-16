package com.psedoykin.birthday.ui.fragment.auth;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.base.BaseFragment;


public class WelcomeFragment extends BaseFragment {

    public final static String TAG = WelcomeFragment.class.getSimpleName();

    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        WelcomeFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);

        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

}
