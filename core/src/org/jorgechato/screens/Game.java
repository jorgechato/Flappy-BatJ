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
import org.jorgechato.DraculApp;
import org.jorgechato.charapters.Bullet;
import org.jorgechato.charapters.PipePrefab;
import org.jorgechato.charapters.Player;
import org.jorgechato.charapters.Pokeball;
import org.jorgechato.managers.ResourceManager;


public class Game implements Screen{
    SpriteBatch b;
    Player player;
    Texture background;
    public Texture footer;
    public static Array<PipePrefab> pipePrefab;
    public static Array<Bullet> bullet;
    public static Array<Pokeball> pokeball;
    ShapeRenderer shapeRenderer;
    short scale = 1;
    public int score = 0;
    PipePrefab pipePrefabOld;
    final DraculApp draculApp;
    int bulletLevel = 8;

    public Game(DraculApp draculApp) {
        this.draculApp = draculApp;
        Timer.instance().clear();
    }

    @Override
    public void show() {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        b = new SpriteBatch();
        player = new Player(new Rectangle(Gdx.graphics.getWidth()*0.5f-Gdx.graphics.getWidth()*0.18f,Gdx.graphics.getHeight()*0.5f+Gdx.graphics.getHeight()*0.25f, 53,46));
        background = ResourceManager.getTexture("background");
        footer = ResourceManager.getTexture("footer");

        pipePrefab = new Array<>();
        bullet = new Array<>();
        pokeball = new Array<>();

        shapeRenderer = new ShapeRenderer();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                pipePrefab.add(new PipePrefab());
            }
        },1,3);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                bullet.add(new Bullet());
            }
        },5,bulletLevel);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                pokeball.add(new Pokeball());
            }
        },2.5f,12);
    }

    @Override
    public void render(float delta) {
        delta = Gdx.graphics.getDeltaTime();
        player.update(delta);
        for (PipePrefab pipePrefab1 : pipePrefab)
            pipePrefab1.update(delta);
        for (Bullet bullet1 : bullet)
            bullet1.update(delta);
        for (Pokeball pokeball1 : pokeball)
            pokeball1.update(delta);
        colision();
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        b.begin();
        b.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        for (PipePrefab pipePrefab1 : pipePrefab)
            pipePrefab1.draw(b);
        for (Bullet bullet1 : bullet)
            bullet1.draw(b);

        b.draw(footer, 0, -112, Gdx.graphics.getWidth(), 112 * scale);

        for (Pokeball pokeball1 : pokeball)
            pokeball1.draw(b);

        player.draw(b);
        b.end();
        /*
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();
        for (PipePrefab pipePrefab1 : pipePrefab) {
            shapeRenderer.rect(0,0,pipePrefab1.rDown.x,pipePrefab1.rDown.y);
            shapeRenderer.rect(0,0,pipePrefab1.rUp.x,pipePrefab1.rUp.y);
            shapeRenderer.rect(0,0,player.rectangle.x,player.rectangle.y);
        }
        shapeRenderer.end();*/
    }

    private void colision() {
        for (PipePrefab pipePrefab1 : pipePrefab){
            if (pipePrefab1.rUp.overlaps(player.rectangle) || pipePrefab1.rDown.overlaps(player.rectangle)
                    || player.rectangle.y < 112*scale-112 || player.rectangle.y > Gdx.graphics.getHeight()){
                player.died();
                dispose();
                draculApp.setScreen(new MainMenu(draculApp));
            }else if (pipePrefab1.plusScore.overlaps(player.rectangle) && !pipePrefab1.equals(pipePrefabOld)) {
                score++;
                ResourceManager.getSound("point").play();
                pipePrefabOld = pipePrefab1;
                if (score % 5 == 0){
                    if (bulletLevel > 1)
                        bulletLevel = 1;
                }
            }
        }

        for (Bullet bullet1 : bullet)
            if (bullet1.rectangle.overlaps(player.rectangle)){
                player.soundPlayer("hit");
                bullet1.destroy();
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
