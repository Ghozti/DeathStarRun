package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;

public class Laser {

    private TextureRegion texture;
    private float posArray[];
    private float scale, offsetX, offsetY;
    public float addedOffSetX, addedOffSetY;
    private Sprite sprite;
    private Rectangle hitbox;
    boolean isOutOfScreen, shot;

    public Laser(TextureRegion texture, float x, float y, float width, float height, float scale, float offsetX, float offsetY){
        this.texture = texture;

        posArray = new float[]{x,y};

        this.scale = scale;
        this.offsetX = offsetX;
        this.offsetY = offsetY;

        sprite = new Sprite(new TextureRegion(Atlas.getX_WING_LASER()));
        sprite.setOriginCenter();
        sprite.setPosition(x,y);
        sprite.setRegionWidth((int)width);
        sprite.setRegionHeight((int)height);
        sprite.setScale(scale);

        hitbox = new Rectangle(getHitBoxX(), getHitBoxY(), sprite.getWidth() * scale, sprite.getHeight() * scale);
    }

    public void setOffsetX(float x){
        offsetX = x;
    }

    public void setOffsetY(float y){
        offsetX = y;
    }

    public float getOffsetX(){
        return offsetX;
    }

    public float getOffsetY(){
        return offsetY;
    }

    public void updateLaser(boolean isShot, float shipX, float shipY){
        if (isShot){
            shot = true;
        }
        if(shot){
            shoot();
        }else {
            followShip(shipX,shipY);
        }
    }

    public void draw(Batch batch){
        sprite.draw(batch);
    }

    public void drawHitBox(Batch batch){
        batch.draw(Atlas.getHitbox(),getHitBoxX(),getHitBoxY(),sprite.getWidth() * scale, sprite.getHeight() * scale);
    }

    public void rotate(float degrees){
        if (!shot) {
            sprite.rotate(degrees);
        }
    }

    public void setRotation(float degree){
        if (!shot) {
            sprite.setRotation(degree);
        }
    }

    float shotYChange, shotXChange;

    public void setPositionChange(float x, float y){
        if (!shot){
            shotXChange = x;
            shotYChange = y;
        }
    }

    private void followShip(float x, float y){
        posArray[0] = x + addedOffSetX;
        posArray[1] = y + addedOffSetY;

        posArray[0] += offsetX;
        posArray[1] += offsetY + addedOffSetY;

        hitbox.x = x + addedOffSetX;
        hitbox.y = y + addedOffSetY;

        hitbox.x += offsetX + addedOffSetX;
        hitbox.y += offsetY + addedOffSetY;

        sprite.setPosition(posArray[0],posArray[1]);
    }

    private void shoot(){
        float xChange = shotXChange, yChange = shotYChange;
        //TODO WORK ON THIS

        posArray[0] += xChange;
        posArray[1] += yChange;

        hitbox.x += xChange;
        hitbox.y += yChange;

        sprite.setPosition(posArray[0],posArray[1]);

        if (isOutOfScreen()){
            shot = false;
        }
    }

    public boolean isOutOfScreen(){
        return posArray[0] > Constants.Screen.WIDTH || posArray[0] < 0 || posArray[1] > Constants.Screen.HEIGHT || posArray[1] < 0;
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    private float getHitBoxX(){
        return sprite != null ? (sprite.getX() + sprite.getOriginX()) - (sprite.getWidth() * scale)/2 : 0;
    }

    private float getHitBoxY(){
        return sprite != null ? (sprite.getY() + sprite.getOriginY()) - (sprite.getHeight() * scale)/2 : 0;
    }

}
