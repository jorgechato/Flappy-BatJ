package org.jorgechato.util;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import org.jorgechato.managers.ResourceManager;

/**
 * Created by Orggue on 08/03/15.
 */
public class Live {
    public Sprite sprite;

    public Live(float x, float y) {
        sprite = new Sprite(ResourceManager.getTexture("live"));
        sprite.setSize(36*Constants.scale*.8f, 32*Constants.scale*.8f);
        sprite.setPosition(x,y);
    }


}
