package com.psedoykin.birthday.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.fragment.WelcomeFragment;

public class AuthActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(this);
        mFragmentManager.beginTransaction().replace(R.id.frame_container, WelcomeFragment.newInstance()).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackStackChanged() {
        updateActionBar();
    }

    private void updateActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (mFragmentManager.getBackStackEntryCount() == 0) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        } else {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
