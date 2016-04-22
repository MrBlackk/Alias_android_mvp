package com.mrb.alias.game;

import com.mrb.alias.results.Game;

/**
 * Game view interface
 * Created by Volodymyr Chornyi on 15.04.2016.
 */
public interface GameView {

    void showWord(String word);

    void startTimer(int time);

    void navigateToRoundResults();

    Game loadGame();

    void saveGame(Game game);
}
