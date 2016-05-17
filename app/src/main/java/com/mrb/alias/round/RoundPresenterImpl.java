package com.mrb.alias.round;

import com.mrb.alias.results.Game;
import com.mrb.alias.team.Team;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Round Presenter implementation
 * Created by Volodymyr Chornyi on 18.04.2016.
 */
public class RoundPresenterImpl implements RoundPresenter {

    RoundView roundView;
    Game game;

    public RoundPresenterImpl(RoundView roundView) {
        this.roundView = roundView;
        game = this.roundView.loadGame();
    }

    /**
     * On start activity
     */
    @Override
    public void onStart() {
        getListOfWords();
    }

    /**
     * Get list of current results
     */
    private void getListOfWords() {
        roundView.showListOfWords(game.getCurrentResults());
    }

    /**
     * On Next button click
     */
    @Override
    public void onNextButtonClick() {
        addPointsToCurrentTeam(getNumberOfPoints());
        setNextTeam();
        clearListOfCurrentWords();
        roundView.saveGame(game);
        if (game.isStarted()) {
            roundView.navigateToResults();
        } else {
            roundView.navigateToWin();
        }
    }

    /**
     * On Back button pressed
     */
    @Override
    public void onBackButtonPressed() {
        clearListOfCurrentWords();
        roundView.saveGame(game);
        roundView.backToMenu();
    }

    /**
     * Clear list of current results
     */
    private void clearListOfCurrentWords() {
        game.clearCurrentResults();
    }

    /**
     * Set next Team
     */
    private void setNextTeam() {
        Team currentTeam = game.getCurrentTeam();
        ArrayList<Team> teams = game.getTeams();
        int currentIndex = teams.indexOf(currentTeam);

        int size = teams.size();
        int nextIndex = currentIndex + 1;

        if (currentIndex == size - 1) {
            nextIndex = 0;
            setNextRound();
            ArrayList<Team> winners = getWinners();
            if (winners != null) {
                game.setWinners(winners);
                game.setIsStarted(false);
            }
        }

        game.setCurrentTeam(teams.get(nextIndex));
    }

    /**
     * Set next round
     */
    private void setNextRound() {
        int currentRound = game.getRound();
        game.setRound(currentRound + 1);
    }

    /**
     * Add points to current Team
     */
    private void addPointsToCurrentTeam(int points) {
        Team currentTeam = game.getCurrentTeam();
        ArrayList<Team> teams = game.getTeams();

        int currentPoints = currentTeam.getPoints();

        int idx = teams.indexOf(currentTeam);

        teams.get(idx).setPoints(currentPoints + points);
        currentTeam.setPoints(currentPoints + points);
    }

    /**
     * Count number of points for current results
     */
    private int getNumberOfPoints() {
        LinkedHashMap<String, Boolean> results = game.getCurrentResults();
        int points = 0;

        for (LinkedHashMap.Entry<String, Boolean> entry : results.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }

            if (entry.getValue()) {
                points++;
            } else {
                points--;
            }
        }

        return points;
    }

    /**
     * Get winner or null if there is no winner yet
     */
    private ArrayList<Team> getWinners() {
        int pointsToWin = game.getMaxPoints();
        ArrayList<Team> teams = game.getTeams();
        ArrayList<Team> winners = null;
        boolean isFinished = false;
        int maxPoints = teams.get(0).getPoints();

        for (Team team : teams) {
            int points = team.getPoints();
            if (points >= pointsToWin && points >= maxPoints) {
                maxPoints = points;
                isFinished = true;
            }
        }

        if(isFinished){
            winners = new ArrayList<>();
            for (Team team : teams) {
                int points = team.getPoints();
                if (points == maxPoints) {
                    winners.add(team);
                }
            }
        }

        return winners;
    }

}
