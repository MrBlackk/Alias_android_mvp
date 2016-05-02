package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;

/**
 * Results View interface
 * Created by Volodymyr Chornyi on 12.04.2016.
 */
public interface ResultsView {

    void showResults(ArrayList<Team> arrayList, boolean isPointsVisible);

    void showNextTeam(String teamName);

    void showRound(int round);

    void navigateToGame();

    void backToSettings();

    void saveGame(Game game);

    Game loadGame();

}
