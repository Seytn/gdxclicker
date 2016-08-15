package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.entities.NutsObject;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.ButtonClickCallback;
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
        nut = new NutsObject(NutsObject.NUT);
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
        resetScoreButon = new ResetScoreButton(new ButtonClickCallback() {
            @Override
            public void onClick() {
                game.resetScore();
                scoreLabel.setText("Points: " + String.valueOf(game.getPoints()));
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

    private void update() {

        stage.act();
    }
}
