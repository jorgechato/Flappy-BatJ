package org.jorgechato.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import org.jorgechato.DraculApp;
import org.jorgechato.charapters.Player;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.util.Constants;

/**
 * Created by Orggue on 09/03/15.
 */
public class MainMenu implements Screen {
    Texture background, footer, tap;
    ImageButton play,score;
    SpriteBatch b;
    final DraculApp draculApp;
    Stage stage;
    Player player;

    public MainMenu(DraculApp draculApp) {
        this.draculApp = draculApp;
    }

    @Override
    public void show() {
        player = new Player();
        background = ResourceManager.getTexture("background");
        footer = ResourceManager.getTexture("footer");
        tap = ResourceManager.getTexture("tap");
        play = new ImageButton(new TextureRegionDrawable(new TextureRegion(ResourceManager.getTexture("play"))));
        score = new ImageButton(new TextureRegionDrawable(new TextureRegion(ResourceManager.getTexture("btscore"))));

        play.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                stage.dispose();
                draculApp.setScreen(new Game(draculApp));
            }
        });
        score.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                stage.dispose();
                draculApp.setScreen(new Score(draculApp));
            }
        });

        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        play.setSize(104*Constants.scale,58*Constants.scale);
        score.setSize(104*Constants.scale,58*Constants.scale);
        play.setPosition(Gdx.graphics.getWidth() * 0.5f - (play.getHeight()*0.85f), Gdx.graphics.getHeight() * 0.4f);
        score.setPosition(Gdx.graphics.getWidth() * 0.5f - (score.getHeight()*0.85f), Gdx.graphics.getHeight() * 0.4f-play.getHeight()-2* Constants.scale);
        b = new SpriteBatch();

        stage.addActor(play);
        stage.addActor(score);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        delta = Gdx.graphics.getDeltaTime();
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.act();
        player.instructionUpdate(delta);
        b.begin();
        b.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        b.draw(footer, 0, 0, Gdx.graphics.getWidth(), 112 * Constants.scale);
        b.draw(tap, Gdx.graphics.getWidth() * 0.5f - ( 114 * Constants.scale*0.5f), Gdx.graphics.getHeight() * 0.5f + (Gdx.graphics.getWidth() * 0.15f), 114 * Constants.scale, 60 * Constants.scale);
        player.instructionDraw(b);
        b.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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
