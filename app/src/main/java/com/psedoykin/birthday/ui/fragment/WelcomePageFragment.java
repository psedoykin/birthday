package com.psedoykin.birthday.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.base.BaseFragment;

public class WelcomePageFragment extends BaseFragment {

    public final static String TAG = WelcomePageFragment.class.getSimpleName();

    public static WelcomePageFragment newInstance(int position) {
        return new WelcomePageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_page, container, false);
    }

}
