package com.mrb.alias.settings;

import com.mrb.alias.results.Game;

/**
 * Settings Presenter implementation
 * Created by Volodymyr Chornyi on 02.04.2016.
 */
public class SettingsPresenterImpl implements SettingsPresenter {

    public static final int STEP_SEEK = 5;
    public static final int MIN_SEEK = 10;
    public static final int MAX_SEEK = 200;
    public static final int DEFAULT_TIME = 40;
    public static final int DEFAULT_POINTS = 40;
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
        setMaxTimeValue();
        setMaxPointsValue();
        setDefaultTimeValue();
        setDefaultPointsValue();
    }

    /**
     * On back button pressed
     */
    @Override
    public void onBackButtonPressed() {
        settingsView.backToMenu();
    }

    @Override
    public void onTimeSeekbarChanged(int progress) {
        settingsView.setTimeSeekTextValue(progressToValue(progress));
    }

    @Override
    public void onPointsSeekbarChanged(int progress) {
        settingsView.setPointsSeekTextValue(progressToValue(progress));
    }

    /**
     * Set default value to Time seek bar
     */
    private void setDefaultTimeValue() {
        settingsView.setTimeSeekBarProgress(valueToProgress(DEFAULT_TIME));
    }

    /**
     * Set default value to Points seek bar
     */
    private void setDefaultPointsValue() {
        settingsView.setPointsSeekBarProgress(valueToProgress(DEFAULT_POINTS));
    }

    /**
     * Get values, and save game settings
     */
    private void saveGameSettings() {
        int time = progressToValue(settingsView.getTimeOnRoundProgress());
        int points = progressToValue(settingsView.getPointsOnRoundProgress());
        String level = settingsView.getLevelValue();

        game.setTimeOnRound(time);
        game.setMaxPoints(points);
        game.setLevel(level);

        settingsView.saveGame(game);
    }

    /**
     * Set Max value to Time seekbar
     */
    private void setMaxTimeValue() {
        settingsView.setTimeSeekMax(valueToProgress(MAX_SEEK));
    }

    /**
     * Set Max value to Time seekbar
     */
    private void setMaxPointsValue() {
        settingsView.setPointsSeekMax(valueToProgress(MAX_SEEK));
    }

    /**
     * Convert seekbar progress to value
     */
    private int progressToValue(int progress) {
        return (progress * STEP_SEEK) + MIN_SEEK;
    }

    /**
     * Convert seekbar value to progress
     */
    private int valueToProgress(int value) {
        return (value - MIN_SEEK) / STEP_SEEK;
    }
}
