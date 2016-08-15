package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.ClickerGdxGame;

/**
 * Created by Kamil on 2016-08-15.
 */
public class NutsObject extends Image {

    public enum NutType{
        SIMPLE_NUT(120,97),
        FALLING_NUT(80,150);

        int width, height;

        NutType(int width, int height){
            this.width = width;
            this.height = height;

        }

        public static NutType getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }

    }

    public final static String SIMPLE_NUT = "nut.png";
    public final static String FALLING_NUT = "flying_nut.png";


    private ClickerGdxGame game;

    private NutType type;

    public NutsObject(NutType type, ClickerGdxGame game, int startingX, int startingY) {
        super(new Texture(getTextureString(type)));

        this.game = game;
        this.type = type;


        this.setOrigin(type.width/2, type.height/2);
        this.setSize(type.width, type.height);


        this.setPosition(startingX, startingY);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                reactOnClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void reactOnClick() {

        switch(type){
            case SIMPLE_NUT: {
                game.addPoints(10);
                break;
            }
            case FALLING_NUT: {
                game.addPoints(30);
                break;
            }
        }

        NutsObject.this.remove();
    }

    private static String getTextureString(NutType type) {
        switch(type){
            case SIMPLE_NUT: {
                return SIMPLE_NUT;
            }
            case FALLING_NUT: {
                return FALLING_NUT;
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
        switch(type) {
            case SIMPLE_NUT: {
                fall = Actions.sequence(
                        Actions.sizeBy(0.5f, 0.5f, 0.5f),
                        Actions.sizeBy(-0.5f, -0.5f, -0.5f)
                );
                break;
            }
            case FALLING_NUT: {
                fall = Actions.forever(Actions.moveBy(0, -50, 0.5f));
                break;
            }
            default: fall = Actions.forever(Actions.moveBy(0, -50, 0.5f));

        }

        Action tremble = Actions.parallel(
                rotate,
                shake,
                fall
        );



        this.addAction(tremble);
    }

}
