package com.orange.resourcesdownloader.base;

/**
 * Created by Safa Amin on 12/20/2018.
 */

public interface BaseView {

    void showLoadingIndicator();

    void hideLoadingIndicator();

    void handleOfflineError();

    BasePresenter getPresenter();
}
