package com.psedoykin.birthday.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.MainActivity;
import com.psedoykin.birthday.ui.base.BaseActivity;
import com.psedoykin.birthday.ui.fragment.WelcomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthActivity extends BaseActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Bundle mSavedInstanceState;

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        mSavedInstanceState = savedInstanceState;
        mAuth = FirebaseAuth.getInstance();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(this);
        updateActionBar();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    if (mSavedInstanceState == null) {
                        mFragmentManager.beginTransaction().replace(R.id.frame_container, WelcomeFragment.newInstance()).commit();
                    }
                } else {
                    finish();
                    startActivity(new Intent(AuthActivity.this, MainActivity.class));
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
