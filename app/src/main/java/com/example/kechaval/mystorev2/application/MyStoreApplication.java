package com.example.kechaval.mystorev2.application;

import android.app.Application;

import com.example.kechaval.mystorev2.di.components.ApplicationComponent;
import com.example.kechaval.mystorev2.di.components.DaggerApplicationComponent;
import com.example.kechaval.mystorev2.di.module.ApplicationModule;

/**
 * Created by KeChaval on 12/07/2018.
 */

public class MyStoreApplication extends Application {

    private ApplicationComponent mApplicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
