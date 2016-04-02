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
    public void onGoButtonClick() {
        settingsView.navigateToTeam();
    }
}
