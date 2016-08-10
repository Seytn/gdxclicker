package com.mygdx.game.ui;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Kamil on 2016-08-10.
 */
public class ResetScoreButton extends Button {
    public ResetScoreButton(final ButtonClickCallback callback) {
        super(new ButtonStyle());

        init(callback);

    }

    private void init(final ButtonClickCallback callback) {
        this.setWidth(100);
        this.setHeight(100);
        this.setX(330);
        this.setY(500);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                callback.onClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

}
