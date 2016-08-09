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
        int xMoveAmount = MathUtils.random(-100,100);
        int yMoveAmount = 15;
        float actionTime = 0.4f;

        Action moveAction = Actions.sequence(
            Actions.moveBy(xMoveAmount, yMoveAmount, actionTime, Interpolation.circleIn),
            Actions.moveBy(-xMoveAmount, -yMoveAmount, actionTime, Interpolation.circleOut)
        );

        int xSizeAmount = MathUtils.random(0,50);
        int ySizeAmount = 15;
        Action changeSizeAction = Actions.sequence(
                Actions.sizeBy(xSizeAmount, ySizeAmount, actionTime, Interpolation.circle),
                Actions.sizeBy(-xSizeAmount, -ySizeAmount, actionTime, Interpolation.circleOut)
        );

        this.addAction(moveAction);
        this.addAction(changeSizeAction);    }
}
