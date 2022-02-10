package ghozti.deathstarrun.objects.background.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public abstract class InteractableBackGroundItem {

    private Texture texture;
    private Rectangle hitbox;
    private float[] posArray;
    private float speed;
    private float width, height;
    private float damageGiven;
    public boolean isAlive;

    public InteractableBackGroundItem(){

    }

    //***************************SETTERS********************************************************************************
    public void setTexture(Texture texture) {
        this.texture = texture;
    }//TODO change this to texture region

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public void setPosArray(float[] posArray) {
        this.posArray = posArray;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setDamageGiven(float damageGiven) {
        this.damageGiven = damageGiven;
    }

    //***************************GETTERS********************************************************************************

    public Texture getTexture() {
        return texture;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public float[] getPosArray() {
        return posArray;
    }

    public float getSpeed() {
        return speed;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getDamageGiven() {
        return damageGiven;
    }

    /******************************************************************************************************************/

    public abstract void onTargetCollision(Rectangle target);

    public abstract void update();

    public abstract void draw(Batch batch);

    public abstract void drawHitbox(Batch batch);
}
