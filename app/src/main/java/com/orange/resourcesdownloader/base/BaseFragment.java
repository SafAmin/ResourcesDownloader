package com.orange.resourcesdownloader.base;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Parent class for all fragments
 * <p>
 * Created by Safa Amin on 12/20/2018.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    private ProgressDialog loadingIndicator;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

    }

    @Override
    public void showLoadingIndicator() {
        loadingIndicator = new ProgressDialog(getActivity());
        loadingIndicator.show();

    }

    @Override
    public void hideLoadingIndicator() {
        if (loadingIndicator != null) {
            loadingIndicator.dismiss();
        }
    }

    @Override
    public void handleOfflineError() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
