package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.utils.Atlas;

public class Laser {

    private TextureRegion texture;
    private float posArray[];
    private float scale;
    private Sprite sprite;
    private Rectangle hitbox;
    boolean isOutOfScreen;

    public Laser(TextureRegion texture, float x, float y, float width, float height, float scale){
        this.texture = texture;

        posArray = new float[]{x,y};

        this.scale = scale;

        sprite = new Sprite(new TextureRegion(Atlas.getX_WING_LASER()));
        sprite.setOriginCenter();
        sprite.setPosition(x,y);
        sprite.setRegionWidth((int)width);
        sprite.setRegionHeight((int)height);
        sprite.setScale(scale);

        hitbox = new Rectangle(getHitBoxX(), getHitBoxY(), sprite.getWidth() * scale, sprite.getHeight() * scale);
    }

    public void updateLaser(boolean isShot, float shipX, float shipY){
        if(isShot){
            shoot();
        }else {
            followShip(shipX,shipY);
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

    private void followShip(float x, float y){
        posArray[0] = x;
        posArray[1] = y;

        hitbox.x = x;
        hitbox.y = y;

        sprite.setPosition(posArray[0],posArray[1]);
    }

    private void shoot(){
        float xChange = calculatePositionChange()[0], yChange = calculatePositionChange()[1];

        posArray[0] += xChange;
        posArray[1] += yChange;

        hitbox.x += xChange;
        hitbox.y += yChange;

        sprite.setPosition(posArray[0],posArray[1]);
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