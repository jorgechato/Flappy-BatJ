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
    short scale = 1;

    public Live(float x, float y) {
        if(Gdx.app.getType()== Application.ApplicationType.Android)
            scale = 4;

        sprite = new Sprite(ResourceManager.getTexture("live"));
        sprite.setSize(36*scale*.8f, 32*scale*.8f);
        sprite.setPosition(x,y);
    }


}
