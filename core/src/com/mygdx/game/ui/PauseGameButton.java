package com.mygdx.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Kamil on 2016-09-01.
 */
public class PauseGameButton extends Button{

    public PauseGameButton(final ClickCallback callback){
        super(new ButtonStyle(prepareResetButtonStyle()));

        init(callback);
    }
    private void init(final ClickCallback callback) {
        this.setWidth(200);
        this.setHeight(90);
        this.setX(30);
        this.setY(700);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                callback.onClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private static ButtonStyle prepareResetButtonStyle() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("game_pause.atlas"));
        Skin skin = new Skin(atlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("button_01");
        buttonStyle.down = skin.getDrawable("button_02");

        return buttonStyle;
    }
}
