package com.mrb.alias.team;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chvs on 02.04.2016.
 */
public class TeamPresenterImpl implements TeamPresenter {

    TeamView teamView;
    ArrayList<Team> arrayOfTeams;

    public TeamPresenterImpl(TeamView teamView) {
        this.teamView = teamView;
    }

    @Override
    public void onNextToSettingsClick() {
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

        teamView.showListOfUsers(arrayOfTeams);
    }

    @Override
    public String getRandomName() {
        String[] names = {"Jedi", "Sith", "Test", "Bla bla", "Team", "X-ten"};
        int idx = new Random().nextInt(names.length);
        return names[idx];
    }


}
