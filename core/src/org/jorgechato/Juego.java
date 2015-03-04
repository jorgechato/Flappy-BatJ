package org.jorgechato;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.charapters.Player;

public class Juego implements Screen{

    SpriteBatch b;
    Player player;

    @Override
    public void show() {
        b = new SpriteBatch();
        player = new Player(new Rectangle(0,0, 53,46));
    }

    @Override
    public void render(float delta) {
        delta = Gdx.graphics.getDeltaTime();
        player.update(delta);
        //todo limpiar pantalla
        b.begin();
        player.draw(b);
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
