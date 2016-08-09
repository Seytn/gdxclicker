package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Kamil on 2016-08-09.
 */
public class Player extends Image {

    private final static int WIDTH = 77;
    private final static int HEIGHT = 152;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 300;


    public Player() {
        super(new Texture("badlogic.jpg"));

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X, STARTING_Y);

    }

    public void reactOnClick() {
        int moveAmount = MathUtils.random(-100,100);
        Action moveAction = Actions.sequence(
            Actions.moveBy(moveAmount, 15, 0.5f, Interpolation.circleIn),
            Actions.moveBy(-moveAmount, -15, 0.5f, Interpolation.circleOut)
        );

        int sizeAmount = MathUtils.random(0,50);
        Action changeSizeAction = Actions.sequence(
                Actions.sizeBy(sizeAmount, 15, 0.5f, Interpolation.circle),
                Actions.sizeBy(-sizeAmount, -15, 0.5f, Interpolation.circleOut)
        );

        this.addAction(moveAction);
        this.addAction(changeSizeAction);    }
}
