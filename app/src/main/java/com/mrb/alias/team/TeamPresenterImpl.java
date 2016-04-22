package com.mrb.alias.team;

import com.mrb.alias.results.Game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Team Presenter implementation
 * Created by Volodymyr Chornyi on 02.04.2016.
 */
public class TeamPresenterImpl implements TeamPresenter {

    public static final boolean POINTS_NOT_VISIBLE = false;
    TeamView teamView;
    ArrayList<Team> arrayOfTeams;
    Game game;

    public TeamPresenterImpl(TeamView teamView) {
        this.teamView = teamView;
        game = this.teamView.loadGame();
    }

    /**
     * On Next button click
     */
    @Override
    public void onNextButtonClick() {
        teamView.saveGame(game);
        teamView.navigateToSettings();
    }

    /**
     * Create two teams with different names
     */
    private void createTeams() {

        String firstName = this.getRandomName();
        String secondName = this.getRandomName();

        while (secondName.equals(firstName)) {
            secondName = this.getRandomName();
        }

        Team teamOne = new Team(firstName);
        Team teamTwo = new Team(secondName);

        arrayOfTeams = new ArrayList<>();

        arrayOfTeams.add(teamOne);
        arrayOfTeams.add(teamTwo);

        game.setTeams(arrayOfTeams);
    }

    /**
     * On start activity
     */
    @Override
    public void onStart() {
        createTeams();
        teamView.showListOfTeams(arrayOfTeams, POINTS_NOT_VISIBLE);
    }

    /**
     * Get random name of team
     */
    private String getRandomName() {
        String[] names = {"Jedi", "Sith", "Test", "Bla bla", "Team", "X-ten"};
        int idx = new Random().nextInt(names.length);
        return names[idx];
    }
}
