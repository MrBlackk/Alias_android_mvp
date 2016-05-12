package com.mrb.alias.round;

import com.mrb.alias.results.Game;

import java.util.LinkedHashMap;

/**
 * Round View interface
 * Created by Volodymyr Chornyi on 18.04.2016.
 */
public interface RoundView {

    void showListOfWords(LinkedHashMap<String, Boolean> words);

    void saveGame(Game game);

    Game loadGame();

    void navigateToResults();

    void backToMenu();

    void navigateToWin();
}
