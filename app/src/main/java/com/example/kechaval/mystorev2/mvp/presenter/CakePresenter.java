package com.example.kechaval.mystorev2.mvp.presenter;

import com.example.kechaval.mystorev2.api.CakeApiService;
import com.example.kechaval.mystorev2.base.BasePresenter;
import com.example.kechaval.mystorev2.mapper.CakeMapper;
import com.example.kechaval.mystorev2.mvp.model.Cake;
import com.example.kechaval.mystorev2.mvp.model.CakesResponse;
import com.example.kechaval.mystorev2.mvp.model.Storage;
import com.example.kechaval.mystorev2.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by KeChaval on 12/07/2018.
 */

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    @Inject protected CakeApiService mApiService;
    @Inject protected CakeMapper mCakeMapper;
    @Inject protected Storage mStorage;

    @Inject
    public CakePresenter(){

    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes...");
        Observable<CakesResponse> cakesResponseObservable= mApiService.getCakes();
        subscribe(cakesResponseObservable,this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading complete!");
    }

    @Override
    public void onError(Throwable e) {
    getView().onHideDialog();
    getView().onShowToast("Error loading cakes "+e.getMessage());
    }

    @Override
    public void onNext(CakesResponse cakesResponse) {

       List<Cake> cakes = mCakeMapper.mapCakes(mStorage,cakesResponse);
       getView().onClearItems();
       getView().onCakeLoaded(cakes);
    }

    public void getCakesFromDatabase() {
        List<Cake> cakes = mStorage.getSavedCakes();
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }
}
