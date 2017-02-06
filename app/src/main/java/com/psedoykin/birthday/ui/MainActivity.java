package com.psedoykin.birthday.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.activity.AuthActivity;
import com.psedoykin.birthday.ui.base.BaseActivity;
import com.psedoykin.birthday.ui.fragment.CalendarFragment;
import com.psedoykin.birthday.ui.fragment.CardsFragment;
import com.psedoykin.birthday.ui.fragment.HelpFragment;
import com.psedoykin.birthday.ui.fragment.MainFragment;
import com.psedoykin.birthday.ui.fragment.SettingsFragment;
import com.psedoykin.birthday.ui.fragment.TypesEventFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.fab) FloatingActionButton mFab;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            showFragment(MainFragment.newInstance(), MainFragment.TAG);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @OnClick(R.id.fab)
    public void logout() {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(MainActivity.this, AuthActivity.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_main:
                showFragment(MainFragment.newInstance(), MainFragment.TAG);
                break;
            case R.id.nav_calendar:
                showFragment(CalendarFragment.newInstance(), CalendarFragment.TAG);
                break;
            case R.id.nav_type_event:
                showFragment(TypesEventFragment.newInstance(), TypesEventFragment.TAG);
                break;
            case R.id.nav_card:
                showFragment(CardsFragment.newInstance(), CardsFragment.TAG);
                break;
            case R.id.nav_settings:
                showFragment(SettingsFragment.newInstance(), SettingsFragment.TAG);
                break;
            case R.id.nav_help:
                showFragment(HelpFragment.newInstance(), HelpFragment.TAG);
                break;
        }

        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
