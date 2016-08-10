package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.screens.SplashScreen;

public class ClickerGdxGame extends Game {

    public static final String GAME_PREFS = "com.mygdx.game.prefs";
    public static final String GAME_SCORE = "com.mygdx.game.score";
    public static final String GAME_NAME = "Clicker";

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;

    private boolean paused;

    private int points;

    private Preferences prefs;


    @Override
    public void create() {
        init();
        this.setScreen(new SplashScreen(this));

    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        points = prefs.getInteger(GAME_SCORE);
    }

    public void addPoint(){
        points++;
        prefs.putInteger(GAME_SCORE, points);
        prefs.flush();
    }

    /*
    getters and setters
    */
    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public int getPoints() {
        return points;
    }
}
