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

    public final static String DIALOG_TEXTURE = "dialog.png";

    private final static int WIDTH = 350;
    private final static int HEIGHT = 70;

    private final static int STARTING_X = 50;
    private final static int STARTING_Y = 400;

    SimpleLabel label;
    Stage stage;

    public SimpleEventDialog(Stage stage) {
        super(new Texture(DIALOG_TEXTURE));

        this.stage = stage;
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);

        init();

    }

    private void init() {
        label = new SimpleLabel("");
        label.setPosition(STARTING_X + 30, STARTING_Y + 5);


        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                fadeOutDialog();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    public void showMessage(String text) {
        stage.addActor(this);
        label.setText(text);
        label.setFontScale(1.2f);
        this.getStage().addActor(label);
    }

    public void fadeOutDialog() {
        Action disapear = Actions.sequence(
                Actions.fadeOut(0.3f),
                new Action() {
                    @Override
                    public boolean act(float delta) {
                        SimpleEventDialog.this.remove();
                        label.remove();
                        return false;
                    }
                }
        );
        this.addAction(disapear);
        label.addAction(Actions.fadeOut(0.3f));
    }
}
