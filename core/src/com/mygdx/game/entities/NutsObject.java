package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.ui.clickCallback;

/**
 * Created by Kamil on 2016-08-15.
 */
public class NutsObject extends Image {

    public enum NutType{
        SIMPLE_NUT, FALLING_NUT
    }

    public final static String SIMPLE_NUT = "nut.png";
    public final static String FALLING_NUT = "flying_nut.png";

    private ClickerGdxGame game;

    private final static int WIDTH = 120;
    private final static int HEIGHT = 97;

    private final static int STARTING_X = 50;
    private final static int STARTING_Y = 100;

    private NutType type;

    public NutsObject(NutType type, ClickerGdxGame game, final clickCallback callback) {
        super(new Texture(getTextureString(type)));

        this.game = game;
        this.type = type;

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X, STARTING_Y);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                callback.onClick();

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

        Action tremble = Actions.parallel(
                rotate,
                shake
        );

        this.addAction(tremble);
    }

}
