package com.mrb.alias.settings;

import com.mrb.alias.results.Game;

/**
 * Settings Presenter implementation
 * Created by Volodymyr Chornyi on 02.04.2016.
 */
public class SettingsPresenterImpl implements SettingsPresenter {

    public static final int DEFAULT_TIME = 10;
    public static final int DEFAULT_POINTS = 10;
    SettingsView settingsView;
    Game game;

    public SettingsPresenterImpl(SettingsView settingsView) {
        this.settingsView = settingsView;
        game = this.settingsView.loadGame();
    }

    /**
     * On Next button click
     */
    @Override
    public void onNextButtonClick() {
        saveGameSettings();
        settingsView.navigateToResults();
    }

    /**
     * On start activity
     */
    @Override
    public void onStart() {
        setDefaultTimeValue();
        setDefaultPointsValue();
    }

    /**
     * Set default value to Time seek bar
     */
    private void setDefaultTimeValue() {
        settingsView.setTimeSeekBarProgress(DEFAULT_TIME);
    }

    /**
     * Set default value to Points seek bar
     */
    private void setDefaultPointsValue() {
        settingsView.setPointsSeekBarProgress(DEFAULT_POINTS);
    }

    /**
     * Get values, and save game settings
     */
    private void saveGameSettings() {
        int time = settingsView.getTimeOnRound();
        int points = settingsView.getPointsOnRound();
        String level = settingsView.getLevelValue();

        game.setTimeOnRound(time);
        game.setMaxPoints(points);
        game.setLevel(level);

        settingsView.saveGame(game);
    }
}
