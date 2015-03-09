package org.jorgechato;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;
import org.jorgechato.screens.MainMenu;

public class DraculApp extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	Texture img;
    Skin skin;

	@Override
	public void create () {
        ResourceManager.loadRes();
        //new main menu
        setScreen(new MainMenu(this));
//        setScreen(new Game());
	}

	@Override
	public void render () {
        super.render();
	}

    public Skin getSkin() {
        if (skin == null)
            skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        return skin;
    }
}
