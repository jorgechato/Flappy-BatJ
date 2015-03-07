package org.jorgechato;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;

public class DraculApp extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
        ResourceManager.loadRes();
        setScreen(new Game());
	}

	@Override
	public void render () {
        super.render();
	}
}
