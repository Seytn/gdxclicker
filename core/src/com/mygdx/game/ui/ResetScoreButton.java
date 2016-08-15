package com.mygdx.game.ui;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Kamil on 2016-08-10.
 */
public class ResetScoreButton extends Button {
    public ResetScoreButton(final clickCallback callback) {
        super(new ButtonStyle(prepareResetButtonStyle()));

        init(callback);

    }

    private void init(final clickCallback callback) {
        this.setWidth(100);
        this.setHeight(100);
        this.setX(370);
        this.setY(670);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                callback.onClick();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private static ButtonStyle prepareResetButtonStyle() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("ui-orange.atlas"));
        Skin skin = new Skin(atlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("color_lightwidgettext");
        buttonStyle.down = skin.getDrawable("button_01");

        return buttonStyle;
    }

}
