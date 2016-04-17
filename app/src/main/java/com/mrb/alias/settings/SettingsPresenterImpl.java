package com.mrb.alias.settings;

/**
 * Created by chvs on 02.04.2016.
 */
public class SettingsPresenterImpl implements SettingsPresenter {

    SettingsView settingsView;

    public SettingsPresenterImpl(SettingsView settingsView) {
        this.settingsView = settingsView;
    }

    @Override
    public void onNextButtonClick() {
        saveGameSettings();
        settingsView.navigateToResults();
    }

    @Override
    public void saveGameSettings() {
        int time = settingsView.getTimeOnRound();
        int points = settingsView.getPointsOnRound();
        String level = settingsView.getLevelValue();

        settingsView.saveGameSettings(time, points, level);
    }
}
