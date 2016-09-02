package com.mygdx.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Kamil on 2016-09-02.
 */
public class ResumeGameButton extends Button{

    public ResumeGameButton(final ClickCallback callback){
        super(new Button.ButtonStyle(prepareResetButtonStyle()));

        init(callback);
    }

    private void init(final ClickCallback callback) {
        this.setWidth(200);
        this.setHeight(90);
        this.setX(170);
        this.setY(400);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                callback.onClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private static Button.ButtonStyle prepareResetButtonStyle() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("game_resume.atlas"));
        Skin skin = new Skin(atlas);
        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        buttonStyle.up = skin.getDrawable("button_01");
        buttonStyle.down = skin.getDrawable("button_02");

        return buttonStyle;
    }
}
