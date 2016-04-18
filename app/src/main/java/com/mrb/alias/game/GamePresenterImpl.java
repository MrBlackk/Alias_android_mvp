package com.mrb.alias.game;

import com.mrb.alias.results.Game;
import com.mrb.alias.utils.DataBaseHelper;

/**
 * Created by chv on 15.04.2016.
 */
public class GamePresenterImpl implements GamePresenter {

    GameView gameView;
    DataBaseHelper dataBaseHelper;
    Game game;

    public GamePresenterImpl(GameView gameView, DataBaseHelper dataBaseHelper) {
        this.gameView = gameView;
        this.dataBaseHelper = dataBaseHelper;
        game = this.gameView.loadGame();
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
        gameView.saveGame(game);
        gameView.navigateToRoundResults();
    }

    @Override
    public void startTimer() {
        int timeOnRound = game.getTimeOnRound();
        gameView.startTimer(timeOnRound);
    }

    private void onButtonClick() {
        getRandomWord();
    }
}
