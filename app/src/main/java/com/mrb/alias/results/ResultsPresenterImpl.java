package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chvs on 12.04.2016.
 */
public class ResultsPresenterImpl implements ResultsPresenter {

    ResultsView resultsView;
    ArrayList<Team> arrayOfTeams;

    public ResultsPresenterImpl(ResultsView resultsView) {
        this.resultsView = resultsView;
    }

    @Override
    public void getResults() {

        //todo: It's just for test remove after implementing Shared Preferences
        String firstName = this.getRandomName();
        String secondName = this.getRandomName();

        while (secondName.equals(firstName)){
            secondName = this.getRandomName();
        }

        Team teamOne = new Team(firstName);
        Team teamTwo = new Team(secondName);

        teamOne.setPoints(15);
        teamTwo.setPoints(26);

        arrayOfTeams = new ArrayList<>();

        arrayOfTeams.add(teamOne);
        arrayOfTeams.add(teamTwo);

        resultsView.showResults(arrayOfTeams);
    }

    @Override
    public void onStartButtonClick() {
        resultsView.navigateToGame();
    }

    public String getRandomName() {
        //todo: It's just for test remove after implementing Shared Preferences
        String[] names = {"Jedi", "Sith", "Test", "Bla bla", "Team", "X-ten"};
        int idx = new Random().nextInt(names.length);
        return names[idx];
    }
}
