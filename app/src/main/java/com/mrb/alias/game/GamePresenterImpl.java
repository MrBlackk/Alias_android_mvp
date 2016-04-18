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
    String currentWord;

    public GamePresenterImpl(GameView gameView, DataBaseHelper dataBaseHelper) {
        this.gameView = gameView;
        this.dataBaseHelper = dataBaseHelper;
        game = this.gameView.loadGame();
    }

    @Override
    public void getRandomWord() {
        currentWord = dataBaseHelper.getRandomWord();

        gameView.showWord(currentWord);
    }

    @Override
    public void onPlusButtonClick() {
        addWordToResults(currentWord, true);
        onButtonClick();
    }

    @Override
    public void onMinusButtonClick() {
        addWordToResults(currentWord, false);
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

    @Override
    public void addWordToResults(String word, Boolean isGuessed) {
        game.addCurrentResult(word, isGuessed);
    }

    private void onButtonClick() {
        getRandomWord();
    }
}
