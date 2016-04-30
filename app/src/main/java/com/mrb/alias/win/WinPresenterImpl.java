package com.mrb.alias.win;

import com.mrb.alias.results.Game;
import com.mrb.alias.team.Team;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Win presenter implementation
 * Created by Volodymyr Chornyi on 20.04.2016.
 */
public class WinPresenterImpl implements WinPresenter {

    WinView winView;
    Game game;

    public WinPresenterImpl(WinView winView) {
        this.winView = winView;
        game = this.winView.loadGame();
    }

    /**
     * On start activity
     */
    @Override
    public void onStart() {
        getWinner();
        getResults();
    }

    /**
     * Get winner name and show it
     */
    private void getWinner() {
        Team winnerTeam = game.getCurrentTeam();
        String name = winnerTeam.getName();
        winView.showWinner(name);
    }

    /**
     * Get results and show it
     */
    private void getResults() {
        winView.showResults(game.getTeams());
    }

    /**
     * On Go to Menu button click
     */
    @Override
    public void onGoToMenuButtonClick() {
        winView.navigateToMenu();
    }

    /**
     * On Return Match button click - set points to 0 and clear used words
     */
    @Override
    public void onReturnMatchButtonClick() {
        ArrayList<Team> teams = game.getTeams();

        for (Team team : teams ) {
            team.setPoints(0);
        }
        game.setTeams(teams);
        game.setUsedIds(new HashSet<Integer>());
        winView.saveGame(game);
        winView.navigateToResults();
    }
}
