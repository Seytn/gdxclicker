package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.ui.SimpleEventDialog;


/**
 * Created by Kamil on 2016-08-15.
 */
public class NutsObject extends Image {

    public enum NutType{
        SIMPLE_NUT(90,70),
        FALLING_NUT(60,110),
        ROTTING_NUT(70,110),
        BIG_NUT(110,85),
        POISON(70,90);

        int width, height;

        NutType(int width, int height){
            this.width = width;
            this.height = height;

        }

        public static NutType getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }

    }

    public final static String SIMPLE_NUT = "nuts_pictures/nut.png";

    public final static String FALLING_NUT = "nuts_pictures/flying_nut.png";
    public final static String ROTTING_NUT = "nuts_pictures/rotting_nut.png";
    public final static String BIG_NUT = "nuts_pictures/big_nut.png";
    public final static String BIG_NUT_CRACKED1 = "nuts_pictures/big_nut_cracked1.png";
    public final static String BIG_NUT_CRACKED2 = "nuts_pictures/big_nut_cracked2.png";
    public final static String PEPPER = "nuts_pictures/pepper.png";
    private ClickerGdxGame game;
    private SimpleEventDialog poisonClieckedDialog;
    private SimpleEventDialog noFearDialog;

    private NutType type;
    private int bigNutCounter = 0;


    public NutsObject(NutType type, final ClickerGdxGame game, int startingX, int startingY) {
        super(new Texture(getTextureString(type)));

        this.game = game;
        this.type = type;


        this.setOrigin(type.width/2, type.height/2);
        this.setSize(type.width, type.height);


        this.setPosition(startingX, startingY);

        playSound();
                
        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                reactOnClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void playSound() {
        game.getSoundService().playSimpleNutSpawnSound();

    }

    public void reactOnClick() {
        if (game.getScoreService().getFear() > 0) {
            switch(type){
                case SIMPLE_NUT: {
                    game.getScoreService().addPoints(10);
                    nutEatAndRemove();
                    break;
                }
                case FALLING_NUT: {
                    game.getScoreService().addPoints(30);
                    nutEatAndRemove();
                    break;
                }
                case ROTTING_NUT: {
                    game.getScoreService().addPoints(50);
                    nutEatAndRemove();
                    break;
                }
                case BIG_NUT: {
                    bigNutCounter++;
                    game.getScoreService().fearDecrease();

                    if (bigNutCounter >=3){
                        game.getScoreService().addPoints(50);
                        nutEatAndRemove();
                        break;
                    }

                    changeTexture(bigNutCounter);
                    game.getSoundService().playPlayerClickSound();
                    break;
                }
                case POISON: {
                    game.getScoreService().halvePoints();
                    game.getSoundService().playNoFearSound();
                    warnDialog();
                    nutEatAndRemove();
                    break;
                }
            }


        } else {
            noFearDialog = new SimpleEventDialog(getStage(), SimpleEventDialog.DIALOG_NO_FEAR);
            getStage().addActor(noFearDialog);
            noFearDialog.fadeOutDialog(1.0f);
            game.getSoundService().playNoFearSound();
        }



    }

    private void changeTexture(int bigNutCounter) {
        switch (bigNutCounter){
            case 1: {
                Texture newTexture = new Texture(BIG_NUT_CRACKED1);
                this.setDrawable(new SpriteDrawable(new Sprite(newTexture)));
                break;
            }
            case 2: {
                Texture newTexture = new Texture(BIG_NUT_CRACKED2);
                this.setDrawable(new SpriteDrawable(new Sprite(newTexture)));
            }
            default: break;
        }


    }

    private void nutEatAndRemove() {
        game.getSoundService().playEatSound();
        game.getScoreService().fearDecrease();
        NutsObject.this.remove();
    }

    private void warnDialog() {
        poisonClieckedDialog = new SimpleEventDialog(getStage(), SimpleEventDialog.DIALOG_LOSE_POINTS);
        getStage().addActor(poisonClieckedDialog);
        poisonClieckedDialog.fadeOutDialog(1.0f);

    }



    private static String getTextureString(NutType type) {
        switch(type){
            case SIMPLE_NUT: {
                return SIMPLE_NUT;
            }
            case FALLING_NUT: {
                return FALLING_NUT;
            }

            case ROTTING_NUT: {
                return ROTTING_NUT;
            }

            case BIG_NUT: {
                return BIG_NUT;
            }

            case POISON: {
                return PEPPER;
            }

            default: return "";
        }
    }

    public void tremble(){
        Action rotate = Actions.forever(Actions.rotateBy(360,4));

        Action shake = Actions.forever(Actions.sequence(
                Actions.moveBy(10,0,0.25f),
                Actions.moveBy(-10,0,0.25f)
        ));

        Action fall;
        float randomDirectionX = MathUtils.random(-50f,50f);
        float randomDirectionY = MathUtils.random(-50f,50f);
        switch(type) {
            case SIMPLE_NUT: {


                fall = Actions.forever(Actions.sequence(
                        Actions.sizeBy(10f, 10f, 0.5f),
                        Actions.sizeBy(-10f, -10f, 0),
                        Actions.moveBy(randomDirectionX, randomDirectionY, 0.5f)
                ));
                break;
            }
            case FALLING_NUT: {
                fall = Actions.forever(Actions.moveBy(0, -50, 0.5f));
                break;
            }

            case BIG_NUT: {
                fall = Actions.forever(Actions.sequence(
                        Actions.sizeBy(10f, 10f, 0.5f),
                        Actions.sizeBy(-10f, -10f, 0),
                        Actions.delay(0.5f)
                ));
                break;
            }

            default: fall = Actions.forever(Actions.sequence(
                    Actions.sizeBy(10f, 10f, 0.5f),
                    Actions.sizeBy(-10f, -10f, 0),
                    Actions.moveBy(randomDirectionX, randomDirectionY, 0.5f)
            ));

        }

        Action tremble = Actions.parallel(
                rotate,
                shake,
                fall
        );



        this.addAction(tremble);
    }

}
