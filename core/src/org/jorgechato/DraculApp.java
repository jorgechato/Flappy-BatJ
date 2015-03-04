package org.jorgechato;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jorgechato.managers.ResourceManager;

public class DraculApp extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
        ResourceManager.loadRes();
        setScreen(new Juego());
	}

	@Override
	public void render () {
        super.render();
	}
}
