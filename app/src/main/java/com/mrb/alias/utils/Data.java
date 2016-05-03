package com.mrb.alias.utils;

/**
 * Data class
 * Created by chvs on 03.05.2016.
 */
public class Data {

    private static final String[] TEAM_NAMES = {"Jedi", "Sith", "Test", "Bla bla", "Team", "X-ten"};

    public static String getTeamName(int index) {
        return TEAM_NAMES[index];
    }

    public static int teamNamesCount() {
        return TEAM_NAMES.length;
    }
}
