package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.ClickerGdxGame;

/**
 * Created by Kamil on 2016-07-24.
 */
public class SplashScreen extends AbstractScreen {

        private Texture splashImg;
        private Button button;

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
        button = new Button();
        button.setWidth(ClickerGdxGame.WIDTH);
        button.setHeight(ClickerGdxGame.HEIGHT);
        button.setX(0);
        button.setY(0);
        button.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameplayScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(button);
    }

    @Override
    public void render(float delta) {
        super.render(delta);


        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
