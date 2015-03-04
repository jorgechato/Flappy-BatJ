package org.jorgechato.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Created by Orggue on 04/03/15.
 */
public class ResourceManager {
    static HashMap<String,Texture> textures;

    public static void loadRes(){
        textures = new HashMap<>();
        textures.put("bat1", new Texture(Gdx.files.internal("textures/bat1.png")));
        textures.put("bat2", new Texture(Gdx.files.internal("textures/bat2.png")));
        textures.put("bat3", new Texture(Gdx.files.internal("textures/bat3.png")));
    }

    public static Texture getTexture(String key){
        return textures.get(key);
    }
}
