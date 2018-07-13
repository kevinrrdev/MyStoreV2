package com.example.kechaval.mystorev2.base;

import com.example.kechaval.mystorev2.mvp.view.BaseView;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by KeChaval on 12/07/2018.
 */

public class BasePresenter<V extends BaseView> {

    @Inject protected V mView;

    public V getView() {
        return mView;
    }


    protected <T> void subscribe(Observable<T> observable, Observer<T> observer){
        observable.subscribeOn(Schedulers.newThread())
                .toSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
