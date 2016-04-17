package com.mrb.alias.game;

/**
 * Created by chv on 15.04.2016.
 */
public interface GamePresenter {

    void getRandomWord();
    void onPlusButtonClick();
    void onMinusButtonClick();
    void onTimeFinished();
    void startTimer();
}
