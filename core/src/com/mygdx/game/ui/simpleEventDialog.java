package com.mygdx.game.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Kamil on 2016-08-19.
 */
public class SimpleEventDialog extends Image {

    public final static String DIALOG_START_GAME = "dialog_start_game.png";
    public final static String DIALOG_LOSE_POINTS = "dialog_lose_points.png";
    public static final String DIALOG_NO_FEAR = "dialog_no_fear.png";

    private final static int WIDTH = 350;

    private final static int HEIGHT = 100;
    private final static int STARTING_X = 50;
    private final static int STARTING_Y = 400;

    Stage stage;


    public SimpleEventDialog(Stage stage, String textureType) {
        super(new Texture(textureType));

        this.stage = stage;
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);

        init();

    }

    private void init() {

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                fadeOutDialog(0.5f);

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }


    public void fadeOutDialog(float v) {
        Action disappear = Actions.sequence(
                Actions.fadeOut(v),
                new Action() {
                    @Override
                    public boolean act(float delta) {
                        SimpleEventDialog.this.remove();
                        return false;
                    }
                }
        );
        this.addAction(disappear);
    }
}
