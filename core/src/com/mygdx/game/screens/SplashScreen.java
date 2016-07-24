package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ClickerGdxGame;

/**
 * Created by Kamil on 2016-07-24.
 */
public class SplashScreen extends AbstractScreen {

        private Texture splashImg;

    public SplashScreen(ClickerGdxGame game) {
        super(game);
        init();
    }

    private void init() {
        //TODO implement assets manager
        splashImg = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);


        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
