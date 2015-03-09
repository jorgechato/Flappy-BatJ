package org.jorgechato.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import org.jorgechato.DraculApp;
import org.jorgechato.managers.ResourceManager;

/**
 * Created by Orggue on 09/03/15.
 */
public class MainMenu implements Screen {
    Texture background, footer;
    ImageButton play;
    short scale = 1;
    SpriteBatch b;
    final DraculApp draculApp;
    Stage stage;

    public MainMenu(DraculApp draculApp) {
        this.draculApp = draculApp;
    }

    @Override
    public void show() {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        background = ResourceManager.getTexture("background");
        footer = ResourceManager.getTexture("footer");
        play = new ImageButton(new TextureRegionDrawable(new TextureRegion(ResourceManager.getTexture("play"))));
        play.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                draculApp.setScreen(new Game(draculApp));
            }
        });
        stage = new Stage();
        stage.addActor(play);
        play.setWidth(105 * scale);
        play.setHeight(60 * scale);
        play.setPosition(Gdx.graphics.getWidth() * 0.5f - (105 * scale), Gdx.graphics.getHeight() * 0.5f);
        b = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
//        delta = Gdx.graphics.getDeltaTime();
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.act();
        b.begin();
        b.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        b.draw(footer, 0, -112, Gdx.graphics.getWidth(), 112 * scale);
        stage.draw();
        b.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
