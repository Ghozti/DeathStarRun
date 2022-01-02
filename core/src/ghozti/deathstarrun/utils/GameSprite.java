package ghozti.deathstarrun.utils;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameSprite {
    //my own modification of the sprite class

    protected Sprite sprite;
    protected float[] positionArray;//index 0 -> x axis, index 1 -> y axis
    protected float scale,unscaledWidth,unscaledHeight;
    protected float hitboxOffsetx, hitboxOffsetY;
    protected float speed;
    protected Rectangle rectangle;
    protected boolean debugMode;
    protected TextureRegion region;

    //constant textures
    TextureRegion hitboxTexture = Atlas.getHitbox();

    public GameSprite(Sprite sprite, float[] positionArray, float scale, float unscaledWidth, float unscaledHeight, float hitboxOffsetx, float hitboxOffsetY, Rectangle rectangle, boolean debugMode, int fighterID){
        setFighterType(fighterID);
        this.sprite = sprite;
        this.sprite.setRegion(region);

        this.positionArray = positionArray;
        this.sprite.setPosition(this.positionArray[0],this.positionArray[1]);

        this.scale = scale;
        this.sprite.setScale(this.scale);

        this.unscaledWidth = unscaledWidth;
        this.sprite.setRegionWidth((int)unscaledWidth);
        this.unscaledHeight = unscaledHeight;
        this.sprite.setRegionHeight((int)unscaledHeight);

        this.hitboxOffsetx = hitboxOffsetx;
        this.hitboxOffsetY = hitboxOffsetY;

        this.rectangle = rectangle;
        this.rectangle.x = positionArray[0];
        this.rectangle.y = positionArray[1];
        this.rectangle.x += hitboxOffsetx;
        this.rectangle.y += hitboxOffsetY;

        this.debugMode = debugMode;
        this.sprite.setOriginCenter();
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float[] getPositionArray() {
        return positionArray;
    }

    public float getScale() {
        return scale;
    }

    public float getUnscaledWidth() {
        return unscaledWidth;
    }

    public float getUnscaledHeight() {
        return unscaledHeight;
    }

    public float getHitboxOffsetx() {
        return hitboxOffsetx;
    }

    public float getHitboxOffsetY() {
        return hitboxOffsetY;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void updateSpritePosition(float xChange, float yChange){
        positionArray[0] += xChange;
        positionArray[1] += yChange;
        rectangle.x += xChange;
        rectangle.y += yChange;
        sprite.setPosition(positionArray[0], positionArray[1]);
    }

    //DRAWING STUFF
    public abstract void draw(Batch batch);

    //this method will be used to update the sprite for example user input
    public abstract void update();

    public void drawSprite(Batch batch) {
        sprite.draw(batch);
    }

    //will draw the hitbox if the game is in debug mode
    public void drawHitBox(Batch batch) {
        if(debugMode) {
            batch.draw(hitboxTexture, (sprite.getX() + sprite.getOriginX()) - (sprite.getWidth() * scale)/2,(sprite.getY() + sprite.getOriginY()) - (sprite.getHeight() * scale)/2, sprite.getWidth() * scale, sprite.getHeight() * scale);
        }
    }

    public void setFighterType(int fighterID){
        if (fighterID == Constants.ShipIDs.X_WING){
            speed = Constants.XWing.MAX_SPEED;
            region = Atlas.getX_WING();
        }else if (fighterID == Constants.ShipIDs.TIE_FIGHTER){
            speed = Constants.TieFighter.MAX_SPEED;
        }
    }
}
