package ghozti.deathstarrun.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Atlas {

    private static TextureAtlas ATLAS = new TextureAtlas(Gdx.files.internal("core/assets/assets.atlas"));// texture atlas instantiation and file path

    public static TextureRegion getBackground(){
        return ATLAS.findRegion("bg");
    }

    public static TextureRegion getHitbox(){
        return ATLAS.findRegion("hitbox");
    }

}
