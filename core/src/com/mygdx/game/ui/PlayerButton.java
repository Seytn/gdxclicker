package com.mygdx.game.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Kamil on 2016-08-10.
 */
public class PlayerButton extends Button {


    public PlayerButton(final ClickCallback callback) {
        super(new ButtonStyle());
        init(callback);

    }

    private void init(final ClickCallback callback) {
        this.setWidth(300);
        this.setHeight(300);
        this.setX(10);
        this.setY(10);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                callback.onClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
