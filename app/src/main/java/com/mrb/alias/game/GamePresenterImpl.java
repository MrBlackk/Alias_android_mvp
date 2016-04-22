package com.mrb.alias.game;

import com.mrb.alias.results.Game;
import com.mrb.alias.utils.DataBaseHelper;

/**
 * Game Presenter Implementation
 * Created by Volodymyr Chornyi on 15.04.2016.
 */
public class GamePresenterImpl implements GamePresenter {

    public static final String EASY_DROPDOWN = "Початковий";
    public static final String COLUMN_EASY = "easy";
    public static final String COLUMN_MEDIUM = "medium";
    GameView gameView;
    DataBaseHelper dataBaseHelper;
    Game game;
    String currentWord;

    public GamePresenterImpl(GameView gameView, DataBaseHelper dataBaseHelper) {
        this.gameView = gameView;
        this.dataBaseHelper = dataBaseHelper;
        game = this.gameView.loadGame();
    }

    /**
     * Get random word from database
     */
    private void getRandomWord() {
        String column;
        String level = game.getLevel();

        if (level.equals(EASY_DROPDOWN)) {
            column = COLUMN_EASY;
        } else {
            column = COLUMN_MEDIUM;
        }

        currentWord = dataBaseHelper.getRandomWordFromColumn(column);

        gameView.showWord(currentWord);
    }

    /**
     * On Plus button click
     */
    @Override
    public void onPlusButtonClick() {
        addWordToResults(currentWord, true);
        onButtonClick();
    }

    /**
     * On Minus button click
     */
    @Override
    public void onMinusButtonClick() {
        addWordToResults(currentWord, false);
        onButtonClick();
    }

    /**
     * On timer finished
     */
    @Override
    public void onTimeFinished() {
        gameView.saveGame(game);
        gameView.navigateToRoundResults();
    }

    /**
     * Start timer
     */
    private void startTimer() {
        int timeOnRound = game.getTimeOnRound();
        gameView.startTimer(timeOnRound);
    }

    /**
     * Add word to current results array list
     */
    private void addWordToResults(String word, Boolean isGuessed) {
        game.addCurrentResult(word, isGuessed);
    }

    /**
     * On start activity
     */
    @Override
    public void onStart() {
        getRandomWord();
        startTimer();
    }

    /**
     * On general button click
     */
    private void onButtonClick() {
        getRandomWord();
    }
}
