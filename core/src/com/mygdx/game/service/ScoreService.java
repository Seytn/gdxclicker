package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Kamil on 2016-08-16.
 */
public class ScoreService {
    public static final String GAME_PREFS = "com.mygdx.game.prefs";
    public static final String GAME_SCORE = "com.mygdx.game.score";
    public static final String GAME_FEAR = "com.mygdx.game.fear";

    private int points;
    private int fear;

    private Preferences prefs;

    public ScoreService() {
        init();

    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        points = prefs.getInteger(GAME_SCORE);
        fear = prefs.getInteger(GAME_FEAR);

    }

    public void addPoint(){
        points++;
    }

    public void addPoints(int nutPoints) {
        points += nutPoints;
    }



    public void fearDecrease() {
        fear -= 5;
    }

    public void increaseFear() {
        fear += 10;
    }


    public void resetScore() {
        points = 0;
        fear = 0;

    }

    public void updateSavedScore() {
        prefs.putInteger(GAME_SCORE, points);
        prefs.putInteger(GAME_FEAR, fear);
        prefs.flush();
    }

    public int getPoints() {
        return points;
    }


    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    public void halvePoints() {
        points -= points/2;
    }
}
