package com.mygdx.game.screens;

import com.mygdx.game.ClickerGdxGame;
import com.mygdx.game.entities.Player;

/**
 * Created by Kamil on 2016-08-09.
 */
public class GameplayScreen extends AbstractScreen{

    private Player player;

    public GameplayScreen(ClickerGdxGame game) {
        super(game);

        initPlayer();
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
