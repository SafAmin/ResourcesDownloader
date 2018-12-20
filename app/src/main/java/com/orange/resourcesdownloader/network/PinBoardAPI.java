package com.orange.resourcesdownloader.network;

import com.orange.resourcesdownloader.models.PinBoardModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Safa Amin on 12/20/2018.
 */

public interface PinBoardAPI {

    @GET("raw/wgkJgazE")
    Call<List<PinBoardModel>> getPinBoardData();
}
