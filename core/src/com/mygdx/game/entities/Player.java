package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static java.lang.Math.abs;

/**
 * Created by Kamil on 2016-08-09.
 */
public class Player extends Image {


    private final static int WIDTH = 150;
    private final static int HEIGHT = 141;

    private final static int STARTING_X = 185;
    private final static int STARTING_Y = 300;

    boolean isPlayerMovedLeft = false;
    int xSide = WIDTH;
    Action changeSideAction;

    public Player() {
        super(new Texture("player.png"));

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X, STARTING_Y);

    }

    public void reactOnClick() {


        int xMoveAmount = MathUtils.random(-120,120);
        int yMoveAmount = 25;
        float actionTime = 0.4f;

        if (xMoveAmount < 0 && !isPlayerMovedLeft) {
            xSide = -WIDTH;
            this.setWidth(xSide);
            float x = this.getX();
            this.setX(x + WIDTH);
            isPlayerMovedLeft = true;

        } else if(xMoveAmount > 0 && isPlayerMovedLeft) {
            xSide = WIDTH;
            this.setWidth(xSide);
            float x = this.getX();
            this.setX(x - WIDTH);
            isPlayerMovedLeft = false;

        }

        Action moveAction = Actions.sequence(
            Actions.moveBy(xMoveAmount, yMoveAmount, actionTime, Interpolation.circleOut),
            Actions.moveBy(-xMoveAmount, -yMoveAmount, actionTime, Interpolation.circleIn)

        );

        int xSizeAmount = MathUtils.random(0,50);
        if (isPlayerMovedLeft) xSizeAmount = -xSizeAmount;
        int ySizeAmount = abs(xMoveAmount/3);
        Action changeSizeAction = Actions.sequence(
                Actions.sizeBy(xSizeAmount, ySizeAmount, actionTime, Interpolation.circleOut),
                Actions.sizeBy(-xSizeAmount, -ySizeAmount, actionTime, Interpolation.circleIn)

        );

        this.addAction(moveAction);
        this.addAction(changeSizeAction);


    }
}
