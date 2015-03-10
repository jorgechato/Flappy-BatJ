package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;
import org.jorgechato.util.Constants;

/**
 * Created by Orggue on 08/03/15.
 */
public class Pokeball {
    public Rectangle rectangle;
    Sprite sprite;
    float stateTime,vx = 300;

    public Pokeball() {
        this.rectangle = new Rectangle(Gdx.graphics.getWidth(),112*Constants.scale, 35*Constants.scale,35* Constants.scale);
        stateTime = 0;
        sprite = new Sprite(ResourceManager.getTexture("pokeball"));
        sprite.setSize(rectangle.width, rectangle.height);
        sprite.setX(rectangle.x);
        sprite.setY(rectangle.y);
    }

    public void draw(SpriteBatch sb){
        sprite.draw(sb);
        sprite.setPosition(rectangle.x,rectangle.y);
    }

    public void update(float dt){
        rectangle.x -= vx * dt;
        if (rectangle.x < -(52*Constants.scale))
            Game.pokeball.removeValue(this, false);
    }

    public void destroy(){
        Game.pokeball.removeValue(this, false);
    }
}
