package com.psedoykin.birthday.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.fragment.WelcomeFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, WelcomeFragment.newInstance()).commit();
    }


}
