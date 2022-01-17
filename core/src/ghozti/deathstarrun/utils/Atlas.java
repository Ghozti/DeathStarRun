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

    public static TextureRegion getSTARBG(){return ATLAS.findRegion("teamSelectorBG");}

    public static TextureRegion getTITLEBG(){return ATLAS.findRegion("title");}

    public static TextureRegion getHitbox(){
        return ATLAS.findRegion("hitbox");
    }

    public static TextureRegion getX_WING_BLUE(){return ATLAS.findRegion("xwing");}

    public static TextureRegion getX_WING_GOLD(){return ATLAS.findRegion("xwingGold");}

    public static TextureRegion getX_WING_GREEN(){return ATLAS.findRegion("xwingGreen");}

    public static TextureRegion getX_WING_ORANGE(){return ATLAS.findRegion("xwingOrange");}

    public static TextureRegion getX_WING_PURPLE(){return ATLAS.findRegion("xwingPurple");}

    public static TextureRegion getX_WING_RED(){return ATLAS.findRegion("xwingRed");}

    public static TextureRegion getEMPIRE_LOGO(){return ATLAS.findRegion("empire");}

    public static TextureRegion getREBEL_LOGO(){return ATLAS.findRegion("rebel");}

    public static TextureRegion getLEFT_ARROW1(){return ATLAS.findRegion("leftArrow1");}

    public static TextureRegion getLEFT_ARROW2(){return ATLAS.findRegion("leftArrow2");}

    public static TextureRegion getLEFT_ARROW3(){return ATLAS.findRegion("leftArrow3");}

    public static TextureRegion getRIGHT_ARROW1(){return ATLAS.findRegion("rightArrow1");}

    public static TextureRegion getRIGHT_ARROW2(){return ATLAS.findRegion("rightArrow2");}

    public static TextureRegion getRIGHT_ARROW3(){return ATLAS.findRegion("rightArrow3");}

    public static TextureRegion getPLAY_BUTTON(){return ATLAS.findRegion("pixil-frame-0 (3)");}

    public static TextureRegion getPLAY_BUTTON_HOVERED(){return ATLAS.findRegion("playHovered");}

    public static TextureRegion getX_WING_LASER(){return ATLAS.findRegion("xwingLaser");}

}
