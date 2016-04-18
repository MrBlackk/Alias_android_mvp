package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;

/**
 * Created by chvs on 12.04.2016.
 */
public interface ResultsView {

    void showResults(ArrayList<Team> arrayList);
    void showNextTeam(String teamName);
    void showRound(int round);
    void navigateToGame();
    void saveGame(Game game);
    Game loadGame();

}
