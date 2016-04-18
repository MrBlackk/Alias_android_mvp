package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chv on 14.04.2016.
 */
public class Game {

    private static Game instance = null;
    private ArrayList<Team> teams;
    private Team currentTeam;
    private boolean isStarted;
    private boolean isRoundFinished;
    private int round;
    private int maxPoints;
    private int timeOnRound;
    private HashMap<String, Boolean> currentResults = new HashMap<>();
    private String level;

    private Game() {

    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public HashMap<String, Boolean> getCurrentResults() {
        return currentResults;
    }

    public void addCurrentResult(String word, Boolean isGuessed) {
        this.currentResults.put(word, isGuessed);
    }

    public void clearCurrentResults(){
        this.currentResults.clear();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
