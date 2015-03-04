package org.jorgechato.charapters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;

/**
 * Created by Orggue on 04/03/15.
 */
public class Player {
    Rectangle rectangle;
    Sprite sprite;
    Animation animation;
    float vy,stateTime;

    public Player(Rectangle rectangle) {
        stateTime = 0;
        this.rectangle = rectangle;
        sprite = new Sprite();
        TextureRegion [] textureRegions = new TextureRegion[3];
        textureRegions[0] = new TextureRegion(ResourceManager.getTexture("bat1"));
        textureRegions[1] = new TextureRegion(ResourceManager.getTexture("bat2"));
        textureRegions[2] = new TextureRegion(ResourceManager.getTexture("bat3"));
        animation = new Animation(1/10f,textureRegions);
        sprite.setPosition(0,0);
    }

    public void update(float dt){
        stateTime += dt;
        sprite.setRegion(animation.getKeyFrame(stateTime));
        sprite.setSize(53,46);
    }

    public void draw(SpriteBatch sb){
        sprite.draw(sb);
    }
}
