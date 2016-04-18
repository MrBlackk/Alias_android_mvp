package com.mrb.alias.settings;

import com.mrb.alias.results.Game;

/**
 * Created by chvs on 02.04.2016.
 */
public class SettingsPresenterImpl implements SettingsPresenter {

    SettingsView settingsView;
    Game game;

    public SettingsPresenterImpl(SettingsView settingsView) {
        this.settingsView = settingsView;
        game = this.settingsView.loadGame();
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

        game.setTimeOnRound(time);
        game.setMaxPoints(points);
        game.setLevel(level);

        settingsView.saveGame(game);
    }
}
