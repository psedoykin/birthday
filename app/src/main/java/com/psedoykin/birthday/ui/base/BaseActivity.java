package com.psedoykin.birthday.ui.base;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    protected FragmentManager mFragmentManager;

    @Override
    public void onBackStackChanged() {
        updateActionBar();
    }

    protected void updateActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (mFragmentManager != null && mFragmentManager.getBackStackEntryCount() == 0) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        } else {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
}
