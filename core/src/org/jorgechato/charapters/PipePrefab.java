package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.screens.Game;
import org.jorgechato.util.Constants;


/**
 * Created by Orggue on 07/03/15.
 */
public class PipePrefab {
    float vx = 300;
    Sprite up, down;
    public Rectangle rUp, rDown, plusScore;

    public PipePrefab() {
        rDown = new Rectangle(Gdx.graphics.getWidth() , -320*Constants.scale*0.5f, 52*Constants.scale+52*Constants.scale*.4f, 320*Constants.scale+320*Constants.scale*.4f);
        rUp = new Rectangle(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()-320*Constants.scale*0.5f, 52*Constants.scale+52*Constants.scale*.4f, 320*Constants.scale+320*Constants.scale*.4f);
        plusScore = new Rectangle(Gdx.graphics.getWidth()+(208*0.5f),0,1,Gdx.graphics.getHeight());
        up = new Sprite(ResourceManager.getTexture("pipe"));
        down = new Sprite(ResourceManager.getTexture("pipe"));
        up.flip(false,true);
        up.setSize(rUp.width, rUp.height);
        down.setSize(rDown.width, rDown.height);
        up.setX(rUp.x);
        up.setY(rUp.y);
        down.setX(rDown.x);
        down.setY(rDown.y);
        randomPosition();
    }

    public void randomPosition(){
        RandomXS128 ran = new RandomXS128();
        float equal = ran.nextInt((int) (120*Constants.scale));
        rDown.y = -equal-320* Constants.scale*0.5f;
        rUp.y = Gdx.graphics.getHeight()-equal-320*Constants.scale*0.5f;
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
        plusScore.x -= vx * dt;
        if (rDown.x < -(52*Constants.scale+52*Constants.scale*.4f))
            Game.pipePrefab.removeValue(this, false);
    }
}
