package ghozti.deathstarrun.objects.background.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;

import java.util.ArrayList;

public abstract class ShipGameSprite {
    //my own modification of the sprite class

    protected Sprite sprite;
    protected float[] positionArray;//index 0 -> x axis, index 1 -> y axis
    protected float scale,unscaledWidth,unscaledHeight;
    protected float hitboxOffsetx, hitboxOffsetY;
    protected float speed;
    protected Rectangle rectangle;
    protected boolean debugMode;
    protected TextureRegion region;
    protected float maxRotationValue, rotaionSpeed;
    protected int fighterID;
    protected Texture laserTexture;
    protected ArrayList<Rectangle> lasers;

    //constant textures
    TextureRegion hitboxTexture = Atlas.getHitbox();

    public ShipGameSprite(Sprite sprite, float[] positionArray, float scale, float unscaledWidth, float unscaledHeight, float hitboxOffsetx, float hitboxOffsetY, Rectangle rectangle, boolean debugMode, int fighterID, TextureRegion region){
        this.region = region;
        this.fighterID = fighterID;
        setFighterType(fighterID);
        setRotationAndSpeedValues(fighterID);
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

        setLaserPosition();
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

    private float getHitBoxX(){
        return sprite != null ? (sprite.getX() + sprite.getOriginX()) - (sprite.getWidth() * scale)/2 : 0;
    }

    private float getHitBoxY(){
        return sprite != null ? (sprite.getY() + sprite.getOriginY()) - (sprite.getHeight() * scale)/2 : 0;
    }

    public void drawHitBox(Batch batch) {
        if(debugMode) {
            batch.draw(hitboxTexture, getHitBoxX(), getHitBoxY(), sprite.getWidth() * scale, sprite.getHeight() * scale);
        }
    }

    //**********
    public void drawLasers(Batch batch){
        batch.draw(laserTexture,lasers.get(0).x,lasers.get(0).y,lasers.get(0).width,lasers.get(0).height);
        batch.draw(laserTexture,lasers.get(1).x,lasers.get(1).y,lasers.get(1).width,lasers.get(1).height);
        if(debugMode) {
            batch.draw(hitboxTexture, lasers.get(1).x,lasers.get(1).y,lasers.get(1).width,lasers.get(1).height);
        }
    }

    public void setFighterType(int fighterID){
        if (fighterID == Constants.ShipIDs.X_WING){
            speed = Constants.XWing.MAX_SPEED;
        }else if (fighterID == Constants.ShipIDs.TIE_FIGHTER){
            speed = Constants.TieFighter.MAX_SPEED;
        }
    }

    private void setRotationAndSpeedValues(int fighterID){
        switch (fighterID){
            case 0:
                maxRotationValue = Constants.XWing.MAX_ROTATION;
                rotaionSpeed = Constants.XWing.ROTATION_SPEED;
                speed = Constants.XWing.MAX_SPEED;
                break;
            case 1:
                maxRotationValue = Constants.TieFighter.MAX_ROTATION;
                rotaionSpeed = Constants.TieFighter.ROTATION_SPEED;
                speed = Constants.TieFighter.MAX_SPEED;
                break;
        }
    }

    //****
    public void setLaserPosition(){
        lasers = new ArrayList<>();
        switch (fighterID){
            case Constants.ShipIDs.X_WING:
                laserTexture = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/xwingLaser.png"));
                lasers.add(new Rectangle(getHitBoxX() + (6.5f),getHitBoxY() + (230.5f),3,22.5f));
                lasers.add(new Rectangle(getHitBoxX() + (375.5f),getHitBoxY()+ (230.5f),3,22.5f));
                break;
            case Constants.ShipIDs.TIE_FIGHTER:
                break;
        }
    }
}
