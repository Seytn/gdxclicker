package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ClickerGdxGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = ClickerGdxGame.GAME_NAME;
        config.width = ClickerGdxGame.WIDTH;
        config.height = ClickerGdxGame.HEIGHT;
        config.resizable = false;

        new LwjglApplication(new ClickerGdxGame(), config);
    }
}
