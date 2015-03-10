package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;
import org.jorgechato.util.Constants;

/**
 * Created by Orggue on 08/03/15.
 */
public class Pokeball {
    public static Rectangle rectangle;
    public Sprite sprite;
    float vx = 300;

    public Pokeball() {
        this.rectangle = new Rectangle(Gdx.graphics.getWidth(),112*Constants.scale, 35*Constants.scale,35* Constants.scale*4);
        sprite = new Sprite(ResourceManager.getTexture("pokeball"));
        sprite.setSize(35* Constants.scale, 35* Constants.scale);
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
}
