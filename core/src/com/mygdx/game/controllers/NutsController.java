package com.mygdx.game.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.entities.NutsObject;

/**
 * Created by Kamil on 2016-08-15.
 */
public class NutsController {

    private float spawnTime;
    ClickerGdxGame game;
    Stage stage;

    NutsObject nut;
    int startingX;
    int startingY;
    int fallingStartingY;

    public NutsController(ClickerGdxGame game, Stage stage) {
        this.game = game;
        this.stage = stage;
        init();

    }

    private void init() {


        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                randomizeSpawnTime();

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        addNutToStage();

                    }
                },spawnTime);
            }
        },0,1);

    }

    private void addNutToStage() {
        nut = null;
        startingX = MathUtils.random(15,420);
        startingY = MathUtils.random(15,750);
        fallingStartingY = 820;
        NutsObject.NutType randomType = NutsObject.NutType.getRandom();
        switch(randomType){
            case FALLING_NUT: {
                nut = new NutsObject(NutsObject.NutType.FALLING_NUT, game, startingX, fallingStartingY);
                break;
               }
            case SIMPLE_NUT: {
                nut = new NutsObject(NutsObject.NutType.SIMPLE_NUT, game, startingX, startingY);
                break;
            }
            default: {
                nut = new NutsObject(NutsObject.NutType.SIMPLE_NUT, game, startingX, startingY);
            }
        }

        stage.addActor(nut);
        nut.tremble();
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(1.0f,3.0f);
    }
}
