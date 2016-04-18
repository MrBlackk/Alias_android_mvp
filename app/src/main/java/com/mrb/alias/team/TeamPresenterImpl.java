package com.mrb.alias.team;

import com.mrb.alias.results.Game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chvs on 02.04.2016.
 */
public class TeamPresenterImpl implements TeamPresenter {

    TeamView teamView;
    ArrayList<Team> arrayOfTeams;
    Game game;

    public TeamPresenterImpl(TeamView teamView) {
        this.teamView = teamView;
        game = this.teamView.loadGame();
    }

    @Override
    public void onNextToSettingsClick() {
        teamView.saveGame(game);
        teamView.navigateToSettings();
    }

    @Override
    public void createTeams() {

        String firstName = this.getRandomName();
        String secondName = this.getRandomName();

        while (secondName.equals(firstName)){
            secondName = this.getRandomName();
        }

        Team teamOne = new Team(firstName);
        Team teamTwo = new Team(secondName);

        arrayOfTeams = new ArrayList<>();

        arrayOfTeams.add(teamOne);
        arrayOfTeams.add(teamTwo);

        game.setTeams(arrayOfTeams);
        teamView.showListOfTeams(arrayOfTeams);
    }

    private String getRandomName() {
        String[] names = {"Jedi", "Sith", "Test", "Bla bla", "Team", "X-ten"};
        int idx = new Random().nextInt(names.length);
        return names[idx];
    }
}
