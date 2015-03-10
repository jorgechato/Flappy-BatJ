package org.jorgechato.charapters;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import org.jorgechato.managers.ResourceManager;
import org.jorgechato.util.Constants;

/**
 * Created by Orggue on 04/03/15.
 */
public class Player {
    public Rectangle rectangle;
    Sprite sprite;
    Animation animation;
    float vy,stateTime,gravity = 850;
    TextureRegion [] textureRegions;
    long timePlayer;
    boolean jump, touched;

    public Player(Rectangle rectangle) {
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
        sprite.setPosition(this.rectangle.x, this.rectangle.y);
        sprite.setSize(53 * Constants.scale, 46 * Constants.scale);
    }

    public Player() {
        sprite = new Sprite();
        textureRegions = new TextureRegion[3];
        textureRegions[0] = new TextureRegion(ResourceManager.getTexture("bat1"));
        textureRegions[1] = new TextureRegion(ResourceManager.getTexture("bat2"));
        textureRegions[2] = new TextureRegion(ResourceManager.getTexture("bat3"));
        animation = new Animation(1/7f,textureRegions);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        sprite.setSize(53*Constants.scale, 46*Constants.scale);

        sprite.setPosition(Gdx.graphics.getWidth() * 0.5f - (sprite.getHeight() * 0.85f), Gdx.graphics.getHeight() * 0.4f);
    }

    public void update(float dt){
        stateTime += dt;
        sprite.setRegion(animation.getKeyFrame(stateTime));
        if (Gdx.input.isTouched()){
            if (!touched) {
                jump = true;
                timePlayer = TimeUtils.millis();
                soundPlayer("swooshing");
            }
            touched = true;
        }else {
            touched = false;
        }

        if (TimeUtils.millis()-timePlayer > 300)
            jump = false;

        if (jump) {
            sprite.setRotation(5);
            vy = gravity;
        }else{
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

    public void instructionDraw(SpriteBatch sb){
        sprite.flip(true,false);
        sprite.draw(sb);
        sprite.setPosition(Gdx.graphics.getWidth() * 0.5f - (Gdx.graphics.getWidth() * 0.10f), Gdx.graphics.getHeight() * 0.5f + (Gdx.graphics.getWidth() * 0.15f) + 80 * Constants.scale);
    }

    public void instructionUpdate(float dt){
        stateTime += dt;
        sprite.setRegion(animation.getKeyFrame(stateTime));
    }

    public void died() {
        soundPlayer("hit");
    }

    public void soundPlayer(String key){
        ResourceManager.getSound(key).play();
    }
}
