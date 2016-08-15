package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Kamil on 2016-08-15.
 */
public class NutsObject extends Image {

    public final static String NUT = "nut.png";

    private final static int WIDTH = 120;
    private final static int HEIGHT = 97;

    private final static int STARTING_X = 50;
    private final static int STARTING_Y = 100;

    public NutsObject(String texture) {
        super(new Texture(texture));

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X, STARTING_Y);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                System.out.println("klik");
                NutsObject.this.remove();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
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
