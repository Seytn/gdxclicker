package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.controllers.NutsController;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.PlayerButton;
import com.mygdx.game.ui.ResetScoreButton;
import com.mygdx.game.ui.SimpleLabel;
import com.mygdx.game.ui.ClickCallback;

/**
 * Created by Kamil on 2016-08-09.
 */
public class GameplayScreen extends AbstractScreen{

    private Image backgroundImg;
    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButon;
    private SimpleLabel scoreLabel;
    private SimpleLabel fearLabel;
    private NutsController nutsController;

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
        initFearlabel();
        initNutsController();
        initMusic();
    }

    private void initMusic() {
        game.getSoundService().playMusic();
    }

    private void initNutsController() {
        nutsController = new NutsController(game, stage);

    }

    private void initBackground() {
        backgroundImg = new Image(new Texture("background_gameplay.png"));

        stage.addActor(backgroundImg);
    }


    private void initScoreLabel() {
        scoreLabel = new SimpleLabel("Points: " + String.valueOf(game.getScoreService().getPoints()));

        stage.addActor(scoreLabel);
    }

    private void initFearlabel() {
        fearLabel = new SimpleLabel("Fear: " + String.valueOf(game.getScoreService().getFear()));
        fearLabel.setY(630);

        stage.addActor(fearLabel);
    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new ClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.getSoundService().playPlayerClickSound();
                game.getScoreService().addPoint();
                updateLabels();
            }
        });

        stage.addActor(playerButton);


    }

    private void initResetScoreButton() {
        resetScoreButon = new ResetScoreButton(new ClickCallback() {
            @Override
            public void onClick() {
                game.getScoreService().resetScore();
                updateLabels();
            }
        });

        stage.addActor(resetScoreButon);

    }

    private void initPlayer() {
        player = new Player(game);
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


    public void updateLabels() {
        scoreLabel.setText("Points: " + String.valueOf(game.getScoreService().getPoints()));
        fearLabel.setText("Fear: " + String.valueOf(game.getScoreService().getFear()));
    }

    private void update() {
        updateLabels();
        stage.act();
    }
}
