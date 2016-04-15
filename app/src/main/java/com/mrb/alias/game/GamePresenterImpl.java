package com.mrb.alias.game;

import android.database.SQLException;

import com.mrb.alias.utils.DataBaseHelper;

import java.io.IOException;

/**
 * Created by chv on 15.04.2016.
 */
public class GamePresenterImpl implements GamePresenter {

    GameView gameView;
    DataBaseHelper dataBaseHelper;

    public GamePresenterImpl(GameView gameView) {
        this.gameView = gameView;
    }

    @Override
    public void getRandomWord() {
        dataBaseHelper = gameView.getDataBaseHelper();

        try {

            dataBaseHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            dataBaseHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }

        String word = dataBaseHelper.getRandomWord();

        gameView.showWord(word);
    }
}
