package com.mrb.alias.round;

/**
 * Created by chvs on 18.04.2016.
 */
public interface RoundPresenter {

    void getListOfWords();
    void onNextButtonClick();
    void clearListOfCurrentWords();
    void setNextTeam();
    void setNextRound();
    void addPointsToCurrentTeam(int points);
    int getNumberOfPoints();
}
