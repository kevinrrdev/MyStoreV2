package com.example.kechaval.mystorev2.mvp.view;

import com.example.kechaval.mystorev2.mvp.model.Cake;

import java.util.List;

/**
 * Created by KeChaval on 12/07/2018.
 */

public interface MainView extends BaseView {

    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);

    void onClearItems();
}
