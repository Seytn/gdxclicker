package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.SplashScreen;

public class ClickerGdxGame extends Game {

    public static final String GAME_NAME = "Clicker";

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;

    private boolean paused;



    @Override
    public void create() {
        this.setScreen(new SplashScreen(this));

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
}
