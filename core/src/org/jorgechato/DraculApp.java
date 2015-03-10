package org.jorgechato;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;
import org.jorgechato.screens.MainMenu;

public class DraculApp extends com.badlogic.gdx.Game {
	@Override
	public void create () {
        ResourceManager.loadRes();
        setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
        super.render();
	}
}
