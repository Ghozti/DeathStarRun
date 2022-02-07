package ghozti.deathstarrun.objects.background.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public abstract class InteractableBackGroundItem {

    Texture texture;
    Rectangle hitbox;
    float[] posArray;
    float speed;
    float width, height;
    float damageGiven;

    public InteractableBackGroundItem(){

    }

    //***************************SETTERS********************************************************************************
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

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
