package com.example.kechaval.mystorev2.di.components;

import android.content.Context;

import com.example.kechaval.mystorev2.di.module.CakeModule;
import com.example.kechaval.mystorev2.di.scope.PerActivity;
import com.example.kechaval.mystorev2.modules.cake.home.MainActivity;

import javax.inject.Inject;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by KeChaval on 12/07/2018.
 */
@PerActivity
@Component(modules = {CakeModule.class}, dependencies = {ApplicationComponent.class})
public interface CakeComponent {

    void inject(MainActivity activity);

}
