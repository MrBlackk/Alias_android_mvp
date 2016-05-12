package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Game singleton class
 * Created by Volodymyr Chornyi on 14.04.2016.
 */
public class Game {

    private static Game instance = null;
    private ArrayList<Team> teams;
    private ArrayList<Team> winners;
    private Team currentTeam;
    private boolean isStarted;
    private boolean isRoundFinished;
    private int round;
    private int maxPoints;
    private int timeOnRound;
    private LinkedHashMap<String, Boolean> currentResults = new LinkedHashMap<>();
    private String level;
    private HashSet<Integer> usedIds = new HashSet<>();

    private Game() {
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public HashSet<Integer> getUsedIds() {
        return usedIds;
    }

    public void addUsedIds(Integer usedIds) {
        this.usedIds.add(usedIds);
    }

    public void setUsedIds(HashSet<Integer> usedIds) {
        this.usedIds = usedIds;
    }

    public LinkedHashMap<String, Boolean> getCurrentResults() {
        return currentResults;
    }

    public void addCurrentResult(String word, Boolean isGuessed) {
        this.currentResults.put(word, isGuessed);
    }

    public void clearCurrentResults() {
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

    public ArrayList<Team> getWinners() {
        return winners;
    }

    public void setWinners(ArrayList<Team> winners) {
        this.winners = winners;
    }
}
