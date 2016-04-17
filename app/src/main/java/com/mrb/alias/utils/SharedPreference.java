package com.mrb.alias.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.mrb.alias.results.GameSingleton;
import com.mrb.alias.team.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chvs on 09.04.2016.
 */
public class SharedPreference {

    public static final String PREFS_NAME = "ALIAS_PREFS";
    public static final String TEAMS = "Teams";
    public static final String GAME = "Game";
    public static final String TIME = "Time";
    public static final String POINTS = "Points";
    public static final String LEVEL = "Level";

    public void saveTeams(Context context, ArrayList<Team> teams){
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonTeams = gson.toJson(teams);

        editor.putString(TEAMS, jsonTeams);
        editor.apply();
    }

    public ArrayList<Team> getTeams(Context context){
        SharedPreferences settings;
        List<Team> teams;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if(settings.contains(TEAMS)){
            String jsonTeams = settings.getString(TEAMS, null);
            Gson gson = new Gson();
            Team[] teamItems = gson.fromJson(jsonTeams, Team[].class);

            teams = Arrays.asList(teamItems);
            teams = new ArrayList<>(teams);

        } else {
            return null;
        }
        return (ArrayList<Team>) teams;
    }
    public void saveGame(Context context, GameSingleton game){
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonGame = gson.toJson(game);

        editor.putString(GAME, jsonGame);
        editor.apply();
    }

    public GameSingleton getGame(Context context){
        SharedPreferences settings;
        GameSingleton game;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if(settings.contains(GAME)){
            String jsonGame = settings.getString(GAME, null);
            Gson gson = new Gson();
            game = gson.fromJson(jsonGame, GameSingleton.class);
        } else {
            return null;
        }
        return game;
    }

    public void saveSettings(Context context, int time, int points, String level){
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putInt(TIME, time);
        editor.putInt(POINTS, points);
        editor.putString(LEVEL, level);

        editor.apply();
    }

    public int getTime(Context context){
        SharedPreferences settings;
        int time;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        time = settings.getInt(TIME, 0);
        return time;
    }

    public int getPoints(Context context){
        SharedPreferences settings;
        int points;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        
        points = settings.getInt(POINTS, 0);
        return points;
    }

    public String getLevel(Context context){
        SharedPreferences settings;
        String level;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        level = settings.getString(LEVEL, null);
        return level;
    }

}
