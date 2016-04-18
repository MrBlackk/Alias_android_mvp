package com.mrb.alias.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.mrb.alias.results.Game;

/**
 * Created by chvs on 09.04.2016.
 */
public class SharedPreference {

    public static final String PREFS_NAME = "ALIAS_PREFS";
    public static final String GAME = "Game";

    public void saveGame(Context context, Game game) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonGame = gson.toJson(game);

        editor.putString(GAME, jsonGame);
        editor.apply();
    }

    public Game loadGame(Context context) {
        SharedPreferences settings;
        Game game;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if (settings.contains(GAME)) {
            String jsonGame = settings.getString(GAME, null);
            Gson gson = new Gson();
            game = gson.fromJson(jsonGame, Game.class);
        } else {
            return Game.getInstance();
        }
        return game;
    }

    public void clearPreferences(Context context) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        if (settings != null) {
            editor = settings.edit();

            editor.clear();
            editor.apply();
        }
    }
}
