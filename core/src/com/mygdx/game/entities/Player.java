package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.ClickerGdxGame;

import static java.lang.Math.abs;

/**
 * Created by Kamil on 2016-08-09.
 */
public class Player extends Image {

    public final static String PLAYER_TEXTURE = "player.png";

    private final static int WIDTH = 150;
    private final static int HEIGHT = 141;

    private final static int STARTING_X = 85;
    private final static int STARTING_Y = 300;
    private final ClickerGdxGame game;

    public Player(ClickerGdxGame game) {
        super(new Texture(PLAYER_TEXTURE));

        this.game = game;

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X, STARTING_Y);

    }

    public void reactOnClick() {


        int xMoveAmount = MathUtils.random(-120,120);
        int yMoveAmount = 25;
        float actionTime = 0.4f;



        Action moveAction = Actions.sequence(
            Actions.moveBy(xMoveAmount, yMoveAmount, actionTime, Interpolation.circleOut),
            Actions.moveBy(-xMoveAmount, -yMoveAmount, actionTime, Interpolation.circleIn)

        );

        int xSizeAmount = MathUtils.random(0,50);
        int ySizeAmount = abs(xMoveAmount/3);
        Action changeSizeAction = Actions.sequence(
                Actions.sizeBy(xSizeAmount, ySizeAmount, actionTime, Interpolation.circleOut),
                Actions.sizeBy(-xSizeAmount, -ySizeAmount, actionTime, Interpolation.circleIn)

        );

        this.addAction(moveAction);
        this.addAction(changeSizeAction);

        int actualAmountOfFear = game.getScoreService().getFear();
        if (actualAmountOfFear <= 90) {
            game.getScoreService().increaseFear();
        } else if (actualAmountOfFear < 100){
            game.getScoreService().setFear(100);
        }
    }
}
