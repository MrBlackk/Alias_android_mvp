package com.mrb.alias.settings;

import com.mrb.alias.results.Game;

/**
 * Created by chv on 01.04.2016.
 */
public interface SettingsView {

    int getTimeOnRound();
    int getPointsOnRound();
    String getLevelValue();
    void navigateToResults();
    Game loadGame();
    void saveGame(Game game);
}
