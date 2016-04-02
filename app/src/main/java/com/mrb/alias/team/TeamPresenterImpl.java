package com.mrb.alias.team;

/**
 * Created by chvs on 02.04.2016.
 */
public class TeamPresenterImpl implements TeamPresenter {

    TeamView teamView;

    public TeamPresenterImpl(TeamView teamView) {
        this.teamView = teamView;
    }

    @Override
    public void onStartGameClick() {
        teamView.navigateToGame();
    }
}
