package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.ClickerGdxGame;

/**
 * Created by Kamil on 2016-07-24.
 */
public class SplashScreen extends AbstractScreen {

        private Texture splashImg;

    public SplashScreen(final ClickerGdxGame game) {
        super(game);
        init();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new GameplayScreen(game));
            }
        },3);
    }
    @Override
    protected void init() {
        //TODO implement assets manager
        splashImg = new Texture("background_splash.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);


        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
