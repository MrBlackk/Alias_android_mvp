package com.mrb.alias.round;

import com.mrb.alias.results.Game;
import com.mrb.alias.team.Team;

import java.util.ArrayList;

/**
 * Created by chvs on 18.04.2016.
 */
public class RoundPresenterImpl implements RoundPresenter {

    RoundView roundView;
    Game game;

    public RoundPresenterImpl(RoundView roundView) {
        this.roundView = roundView;
        game = this.roundView.loadGame();
    }

    @Override
    public void getListOfWords() {
        roundView.showListOfWords(game.getCurrentResults());
    }

    @Override
    public void onNextButtonClick() {
        setNextTeam();
        clearListOfCurrentWords();
        roundView.saveGame(game);
        roundView.navigateToResults();
    }

    @Override
    public void clearListOfCurrentWords() {
        game.clearCurrentResults();
    }

    @Override
    public void setNextTeam() {
        Team currentTeam = game.getCurrentTeam();
        ArrayList<Team> teams = game.getTeams();
        int currentIndex = teams.indexOf(currentTeam);

        int size = teams.size();
        int nextIndex = currentIndex + 1;

        if(currentIndex == size - 1){
            nextIndex = 0;
            setNextRound();
        }

        game.setCurrentTeam(teams.get(nextIndex));
    }

    @Override
    public void setNextRound() {
        int currentRound = game.getRound();
        game.setRound(currentRound + 1);
    }
}
