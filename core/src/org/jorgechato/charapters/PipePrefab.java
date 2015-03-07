package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;

import java.util.Random;


/**
 * Created by Orggue on 07/03/15.
 */
public class PipePrefab {
    float vx = 300;
    Sprite up, down;
    public Rectangle rUp, rDown;
    short scale = 1;

    public PipePrefab() {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        rDown = new Rectangle(Gdx.graphics.getWidth() , -160, 208, 320*scale);
        rUp = new Rectangle(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-160, 208, 320*scale);
        up = new Sprite(ResourceManager.getTexture("pipe"));
        up.flip(false,true);
        up.setSize(52*scale,320*scale);
        down = new Sprite(ResourceManager.getTexture("pipe"));
        down.setSize(52*scale,320*scale);
        up.setPosition(rUp.x, rUp.y);
        down.setPosition(rDown.x, rDown.y);
        randomPosition();
    }

    public void randomPosition(){
        Random ran = new Random();
        int equal = ran.nextInt(120)*scale;
        rDown.y = -equal-160;
        rUp.y = Gdx.graphics.getHeight()-160-equal;
    }

    public void draw(SpriteBatch sb){
        up.draw(sb);
        down.draw(sb);
        up.setPosition(rUp.x,rUp.y);
        down.setPosition(rDown.x,rDown.y);
    }

    public void update(float dt){
        rDown.x -= vx * dt;
        rUp.x -= vx * dt;
        if (rDown.x < -(52*scale))
            Game.pipePrefab.removeValue(this, false);
    }
}
