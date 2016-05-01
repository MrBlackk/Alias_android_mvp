package com.mrb.alias.game;

import com.mrb.alias.results.Game;
import com.mrb.alias.utils.DataBaseHelper;

import java.util.HashSet;

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
    boolean isTimerFinished;
    int numberOfWordsInDB;
    String currentColumnName;

    public GamePresenterImpl(GameView gameView, DataBaseHelper dataBaseHelper) {
        this.gameView = gameView;
        this.dataBaseHelper = dataBaseHelper;
        game = this.gameView.loadGame();
        currentColumnName = getColumnName();
        numberOfWordsInDB = dataBaseHelper.getCountByColumnAndTable(currentColumnName);
    }

    /**
     * Get column name
     */
    private String getColumnName() {
        String column;
        String level = game.getLevel();
        if (level.equals(EASY_DROPDOWN)) {
            column = COLUMN_EASY;
        } else {
            column = COLUMN_MEDIUM;
        }
        return column;
    }

    /**
     * Get random id + 1
     */
    private int getRandomId(int max) {
        return (int) (Math.random() * max) + 1;
    }

    /**
     * Get random and unique id
     */
    private int getRandomAndUniqueId(int max, HashSet<Integer> usedIds) {
        int id = getRandomId(max);

        //another variant: get list of available ids, e.g. 1-1000 and shuffle it and get one by one id
        while (usedIds.contains(id)) {
            id = getRandomId(max);
            if (usedIds.size() == numberOfWordsInDB - 5) {
                game.setUsedIds(new HashSet<Integer>());
            }
        }
        game.addUsedIds(id);
        return id;
    }


    /**
     * Get random word from database
     */
    private void getRandomWord() {
        int id = getRandomAndUniqueId(numberOfWordsInDB, game.getUsedIds());
        currentWord = dataBaseHelper.getRandomWordFromColumn(currentColumnName, id);

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
        isTimerFinished = true;
        gameView.setTextRed();
        gameView.hideTimer();
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
        if (isTimerFinished) {
            gameView.saveGame(game);
            gameView.navigateToRoundResults();
        } else {
            getRandomWord();
        }
    }
}
