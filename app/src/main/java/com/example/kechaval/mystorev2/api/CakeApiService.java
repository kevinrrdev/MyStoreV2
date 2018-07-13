package com.example.kechaval.mystorev2.api;

import com.example.kechaval.mystorev2.mvp.model.CakesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by KeChaval on 12/07/2018.
 */

public interface CakeApiService {

    @GET("/filippella/a728a34822a3bc7add98e477a4057b69/raw/310d712e87941f569074a63fedb675d2b611342a/cakes")
    Observable<CakesResponse> getCakes();

    @GET("/filippella/a728a34822a3bc7add98e477a4057b69/raw/310d712e87941f569074a63fedb675d2b611342a/cakes")
    Call<CakesResponse> getTheCakes();
}
