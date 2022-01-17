package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.utils.Atlas;

public class Laser {

    TextureRegion texture;
    float scale;
    Sprite sprite;
    Rectangle hitbox;
    boolean isOutOfScreen;

    public Laser(TextureRegion texture, float x, float y, float width, float height, float scale){
        this.texture = texture;

        this.scale = scale;

        sprite = new Sprite(new TextureRegion(Atlas.getX_WING_LASER()));
        sprite.setOriginCenter();
        sprite.setPosition(x,y);
        sprite.setRegionWidth((int)width);
        sprite.setRegionHeight((int)height);
        sprite.setScale(scale);

        hitbox = new Rectangle(getHitBoxX(), getHitBoxY(), sprite.getWidth() * scale, sprite.getHeight() * scale);
    }

    public void updateLaser(boolean isShot){
        if(isShot){

        }else {

        }
    }

    public void draw(Batch batch){
        batch.draw(texture,sprite.getX(), sprite.getHeight(),sprite.getWidth(),sprite.getHeight());
    }

    public void drawHitBox(Batch batch){
        batch.draw(Atlas.getHitbox(),getHitBoxX(),getHitBoxY(),sprite.getWidth() * scale, sprite.getHeight() * scale);
    }

    public void rotate(float degrees){
        sprite.rotate(degrees);
    }

    public void setRotation(float degree){
        sprite.setRotation(degree);
    }

    private float[] calculatePositionChange(){
        return new float[] {sprite.getRotation(),5};
    }

    private void changePosition(float xChange, float yChange){
        sprite.setPosition(sprite.getX() + xChange, sprite.getY() + yChange);
        hitbox.setPosition(getHitBoxX() + xChange, getHitBoxY() + yChange);
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
