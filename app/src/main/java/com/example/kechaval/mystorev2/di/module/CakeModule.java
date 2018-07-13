package com.example.kechaval.mystorev2.di.module;

import com.example.kechaval.mystorev2.api.CakeApiService;
import com.example.kechaval.mystorev2.di.scope.PerActivity;
import com.example.kechaval.mystorev2.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by KeChaval on 12/07/2018.
 */
@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView view){
        mView=view;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit){
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView(){
        return mView;
    }

}
