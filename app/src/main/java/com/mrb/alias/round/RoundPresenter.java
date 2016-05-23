package com.mrb.alias.round;

/**
 * Round Presenter interface
 * Created by Volodymyr Chornyi on 18.04.2016.
 */
public interface RoundPresenter {

    void onStart();

    void onNextButtonClick();

    void onBackButtonPressed();

    void getAndShowCurrentPoints();
}
