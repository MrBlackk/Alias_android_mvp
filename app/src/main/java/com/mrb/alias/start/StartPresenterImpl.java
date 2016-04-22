package com.mrb.alias.start;

/**
 * Start Presenter implementation
 * Created by Volodymyr Chornyi on 01.04.2016.
 */
public class StartPresenterImpl implements StartPresenter {

    StartView startView;

    public StartPresenterImpl(StartView startView) {
        this.startView = startView;
    }

    /**
     * On New Game button click
     */
    @Override
    public void onNewGameButtonClick() {
        startView.clearPreferences();
        startView.navigateToTeam();
    }

    /**
     * On Exit button click
     */
    @Override
    public void onExitButtonClick() {
        startView.exit();
    }

    /**
     * On Rules button click
     */
    @Override
    public void onRulesButtonClick() {
        startView.showRules();
    }

    /**
     * On destroy activity
     */
    @Override
    public void onDestroy() {
        startView = null;
    }

}
