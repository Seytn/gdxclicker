package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Kamil on 2016-08-16.
 */
public class ScoreService {
    public static final String GAME_PREFS = "com.mygdx.game.prefs";
    public static final String GAME_SCORE = "com.mygdx.game.score";

    private int points;

    private Preferences prefs;
    public ScoreService() {
        init();

    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        points = prefs.getInteger(GAME_SCORE);
    }

    public void addPoint(){
        points++;
    }

    public void addPoints(int nutPoints) {
        points += nutPoints;
    }

    public void resetScore() {
        points = 0;
    }

    public void updateSavedScore() {
        prefs.putInteger(GAME_SCORE, points);
        prefs.flush();
    }

    public int getPoints() {
        return points;
    }
}
