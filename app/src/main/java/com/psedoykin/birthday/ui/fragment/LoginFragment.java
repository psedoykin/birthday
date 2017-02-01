package com.psedoykin.birthday.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    public final static String TAG = LoginFragment.class.getSimpleName();

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    private FirebaseAuth mAuth;

    @BindView(R.id.email_input_layout) TextInputLayout mEmailInputLayout;
    @BindView(R.id.password_input_layout) TextInputLayout mPasswordInputLayout;
    @BindView(R.id.email_edit_text) TextInputEditText mEmailField;
    @BindView(R.id.password_edit_text) TextInputEditText mPasswordField;
    @BindView(R.id.root_view) View mRootView;


    private TextWatcher mEmailTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mEmailInputLayout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher mPasswordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mPasswordInputLayout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this, rootView);
        mEmailField.addTextChangedListener(mEmailTextWatcher);
        mPasswordField.addTextChangedListener(mPasswordTextWatcher);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mEmailField.removeTextChangedListener(mEmailTextWatcher);
        mPasswordField.removeTextChangedListener(mPasswordTextWatcher);
    }

    @OnClick(R.id.login_button)
    public void login() {
        if (!checkCredential()) {
            return;
        }

        mAuth.signInWithEmailAndPassword(mEmailField.getText().toString(), mPasswordField.getText().toString())
                .addOnFailureListener(getActivity(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.w(TAG, "Error creating user", exception);
                        showSnackBar(mRootView, exception.getLocalizedMessage());
                    }
                });
    }

    @OnClick(R.id.forgot_button)
    public void forgot() {
        if (!checkEmail()) {
            return;
        }
        mAuth.sendPasswordResetEmail(mEmailField.getText().toString())
                .addOnFailureListener(getActivity(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error creating user", e);
                        showSnackBar(mRootView, e.getLocalizedMessage());
                    }
                })
                .addOnSuccessListener(getActivity(), new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //TODO: need impl
                    }
                });
    }

    private boolean checkCredential() {
        boolean isCorrect = true;
        isCorrect = checkEmail();
        if (mPasswordField.getText().length() == 0) {
            mPasswordInputLayout.setError(getString(R.string.password_empty_error));
            isCorrect = false;
        }
        return isCorrect;
    }

    private boolean checkEmail() {
        boolean isCorrect = true;
        if (mEmailField.getText().length() == 0) {
            mEmailInputLayout.setError(getString(R.string.email_empty_error));
            isCorrect = false;
        }

        return isCorrect;
    }
}
