package com.psedoykin.birthday.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.activity.AuthActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.logout_button)
    public void logout() {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(MainActivity.this, AuthActivity.class));
    }
}
