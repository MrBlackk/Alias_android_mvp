package com.mrb.alias.game;

import com.mrb.alias.results.GameSingleton;
import com.mrb.alias.utils.DataBaseHelper;

/**
 * Created by chv on 15.04.2016.
 */
public class GamePresenterImpl implements GamePresenter {

    GameView gameView;
    DataBaseHelper dataBaseHelper;
    GameSingleton game;

    public GamePresenterImpl(GameView gameView, DataBaseHelper dataBaseHelper) {
        this.gameView = gameView;
        this.dataBaseHelper = dataBaseHelper;
        getGame();
    }

    @Override
    public void getRandomWord() {
        String word = dataBaseHelper.getRandomWord();

        gameView.showWord(word);
    }

    @Override
    public void onPlusButtonClick() {

        onButtonClick();
    }

    @Override
    public void onMinusButtonClick() {

        onButtonClick();
    }

    @Override
    public void onTimeFinished() {
        gameView.navigateToRoundResults();
    }

    @Override
    public void startTimer() {
        int timeOnRound = game.getTimeOnRound();
        gameView.startTimer(timeOnRound);
    }

    @Override
    public void getGame() {
        game = gameView.getGame();
    }

    private void onButtonClick() {
        getRandomWord();
    }
}
