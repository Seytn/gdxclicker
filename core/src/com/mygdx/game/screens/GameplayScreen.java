package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.*;

/**
 * Created by Kamil on 2016-08-09.
 */
public class GameplayScreen extends AbstractScreen{

    private Player player;
    private PlayerButton playerButton;
    private Button resetScoreButon;
    private Label scoreLabel;

    public GameplayScreen(ClickerGdxGame game) {
        super(game);


    }

    @Override
    protected void init() {
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScoreLabel();
    }

    private void initScoreLabel() {
        scoreLabel = new Label("Points: " + String.valueOf(game.getPoints()),
                new Label.LabelStyle(new BitmapFont(), Color.RED));
        scoreLabel.setX(20);
        scoreLabel.setY(600);
        stage.addActor(scoreLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new ButtonClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
                scoreLabel.setText("Points: " + String.valueOf(game.getPoints()));
            }
        });

        stage.addActor(playerButton);


    }

    private void initResetScoreButton() {
        resetScoreButon = new Button(new Button.ButtonStyle());
        resetScoreButon.setWidth(100);
        resetScoreButon.setHeight(100);
        resetScoreButon.setX(330);
        resetScoreButon.setY(500);
        resetScoreButon.setDebug(true);

        stage.addActor(resetScoreButon);

        resetScoreButon.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                game.resetScore();

                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();

    }

    private void update() {

        stage.act();
    }
}
