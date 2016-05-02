package com.mrb.alias.settings;

import com.mrb.alias.results.Game;

/**
 * Settings View interface
 * Created by Volodymyr Chornyi on 01.04.2016.
 */
public interface SettingsView {

    int getTimeOnRound();

    int getPointsOnRound();

    String getLevelValue();

    void navigateToResults();

    void backToTeam();

    Game loadGame();

    void saveGame(Game game);

    void setTimeSeekBarProgress(int progress);

    void setPointsSeekBarProgress(int progress);
}
