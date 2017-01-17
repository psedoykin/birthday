package com.psedoykin.birthday.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.base.BaseFragment;

public class RegistrationFragment extends BaseFragment {

    public final static String TAG = RegistrationFragment.class.getSimpleName();

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

}
