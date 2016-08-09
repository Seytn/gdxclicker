package com.mygdx.game.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.entities.Player;

/**
 * Created by Kamil on 2016-08-09.
 */
public class GameplayScreen extends AbstractScreen{

    private Player player;
    private Button playerButton;

    public GameplayScreen(ClickerGdxGame game) {
        super(game);

        initPlayer();
        initPlayerButton();
    }

    private void initPlayerButton() {
        playerButton = new Button(new Button.ButtonStyle());
        playerButton.setWidth(460);
        playerButton.setHeight(360);
        playerButton.setX(10);
        playerButton.setY(170);
        playerButton.setDebug(true);

        stage.addActor(playerButton);

        playerButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    @Override
    protected void init() {

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
