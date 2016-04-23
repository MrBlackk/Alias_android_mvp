package com.mrb.alias.start;

import com.mrb.alias.results.Game;

/**
 * Start Presenter implementation
 * Created by Volodymyr Chornyi on 01.04.2016.
 */
public class StartPresenterImpl implements StartPresenter {

    StartView startView;
    Game game;

    public StartPresenterImpl(StartView startView) {
        this.startView = startView;
        game = this.startView.loadGame();
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

    /**
     * On start activity
     */
    @Override
    public void onStart() {
        if(!game.isStarted()){
            startView.hideContinueButton();
        }
    }

    /**
     * On Continue Game button click
     */
    @Override
    public void onContinueButtonClick() {
        startView.navigateToResults();
    }

}
