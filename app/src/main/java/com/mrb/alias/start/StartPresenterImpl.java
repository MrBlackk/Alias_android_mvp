package com.mrb.alias.start;

/**
 * Created by chv on 01.04.2016.
 */
public class StartPresenterImpl implements StartPresenter {

    StartView startView;

    public StartPresenterImpl(StartView startView) {
        this.startView = startView;
    }

    @Override
    public void onNewGameButtonClick() {
        startView.navigateToSettings();
    }

    @Override
    public void onDestroy() {
        startView = null;
    }

}
