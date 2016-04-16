package com.mrb.alias.game;

import com.mrb.alias.utils.DataBaseHelper;

/**
 * Created by chv on 15.04.2016.
 */
public class GamePresenterImpl implements GamePresenter {

    GameView gameView;
    DataBaseHelper dataBaseHelper;

    public GamePresenterImpl(GameView gameView, DataBaseHelper dataBaseHelper) {
        this.gameView = gameView;
        this.dataBaseHelper = dataBaseHelper;

    }

    @Override
    public void getRandomWord() {
        String word = dataBaseHelper.getRandomWord();

        gameView.showWord(word);
    }

    @Override
    public void onPlusButtonClick() {

        onButtonClick();
    }

    @Override
    public void onMinusButtonClick() {

        onButtonClick();
    }

    private void onButtonClick() {
        getRandomWord();
    }
}
