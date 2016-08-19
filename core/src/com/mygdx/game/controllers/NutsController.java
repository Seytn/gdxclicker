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
    int fallingNutsStartingY;

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
        },0,0.5f);

    }

    private void addNutToStage() {
        nut = null;
        startingX = MathUtils.random(15,420);
        startingY = MathUtils.random(15,750);
        fallingNutsStartingY = 820;
        NutsObject.NutType randomType = NutsObject.NutType.getRandom();
        switch(randomType){
            case FALLING_NUT: {
                nut = new NutsObject(NutsObject.NutType.FALLING_NUT, game, startingX, fallingNutsStartingY);
                break;
               }
            case SIMPLE_NUT: {
                nut = new NutsObject(NutsObject.NutType.SIMPLE_NUT, game, startingX, startingY);
                break;
            }
            case ROTTING_NUT: {
                nut = new NutsObject(NutsObject.NutType.ROTTING_NUT, game, startingX, startingY);
                break;
            }
            case BIG_NUT: {
                nut = new NutsObject(NutsObject.NutType.BIG_NUT, game, startingX, startingY);
                break;
            }
            case POISON: {
                nut = new NutsObject(NutsObject.NutType.POISON, game, startingX, startingY);
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
        spawnTime = MathUtils.random(0.5f,3.0f);
    }
}
