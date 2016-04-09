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
        startView.navigateToTeam();
    }

    @Override
    public void onExitButtonClick() {
        startView.exit();
    }

    @Override
    public void onRulesButtonClick() {
        startView.showRules();
    }

    @Override
    public void onDestroy() {
        startView = null;
    }

}
