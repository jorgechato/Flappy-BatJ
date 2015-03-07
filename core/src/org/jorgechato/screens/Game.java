package org.jorgechato.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import org.jorgechato.charapters.PipePrefab;
import org.jorgechato.charapters.Player;
import org.jorgechato.managers.ResourceManager;


public class Game implements Screen{
    SpriteBatch b;
    Player player;
    Texture background;
    Texture footer;
    public static Array<PipePrefab> pipePrefab;
    ShapeRenderer shapeRenderer;
    short scale = 1;

    @Override
    public void show() {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        b = new SpriteBatch();
        player = new Player(new Rectangle(Gdx.graphics.getWidth()*0.5f,Gdx.graphics.getHeight()*0.5f, 53,46));
        background = ResourceManager.getTexture("background");
        footer = ResourceManager.getTexture("footer");
        pipePrefab = new Array<>();
        shapeRenderer = new ShapeRenderer();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                pipePrefab.add(new PipePrefab());
            }
        },1,3);
    }

    @Override
    public void render(float delta) {
        delta = Gdx.graphics.getDeltaTime();
        player.update(delta);
        for (PipePrefab pipePrefab1 : pipePrefab)
            pipePrefab1.update(delta);
        colision();
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        b.begin();
        b.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        for (PipePrefab pipePrefab1 : pipePrefab)
            pipePrefab1.draw(b);
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            b.draw(footer, 0, -112, Gdx.graphics.getWidth(), 112 * scale);
        else
            b.draw(footer, 0, -112, Gdx.graphics.getWidth(), 112 * scale);
        player.draw(b);
        b.end();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.setProjectionMatrix(b.getProjectionMatrix());
        shapeRenderer.begin();
        for (PipePrefab pipePrefab1 : pipePrefab) {
            shapeRenderer.rect(0,0,pipePrefab1.rDown.x,pipePrefab1.rDown.y);
            shapeRenderer.rect(0,0,pipePrefab1.rUp.x,pipePrefab1.rUp.y);
            shapeRenderer.rect(0,0,player.rectangle.x,player.rectangle.y);
        }
        shapeRenderer.end();
    }

    private void colision() {
        for (PipePrefab pipePrefab1 : pipePrefab){
            if (pipePrefab1.rUp.overlaps(player.rectangle) || pipePrefab1.rDown.overlaps(player.rectangle)
                    || player.rectangle.y < 112*scale-112 || player.rectangle.y > Gdx.graphics.getHeight()){
                player.died(new Rectangle(Gdx.graphics.getWidth()*0.5f,Gdx.graphics.getHeight()*0.5f, 53,46));
            }
        }
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
