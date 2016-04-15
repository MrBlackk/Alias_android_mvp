package com.mrb.alias.game;

import com.mrb.alias.utils.DataBaseHelper;

/**
 * Created by chv on 15.04.2016.
 */
public interface GameView {

    void showWord(String word);
    DataBaseHelper getDataBaseHelper();
}
