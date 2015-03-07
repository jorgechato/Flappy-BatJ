package org.jorgechato.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Created by Orggue on 04/03/15.
 */
public class ResourceManager {
    static HashMap<String,Texture> textures;
    static HashMap<String, Sound> sound;

    public static void loadRes(){
        textures = new HashMap<>();
        textures.put("background", new Texture(Gdx.files.internal("textures/background.png")));
        textures.put("footer", new Texture(Gdx.files.internal("textures/footer.png")));
        textures.put("bat1", new Texture(Gdx.files.internal("textures/bat1.png")));
        textures.put("bat2", new Texture(Gdx.files.internal("textures/bat2.png")));
        textures.put("bat3", new Texture(Gdx.files.internal("textures/bat3.png")));
        textures.put("bullet", new Texture(Gdx.files.internal("textures/bullet.png")));
        textures.put("pokeball", new Texture(Gdx.files.internal("textures/pokeball.png")));
        textures.put("pipe", new Texture(Gdx.files.internal("textures/pipe.png")));

        sound = new HashMap<>();
        sound.put("hit", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_hit.ogg")));
        sound.put("point", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_point.ogg")));
        sound.put("swooshing", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_swooshing.ogg")));
        sound.put("die", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_die.ogg")));
        sound.put("wing", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_wing.ogg")));
    }

    public static Texture getTexture(String key){
        return textures.get(key);
    }

    public static Sound getSound(String key){
        return sound.get(key);
    }
}
