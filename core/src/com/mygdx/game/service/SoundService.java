package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Kamil on 2016-08-15.
 */
public class SoundService {

    private Music music;

    private Sound simpleNutSound, fallingNutSound, playerClickSound;
    private Sound eatSound;

    public SoundService() {
        init();
        playMusic();
    }

    private void init() {
        simpleNutSound = Gdx.audio.newSound(Gdx.files.internal("sounds/show.mp3"));
        fallingNutSound = Gdx.audio.newSound(Gdx.files.internal("sounds/show.mp3"));
        playerClickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/punch.wav"));
        eatSound = Gdx.audio.newSound(Gdx.files.internal("sounds/eat.mp3"));

        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));

    }

    public void playMusic() {
        music.play();
        music.setLooping(true);
        music.setVolume(0.3f);
    }

    public void playSimpleNutSpawnSound(){
        simpleNutSound.play(0.2f);

    }
    public void playFallingNutSpawnSound(){
        fallingNutSound.play(0.2f);

    }

    public void playPlayerClickSound(){
        playerClickSound.play(0.3f);
    }

    public void playEatSound(){
        eatSound.play(0.3f);
    }
}
