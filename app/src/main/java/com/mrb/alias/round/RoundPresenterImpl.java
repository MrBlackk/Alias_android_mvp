package com.mrb.alias.round;

import com.mrb.alias.results.Game;

/**
 * Created by chvs on 18.04.2016.
 */
public class RoundPresenterImpl implements RoundPresenter {

    RoundView roundView;
    Game game;

    public RoundPresenterImpl(RoundView roundView) {
        this.roundView = roundView;
        game = this.roundView.loadGame();
    }

    @Override
    public void getListOfWords() {
        roundView.showListOfWords(game.getCurrentResults());
    }

    @Override
    public void onNextButtonClick() {
        roundView.navigateToResults();
    }
}
