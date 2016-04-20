package com.mrb.alias.round;

import com.mrb.alias.results.Game;
import com.mrb.alias.team.Team;

import java.util.ArrayList;
import java.util.HashMap;

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
        addPointsToCurrentTeam(getNumberOfPoints());
        setNextTeam();
        clearListOfCurrentWords();
        roundView.saveGame(game);
        if(game.isStarted()){
            roundView.navigateToResults();
        } else {
            roundView.navigateToWin();
        }
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
            Team winner = getWinner();
            if(winner != null){
                nextIndex = teams.indexOf(winner);
                game.setIsStarted(false);
            }
        }

        game.setCurrentTeam(teams.get(nextIndex));
    }

    @Override
    public void setNextRound() {
        int currentRound = game.getRound();
        game.setRound(currentRound + 1);
    }

    @Override
    public void addPointsToCurrentTeam(int points) {
        Team currentTeam = game.getCurrentTeam();
        ArrayList<Team> teams = game.getTeams();

        int currentPoints = currentTeam.getPoints();

        int idx = teams.indexOf(currentTeam);

        teams.get(idx).setPoints(currentPoints + points);
        currentTeam.setPoints(currentPoints + points);
    }

    @Override
    public int getNumberOfPoints() {
        HashMap<String, Boolean> results = game.getCurrentResults();
        int points = 0;

        for (HashMap.Entry<String, Boolean> entry : results.entrySet()){
            if(entry.getValue() == null){
                continue;
            }

            if (entry.getValue()){
                points++;
            } else {
                points--;
            }
        }

        return points;
    }

    @Override
    public Team getWinner() {
        int pointsToWin = game.getMaxPoints();
        ArrayList<Team> teams = game.getTeams();
        Team winner = null;
        int maxPoints = teams.get(0).getPoints();

       for(Team team: teams){
           int points = team.getPoints();
           if(points >= pointsToWin && points >= maxPoints){
               winner = team;
           }
       }
        
        return winner;
    }

}
