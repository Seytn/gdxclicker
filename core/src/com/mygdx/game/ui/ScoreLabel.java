package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Kamil on 2016-08-10.
 */
public class ScoreLabel extends Label{
    public ScoreLabel(CharSequence text) {
        super(text, new Label.LabelStyle(new BitmapFont(), Color.RED));

        init();


    }

    private void init() {
        this.setX(20);
        this.setY(600);
    }
}
