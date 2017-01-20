package com.psedoykin.birthday.ui.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.psedoykin.birthday.R;
import com.psedoykin.birthday.databinding.FragmentRegistrationBinding;
import com.psedoykin.birthday.ui.base.BaseFragment;

import java.util.concurrent.Executor;

public class RegistrationFragment extends BaseFragment implements View.OnClickListener{

    public final static String TAG = RegistrationFragment.class.getSimpleName();

    private FirebaseAuth mAuth;
    private FragmentRegistrationBinding mBinding;

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration, container, false);
        mAuth = FirebaseAuth.getInstance();
        mBinding.registrationButton.setOnClickListener(this);
        return mBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.registration_button){
            register();
        }
    }

    private void register(){
        Task authTask = mAuth.createUserWithEmailAndPassword(mBinding.emailEditText.toString(), mBinding.passwordEditText.toString());
                authTask.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        int i =0;
                        i++;
                    }
                });

        authTask.addOnCompleteListener((Executor) this, new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                int i =0;
                i++;
            }
        });


    }
}
