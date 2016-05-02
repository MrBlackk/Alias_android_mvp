package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;

/**
 * Results Presenter implementation
 * Created by Volodymyr Chornyi on 12.04.2016.
 */
public class ResultsPresenterImpl implements ResultsPresenter {

    public static final boolean POINTS_VISIBLE = true;
    ResultsView resultsView;
    ArrayList<Team> arrayOfTeams;
    Game game;

    public ResultsPresenterImpl(ResultsView resultsView) {
        this.resultsView = resultsView;
        game = this.resultsView.loadGame();
    }

    /**
     * On start activity
     */
    @Override
    public void onStart() {
        getResults();
        startGame();
        getNextTeam();
        getRound();
    }

    /**
     * Get team results and show it
     */
    private void getResults() {
        arrayOfTeams = game.getTeams();
        resultsView.showResults(arrayOfTeams, POINTS_VISIBLE);
    }

    /**
     * On Start button click
     */
    @Override
    public void onStartButtonClick() {
        resultsView.saveGame(game);
        resultsView.navigateToGame();
    }

    /**
     * On back button pressed
     */
    @Override
    public void onBackButtonPressed() {
        resultsView.backToSettings();
    }

    /**
     * Start game and set default values
     */
    private void startGame() {
        if (!game.isStarted()) {
            game.setIsStarted(true);
            game.setCurrentTeam(arrayOfTeams.get(0));
            game.setRound(1);
        }
    }

    /**
     * Get current round and show it
     */
    private void getRound() {
        resultsView.showRound(game.getRound());
    }

    /**
     * Get next team and show it
     */
    private void getNextTeam() {
        Team currentTeam = game.getCurrentTeam();
        resultsView.showNextTeam(currentTeam.getName());
    }

}
