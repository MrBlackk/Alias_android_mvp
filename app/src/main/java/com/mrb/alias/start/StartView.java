package com.mrb.alias.start;

import com.mrb.alias.results.Game;

/**
 * Start View interface
 * Created by Volodymyr Chornyi on 01.04.2016.
 */
public interface StartView {
    void navigateToTeam();

    void navigateToResults();

    void exit();

    void showRules();

    void clearPreferences();

    void hideContinueButton();

    Game loadGame();
}
