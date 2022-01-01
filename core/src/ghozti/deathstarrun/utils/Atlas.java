package ghozti.deathstarrun.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Atlas {

    /*
     * @AUTHOR
     * THIS CLASS IS AN UTILITY CLASS USED TO GET EACH TEXTURE REGION FROM THE TEXTURE ATLAS. IT IS MEAN TO MAKE IT EASIER TO GET THESE TEXTURES
     */

    private static TextureAtlas ATLAS = new TextureAtlas(Gdx.files.internal("core/assets/assets.atlas"));// texture atlas instantiation and file path

    public static TextureRegion getBackground(){
        return ATLAS.findRegion("bg");
    }

    public static TextureRegion getHitbox(){
        return ATLAS.findRegion("hitbox");
    }

    public static TextureRegion getX_WING(){return ATLAS.findRegion("xwing");}

}
