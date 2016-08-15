package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.entities.NutsObject;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.clickCallback;
import com.mygdx.game.ui.PlayerButton;
import com.mygdx.game.ui.ResetScoreButton;
import com.mygdx.game.ui.ScoreLabel;

/**
 * Created by Kamil on 2016-08-09.
 */
public class GameplayScreen extends AbstractScreen{

    private Image backgroundImg;
    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButon;
    private ScoreLabel scoreLabel;
    private NutsObject nut;

    public GameplayScreen(ClickerGdxGame game) {
        super(game);


    }

    @Override
    protected void init() {
        initBackground();
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScoreLabel();
        initNutsObjects();

    }

    private void initNutsObjects() {
        nut = new NutsObject(NutsObject.NutType.SIMPLE_NUT, game, new clickCallback() {
            @Override
            public void onClick() {
                nut.reactOnClick();
                updateScoreLabel();
            }
        });
        stage.addActor(nut);
        nut.tremble();
    }

    private void initBackground() {
        backgroundImg = new Image(new Texture("background_gameplay.png"));

        stage.addActor(backgroundImg);
    }

    private void initScoreLabel() {
        scoreLabel = new ScoreLabel("Points: " + String.valueOf(game.getPoints()));

        stage.addActor(scoreLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new clickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
                updateScoreLabel();
            }
        });

        stage.addActor(playerButton);


    }

    private void initResetScoreButton() {
        resetScoreButon = new ResetScoreButton(new clickCallback() {
            @Override
            public void onClick() {
                game.resetScore();
                updateScoreLabel();
            }
        });

        stage.addActor(resetScoreButon);

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


    private void updateScoreLabel() {
        scoreLabel.setText("Points: " + String.valueOf(game.getPoints()));
    }

    private void update() {

        stage.act();
    }
}
