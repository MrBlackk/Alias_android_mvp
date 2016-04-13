package com.mrb.alias.results;

import com.mrb.alias.team.Team;

import java.util.ArrayList;

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

        arrayOfTeams = resultsView.getTeams();

        Team first = arrayOfTeams.get(0);
        Team second = arrayOfTeams.get(1);

        // todo: just example of points, remove later
        first.setPoints(11);
        second.setPoints(12);

        resultsView.showResults(arrayOfTeams);
    }

    @Override
    public void onStartButtonClick() {
        resultsView.navigateToGame();
    }
}
