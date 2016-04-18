package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;

/**
 * Created by chvs on 12.04.2016.
 */
public class ResultsPresenterImpl implements ResultsPresenter {

    ResultsView resultsView;
    ArrayList<Team> arrayOfTeams;
    Game game;

    public ResultsPresenterImpl(ResultsView resultsView) {
        this.resultsView = resultsView;
        game = this.resultsView.loadGame();
    }

    @Override
    public void getResults() {
        arrayOfTeams = game.getTeams();
        resultsView.showResults(arrayOfTeams);
    }

    @Override
    public void onStartButtonClick() {
        resultsView.saveGame(game);
        resultsView.navigateToGame();
    }

    @Override
    public void startGame() {
        if(!game.isStarted()){
            game.setIsStarted(true);
            game.setCurrentTeam(arrayOfTeams.get(0));
            game.setRound(1);
        }
    }

    @Override
    public void getRound() {
        resultsView.showRound(game.getRound());
    }

    @Override
    public void getNextTeam() {
        Team currentTeam = game.getCurrentTeam();
        resultsView.showNextTeam(currentTeam.getName());
    }

}
