package org.jorgechato.charapters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import org.jorgechato.managers.ResourceManager;

/**
 * Created by Orggue on 07/03/15.
 */
public class Bullet {
    Rectangle rectangle;
    Sprite sprite;
    float vy,stateTime;
    TextureRegion[] textureRegions;

    public Bullet(Rectangle rectangle) {
        stateTime = 0;
        this.rectangle = rectangle;
        sprite = new Sprite();
        textureRegions = new TextureRegion[1];
        textureRegions[0] = new TextureRegion(ResourceManager.getTexture("bullet"));
    }
}
