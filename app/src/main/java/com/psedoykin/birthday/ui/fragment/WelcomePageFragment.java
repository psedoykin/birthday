package com.psedoykin.birthday.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomePageFragment extends BaseFragment {

    public final static String TAG = WelcomePageFragment.class.getSimpleName();

    private final static String ARGUMENT_POSITION = "argumentPosition";
    private final static int FIRST_WELCOME_PAGE = 0;
    private final static int SECOND_WELCOME_PAGE = 1;
    private final static int THIRD_WELCOME_PAGE = 2;

    public static WelcomePageFragment newInstance(int position) {
        WelcomePageFragment fragment = new WelcomePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.icon_image) ImageView mIconView;
    @BindView(R.id.title_view_123) TextView mTitleView;
    @BindView(R.id.description_view) TextView mDescriptionView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_welcome_page, container, false);
        ButterKnife.bind(this, rootView);
        mTitleView.setText(getString(R.string.welcome_title_first));
        Bundle args = getArguments();
        if (args != null) {
            int position = args.getInt(ARGUMENT_POSITION);
            switch (position) {
                case FIRST_WELCOME_PAGE:
                    mIconView.setImageResource(R.drawable.ic_event_black_24dp);
                    mTitleView.setText(getString(R.string.welcome_title_first));
                    mDescriptionView.setText(getString(R.string.welcome_description_first));
                    break;
                case SECOND_WELCOME_PAGE:
                    mIconView.setImageResource(R.drawable.ic_hourglass_empty_black_24dp);
                    mTitleView.setText(getString(R.string.welcome_title_second));
                    mDescriptionView.setText(getString(R.string.welcome_description_second));
                    break;
                case THIRD_WELCOME_PAGE:
                    mIconView.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp);
                    mTitleView.setText(getString(R.string.welcome_title_third));
                    mDescriptionView.setText(getString(R.string.welcome_description_second));
                    break;
            }
        }
        return rootView;
    }
}
