package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Kamil on 2016-08-15.
 */
public class SoundService {

    private Sound simpleNutSound;

    public SoundService() {
        init();

    }

    private void init() {
        simpleNutSound = Gdx.audio.newSound(Gdx.files.internal("sounds/show.mp3"));
    }

    public void playNutSpawnSound(){
        simpleNutSound.play(0.3f);

    }
}
