package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;

/**
 * Created by chv on 14.04.2016.
 */
public class GameSingleton {

    private static GameSingleton instance = null;
    private ArrayList<Team> teams;
    private Team currentTeam;
    private boolean isStarted;
    private boolean isRoundFinished;
    private int round;
    private int maxPoints;
    private int timeOnRound;

    private GameSingleton() {

    }

    public static GameSingleton getInstance() {
        if (instance == null) {
            instance = new GameSingleton();
        }
        return instance;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getTimeOnRound() {
        return timeOnRound;
    }

    public void setTimeOnRound(int timeOnRound) {
        this.timeOnRound = timeOnRound;
    }

    public boolean isRoundFinished() {
        return isRoundFinished;
    }

    public void setIsRoundFinished(boolean isRoundFinished) {
        this.isRoundFinished = isRoundFinished;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setIsStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public Team getCurrentTeam() {
        //move to presenter
//        if(isRoundFinished){
//            Team currentTeam = getCurrentTeam();
//            int currentIndex = teams.indexOf(currentTeam);
//            //implement checking current index and get next team
//            //setCurrentTeam(anotherTeam);
//            setIsRoundFinished(false);
//        }
        return currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }


}
