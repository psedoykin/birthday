package com.psedoykin.birthday.ui.base;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.psedoykin.birthday.R;

public abstract class BaseFragment extends Fragment {

    private Snackbar mSnackbar;

    private void hiddenKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        Activity activity = getActivity();
        if (activity != null) {
            View view = activity.getCurrentFocus();
            if (view != null) {
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    protected void showSnackBar(View view, String text) {
        mSnackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        mSnackbar.show();
    }

    protected void removeSnackBar() {
        if (mSnackbar != null) {
            mSnackbar.dismiss();
            mSnackbar = null;
        }
    }

    protected void showFragment(BaseFragment fragment, String TAG) {
        FragmentManager manager = getFragmentManager();
        if (manager != null) {
            getFragmentManager().beginTransaction().setCustomAnimations(R.anim.open_fragment, R.anim.close_fragment, R.anim.open_fragment, R.anim.close_fragment)
                    .replace(R.id.frame_container, fragment).addToBackStack(TAG).commit();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        hiddenKeyboard();
        removeSnackBar();
    }
}
