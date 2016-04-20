package com.mrb.alias.win;

import com.mrb.alias.results.Game;
import com.mrb.alias.team.Team;

import java.util.ArrayList;

/**
 * Created by chvs on 20.04.2016.
 */
public interface WinView {

    void showWinner(String winner);
    void saveGame(Game game);
    Game loadGame();
    void showResults(ArrayList<Team> arrayList);
    void navigateToMenu();
}
