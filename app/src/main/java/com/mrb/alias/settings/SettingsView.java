package com.mrb.alias.settings;

import com.mrb.alias.results.Game;

/**
 * Settings View interface
 * Created by Volodymyr Chornyi on 01.04.2016.
 */
public interface SettingsView {

    int getTimeOnRoundProgress();

    int getPointsOnRoundProgress();

    String getLevelValue();

    void navigateToResults();

    void backToMenu();

    Game loadGame();

    void saveGame(Game game);

    void setTimeSeekBarProgress(int progress);

    void setPointsSeekBarProgress(int progress);

    void setTimeSeekMax(int max);

    void setPointsSeekMax(int max);

    void setTimeSeekTextValue(int value);

    void setPointsSeekTextValue(int value);
}
