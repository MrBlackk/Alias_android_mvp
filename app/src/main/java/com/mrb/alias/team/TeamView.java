package com.mrb.alias.team;

import com.mrb.alias.results.Game;

import java.util.ArrayList;

/**
 * Created by chvs on 02.04.2016.
 */
public interface TeamView {
    void navigateToSettings();
    void showListOfTeams(ArrayList<Team> arrayList);
    Game loadGame();
    void saveGame(Game game);
}
