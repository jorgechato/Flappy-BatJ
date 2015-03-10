package org.jorgechato.charapters;

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
 * Created by Orggue on 10/03/15.
 */
public class Shut {
    public Rectangle rectangle;
    public Sprite sprite;
    float stateTime,vy = 2500;
    Animation animation;
    TextureRegion[] textureRegions;

    public Shut() {
        stateTime = 0;
        rectangle = new Rectangle(Gdx.graphics.getWidth()*0.5f-Gdx.graphics.getWidth()*0.18f+Player.rectangle.getWidth()*.25f,112*Constants.scale-80*Constants.scale,48* Constants.scale,80*Constants.scale);

//        sprite = new Sprite();
//        textureRegions = new TextureRegion[4];
//        textureRegions[0] = new TextureRegion(ResourceManager.getTexture("shut0"));
//        textureRegions[1] = new TextureRegion(ResourceManager.getTexture("shut1"));
//        textureRegions[2] = new TextureRegion(ResourceManager.getTexture("shut2"));
//        textureRegions[3] = new TextureRegion(ResourceManager.getTexture("shut3"));
//        animation = new Animation(1/7f,textureRegions);
//        animation.setPlayMode(Animation.PlayMode.LOOP_REVERSED);
        sprite = new Sprite(ResourceManager.getTexture("shut3"));
        sprite.setSize(48* Constants.scale,80*Constants.scale);
        sprite.setPosition(rectangle.x, rectangle.y);
    }

    public void update(float dt){
//        stateTime += dt;
//        sprite.setRegion(animation.getKeyFrame(stateTime));
        rectangle.y += vy * dt;
        if (rectangle.y > Gdx.graphics.getHeight()+rectangle.getHeight())
            Game.shut.removeValue(this, false);
    }

    public void draw(SpriteBatch sb){
        sprite.draw(sb);
        sprite.setPosition(rectangle.x,rectangle.y);
    }

    public void destroy(){
        Game.shut.removeValue(this, false);
    }
}
