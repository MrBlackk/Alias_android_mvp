package com.mrb.alias.team;

/**
 * Created by chvs on 09.04.2016.
 */
public class Team {

    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
