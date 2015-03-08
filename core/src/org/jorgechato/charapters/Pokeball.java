package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;

/**
 * Created by Orggue on 08/03/15.
 */
public class Pokeball {
    public Rectangle rectangle;
    Sprite sprite;
    float stateTime,vx = 300;
    short scale = 1;

    public Pokeball() {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        this.rectangle = new Rectangle(Gdx.graphics.getWidth(),112*scale-122, 35*scale,35*scale);
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
        if (rectangle.x < -(52*scale))
            Game.pokeball.removeValue(this, false);
    }

    public void destroy(){
        Game.pokeball.removeValue(this, false);
    }
}
