package com.mrb.alias.settings;

/**
 * Created by chv on 01.04.2016.
 */
public interface SettingsView {

    int getTimeOnRound();
    int getPointsOnRound();
    String getLevelValue();
    void navigateToResults();
    void saveGameSettings(int time, int point, String level);
}
