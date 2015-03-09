package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;

/**
 * Created by Orggue on 07/03/15.
 */
public class Bullet {
    public Rectangle rectangle;
    Sprite sprite;
    float stateTime,vx = 550;
    short scale = 1;

    public Bullet() {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        this.rectangle = new Rectangle(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), 53*scale,46*scale);
        stateTime = 0;
        sprite = new Sprite(ResourceManager.getTexture("bullet"));
        sprite.setSize(rectangle.width*0.7f, rectangle.height*0.7f);
        sprite.setX(rectangle.x);
        sprite.setY(rectangle.y);
        random();
    }

    private void random() {
        RandomXS128 ran = new RandomXS128();
        rectangle.y -= ran.nextInt(Gdx.graphics.getHeight()-(120+53*scale))-53*scale;
    }

    public void draw(SpriteBatch sb){
        sprite.draw(sb);
        sprite.setPosition(rectangle.x,rectangle.y);
    }

    public void update(float dt){
        rectangle.x -= vx * dt;
        if (rectangle.x < -(52*scale))
            Game.bullet.removeValue(this, false);
    }

    public void destroy(){
        Game.bullet.removeValue(this, false);
    }
}
