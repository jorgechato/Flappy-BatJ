package org.jorgechato.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
public class Score implements Screen {
    Texture background, footer , score, gameOver,bestScore,oldScore;
    ImageButton play;
    SpriteBatch b;
    final DraculApp draculApp;
    Stage stage;
    static BitmapFont hightScore, myScore;

    public Score(DraculApp draculApp) {
        this.draculApp = draculApp;
    }

    @Override
    public void show() {
        hightScore = new BitmapFont(Gdx.files.internal("font/text.fnt"));
        hightScore.setScale(Constants.scale* .7f, Constants.scale* .7f);
        myScore = new BitmapFont(Gdx.files.internal("font/text.fnt"));
        myScore.setScale(Constants.scale * .35f, Constants.scale * .35f);

        background = ResourceManager.getTexture("background");
        footer = ResourceManager.getTexture("footer");
        score = ResourceManager.getTexture("score");
        gameOver = ResourceManager.getTexture("gameOver");
        bestScore = ResourceManager.getTexture("new");
        oldScore = ResourceManager.getTexture("old");

        play = new ImageButton(new TextureRegionDrawable(new TextureRegion(ResourceManager.getTexture("play"))));
        play.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                hightScore.dispose();
                myScore.dispose();
                draculApp.setScreen(new Game(draculApp));
            }
        });

        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        play.setPosition(Gdx.graphics.getWidth() * 0.5f - (104*Constants.scale * 0.5f), Gdx.graphics.getHeight() * 0.5f-114*Constants.scale*.5f-58*Constants.scale*.5f);
        play.setSize(104*Constants.scale,58*Constants.scale);
        b = new SpriteBatch();

        stage.addActor(play);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        delta = Gdx.graphics.getDeltaTime();
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stage.act();
        b.begin();
        b.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        b.draw(footer, 0, 0, Gdx.graphics.getWidth(), 112 * Constants.scale);
        b.draw(score,Gdx.graphics.getWidth() * 0.5f - (227*Constants.scale*0.5f), Gdx.graphics.getHeight() * 0.5f,227*Constants.scale,114*Constants.scale);
        b.draw(gameOver,Gdx.graphics.getWidth() * 0.5f - (192*Constants.scale*0.5f),Gdx.graphics.getHeight() - (42*Constants.scale*3),192*Constants.scale,42*Constants.scale);
        hightScore.draw(b, "" + ResourceManager.getHighScore(), Gdx.graphics.getWidth()*0.5f-(hightScore.getXHeight()*0.5f),Gdx.graphics.getHeight()* 0.5f+114*Constants.scale-hightScore.getScaleY()*Constants.scale*4);
        myScore.draw(b, "" + Constants.score, Gdx.graphics.getWidth()*0.5f-(myScore.getXHeight()*0.5f),Gdx.graphics.getHeight()* 0.5f+114*Constants.scale*.25f);
        b.draw(oldScore,Gdx.graphics.getWidth() * 0.5f - (227*Constants.scale*0.5f)+14*Constants.scale, Gdx.graphics.getHeight() * 0.5f+114*Constants.scale-28*Constants.scale,32*Constants.scale,14*Constants.scale);
        if (ResourceManager.getHighScore() == Constants.score)
            b.draw(bestScore,Gdx.graphics.getWidth() * 0.5f - (227*Constants.scale*0.5f)+14*Constants.scale, Gdx.graphics.getHeight() * 0.5f+14*Constants.scale,32*Constants.scale,14*Constants.scale);
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
