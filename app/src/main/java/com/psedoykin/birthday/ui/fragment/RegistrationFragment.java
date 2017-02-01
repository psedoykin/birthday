package com.psedoykin.birthday.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.psedoykin.birthday.R;
import com.psedoykin.birthday.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationFragment extends BaseFragment {

    public final static String TAG = RegistrationFragment.class.getSimpleName();

    private FirebaseAuth mAuth;

    @BindView(R.id.name_input_layout) TextInputLayout mNameInputLayout;
    @BindView(R.id.email_input_layout) TextInputLayout mEmailInputLayout;
    @BindView(R.id.password_input_layout) TextInputLayout mPasswordInputLayout;
    @BindView(R.id.name_edit_text) TextView mNameField;
    @BindView(R.id.email_edit_text) TextView mEmailField;
    @BindView(R.id.password_edit_text) TextView mPasswordField;
    @BindView(R.id.root_view) View mRootView;

    private TextWatcher mNameTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mNameInputLayout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

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

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_registration, container, false);
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this, rootView);
        mNameField.addTextChangedListener(mNameTextWatcher);
        mEmailField.addTextChangedListener(mEmailTextWatcher);
        mPasswordField.addTextChangedListener(mPasswordTextWatcher);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mNameField.removeTextChangedListener(mNameTextWatcher);
        mEmailField.removeTextChangedListener(mEmailTextWatcher);
        mPasswordField.removeTextChangedListener(mPasswordTextWatcher);
    }

    @OnClick(R.id.registration_button)
    public void register() {
        if (!checkCredential()) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(mEmailField.getText().toString(), mPasswordField.getText().toString())
                .addOnFailureListener(getActivity(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error creating user", e);
                        showSnackBar(mRootView, e.getLocalizedMessage());
                    }
                });
    }

    private boolean checkCredential() {
        boolean isCorrect = true;
        if (mNameField.getText().length() == 0) {
            mNameInputLayout.setError(getString(R.string.name_empty_error));
            isCorrect = false;
        }

        if (mEmailField.getText().length() == 0) {
            mEmailInputLayout.setError(getString(R.string.email_empty_error));
            isCorrect = false;
        }

        if (mPasswordField.getText().length() == 0) {
            mPasswordInputLayout.setError(getString(R.string.password_empty_error));
            isCorrect = false;
        }

        return isCorrect;
    }
}
