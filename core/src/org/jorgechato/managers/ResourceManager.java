package org.jorgechato.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Created by Orggue on 04/03/15.
 */
public class ResourceManager {
    static HashMap<String,Texture> textures;
    static HashMap<String, Sound> sound;
    public static Preferences prefs;


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
        textures.put("play", new Texture(Gdx.files.internal("textures/play.png")));
        textures.put("tap", new Texture(Gdx.files.internal("textures/instructions.png")));
        textures.put("score", new Texture(Gdx.files.internal("textures/score.png")));
        textures.put("btscore", new Texture(Gdx.files.internal("textures/btscore.png")));
        textures.put("live", new Texture(Gdx.files.internal("textures/live.png")));
        textures.put("dead", new Texture(Gdx.files.internal("textures/dead.png")));
        textures.put("gameOver", new Texture(Gdx.files.internal("textures/game_over.png")));
        textures.put("new", new Texture(Gdx.files.internal("textures/new.png")));
        textures.put("old", new Texture(Gdx.files.internal("textures/old.png")));
        textures.put("shut0", new Texture(Gdx.files.internal("textures/shut0.png")));
        textures.put("shut1", new Texture(Gdx.files.internal("textures/shut1.png")));
        textures.put("shut2", new Texture(Gdx.files.internal("textures/shut2.png")));
        textures.put("shut3", new Texture(Gdx.files.internal("textures/shut3.png")));
        textures.put("music", new Texture(Gdx.files.internal("textures/music.png")));
        textures.put("save", new Texture(Gdx.files.internal("textures/save.png")));
        textures.put("noMusic", new Texture(Gdx.files.internal("textures/no_music.png")));
        textures.put("noSave", new Texture(Gdx.files.internal("textures/no_save.png")));

        sound = new HashMap<>();
        sound.put("hit", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_hit.ogg")));
        sound.put("point", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_point.ogg")));
        sound.put("swooshing", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_swooshing.ogg")));
        sound.put("die", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_die.ogg")));
        sound.put("wing", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx_wing.ogg")));

        prefs = Gdx.app.getPreferences("Flappy_BatJ");
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }

        prefs = Gdx.app.getPreferences("isMusic");
        if (!prefs.contains("isMusic")) {
            prefs.putBoolean("isMusic", true);
        }

        prefs = Gdx.app.getPreferences("isSave");
        if (!prefs.contains("isSave")) {
            prefs.putBoolean("isSave", true);
        }
    }

    public static Texture getTexture(String key){
        return textures.get(key);
    }

    public static Sound getSound(String key){
        return sound.get(key);
    }

    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    public static void setSave(boolean val) {
        prefs.putBoolean("isSave", val);
        prefs.flush();
    }

    public static void setMusic(boolean val) {
        prefs.putBoolean("isMusic", val);
        prefs.flush();
    }

    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }

    public static boolean isSave() {
        return prefs.getBoolean("isSave");
    }
    public static boolean isMusic() {
        return prefs.getBoolean("isMusic");
    }

}
