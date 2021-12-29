package ghozti.deathstarrun.utils;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameSprite {
    //my own modification of the sprite class

    private Sprite sprite;
    private float[] positionArray;//index 0 -> x axis, index 1 -> y axis
    private float width,height,scale,unscaledWidth,unscaledHeight;
    private float hitboxOffsetx, hitboxOffsetY;
    private boolean debugMode;

    public GameSprite(Sprite sprite, float[] positionArray, float width, float height, float scale, float unscaledWidth, float unscaledHeight, float hitboxOffsetx, float hitboxOffsetY, boolean debugMode, TextureRegion region){
        this.sprite = sprite;
        this.sprite.setRegion(region);

        this.positionArray = positionArray;
        this.sprite.setPosition(this.positionArray[0],this.positionArray[1]);

        this.width = width;
        this.height = height;

        this.scale = scale;
        this.sprite.setScale(this.scale);

        this.unscaledWidth = unscaledWidth;
        this.sprite.setRegionWidth((int)unscaledWidth);
        this.unscaledHeight = unscaledHeight;
        this.sprite.setRegionHeight((int)unscaledHeight);

        this.hitboxOffsetx = hitboxOffsetx;
        this.hitboxOffsetY = hitboxOffsetY;
        this.debugMode = debugMode;

        this.sprite.setOrigin(0,0);
    }

}
