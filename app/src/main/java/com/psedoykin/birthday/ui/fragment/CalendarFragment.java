package com.psedoykin.birthday.ui.fragment;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.base.BaseFragment;

public class CalendarFragment extends BaseFragment {

    public final static String TAG = CalendarFragment.class.getSimpleName();

    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.calendar_title));
        }
    }

}
