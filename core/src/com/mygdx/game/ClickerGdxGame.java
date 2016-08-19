package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.SplashScreen;
import com.mygdx.game.service.ScoreService;
import com.mygdx.game.service.SoundService;

public class ClickerGdxGame extends Game {


    public static final String GAME_NAME = "Dumb Squirrel";

    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    private SoundService soundService;

    private ScoreService scoreService;


    @Override
    public void create() {
        init();
        this.setScreen(new SplashScreen(this));

    }



    private void init() {
        initSoundService();
        initScoreService();
    }

    private void initScoreService() {
        scoreService = new ScoreService();
    }


    private void initSoundService() {
        soundService = new SoundService();
    }


    public SoundService getSoundService() {
        return soundService;
    }

    public ScoreService getScoreService() {
        return scoreService;
    }



}
