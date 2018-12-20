package com.orange.resourcesdownloader.pinboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

import com.orange.resourcesdownloader.base.BasePresenter;
import com.orange.resourcesdownloader.models.PinBoardModel;
import com.orange.resourcesdownloader.models.Urls;
import com.orange.resourcesdownloader.network.PinBoardAPI;
import com.orange.resourcesdownloader.network.PinBoardClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Presenter of {@link PinBoardFragment}
 * <p>
 * Created by Safa Amin on 12/20/2018.
 */

class PinBoardPresenter extends BasePresenter<PinBoardView> {

    private PinBoardAPI pinBoardService;

    PinBoardPresenter(PinBoardView view) {
        super(view);

        pinBoardService = PinBoardClient.getRetrofitInstance().create(PinBoardAPI.class);
    }

    void getPinBoardData() {
        getView().showLoadingIndicator();
        Call<List<PinBoardModel>> call = pinBoardService.getPinBoardData();
        call.enqueue(new Callback<List<PinBoardModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PinBoardModel>> call,
                                   @NonNull Response<List<PinBoardModel>> response) {
                getView().hideLoadingIndicator();
                invalidateImagesUrlsInPinBoard(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<PinBoardModel>> call, @NonNull Throwable t) {
                getView().hideLoadingIndicator();
                getView().handleError();
            }
        });
    }

    private void invalidateImagesUrlsInPinBoard(List<PinBoardModel> pinBoardModelList) {
        List<Urls> urlsList = new ArrayList<>();
        for (int i = 0; i < pinBoardModelList.size(); i++) {
            urlsList.add(i, pinBoardModelList.get(i).getUrls());
        }
        getView().invalidateView(urlsList);
    }

    int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (dpWidth / 180);
    }
}
