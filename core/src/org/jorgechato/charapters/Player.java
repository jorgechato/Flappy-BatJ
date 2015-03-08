package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import org.jorgechato.managers.ResourceManager;

/**
 * Created by Orggue on 04/03/15.
 */
public class Player {
    public Rectangle rectangle;
    Sprite sprite;
    Animation animation;
    float vy,stateTime,gravity = 850;
    TextureRegion [] textureRegions;
    short scale = 1;
    long timePlayer;
    boolean jump, touched;

    public Player(Rectangle rectangle) {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        stateTime = 0;
        timePlayer = 0;
        this.rectangle = rectangle;
        sprite = new Sprite();
        textureRegions = new TextureRegion[3];
        textureRegions[0] = new TextureRegion(ResourceManager.getTexture("bat1"));
        textureRegions[1] = new TextureRegion(ResourceManager.getTexture("bat2"));
        textureRegions[2] = new TextureRegion(ResourceManager.getTexture("bat3"));
        animation = new Animation(1/7f,textureRegions);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        sprite.setPosition(this.rectangle.x,this.rectangle.y);
        sprite.setSize(53*scale, 46*scale);
    }

    public void update(float dt){
        stateTime += dt;
        sprite.setRegion(animation.getKeyFrame(stateTime));
        if (Gdx.input.isTouched()){
            if (!touched) {
                jump = true;
                timePlayer = TimeUtils.millis();
            }
            touched = true;
        }else {
            touched = false;
        }

        if (TimeUtils.millis()-timePlayer > 300)
            jump = false;

        if (jump) {
//            if (sprite.getRotation() < 30)
            sprite.setRotation(5);
            vy = gravity;
        }else{
//            if (sprite.getRotation() > -30)
            sprite.setRotation(-20);
            vy = -gravity;
        }

        if (vy < -gravity)
            vy = -gravity;
        if (vy > gravity)
            vy = gravity;

        rectangle.y += vy * dt;
    }

    public void draw(SpriteBatch sb){
        sprite.flip(true,false);
        sprite.draw(sb);
        sprite.setPosition(rectangle.x,rectangle.y);
    }

    public void died(Rectangle rectangle) {
        System.out.println("muerto");
        this.rectangle = rectangle;
    }
}
