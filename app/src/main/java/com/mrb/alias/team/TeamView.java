package com.mrb.alias.team;

import com.mrb.alias.results.Game;

import java.util.ArrayList;

/**
 * Team View interface
 * Created by Volodymyr Chornyi on 02.04.2016.
 */
public interface TeamView {
    void navigateToSettings();

    void showListOfTeams(ArrayList<Team> arrayList, boolean isPointsVisible);

    Game loadGame();

    void saveGame(Game game);
}
