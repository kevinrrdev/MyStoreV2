package com.example.kechaval.mystorev2.di.components;

import android.content.Context;

import com.example.kechaval.mystorev2.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by KeChaval on 12/07/2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();

}
