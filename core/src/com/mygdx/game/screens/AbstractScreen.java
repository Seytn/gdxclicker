package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.ClickerGdxGame;

/**
 * Created by Kamil on 2016-07-24.
 */
public abstract class AbstractScreen implements Screen {
    
    protected ClickerGdxGame game;
    
    protected Stage stage;
    private OrthographicCamera camera;
    
    protected SpriteBatch spriteBatch;
    
    public AbstractScreen(ClickerGdxGame game){
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(ClickerGdxGame.WIDTH,ClickerGdxGame.HEIGHT,camera));

        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }

    protected abstract void init();

    private void createCamera(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, ClickerGdxGame.WIDTH,ClickerGdxGame.HEIGHT);
        camera.update();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void show() {

    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
        game.getScoreService().updateSavedScore();
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }
}
