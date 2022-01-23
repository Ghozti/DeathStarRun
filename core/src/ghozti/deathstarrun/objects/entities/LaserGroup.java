package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.graphics.g2d.Batch;

public class LaserGroup {

    Laser leftLaser, rightLaser;

    public LaserGroup(Laser leftLaser, Laser rightLaser){
        this.leftLaser = leftLaser;
        this.rightLaser = rightLaser;
    }

    public void rotateRight(float rotation){
        rightLaser.rotate(rotation);
    }

    public void rotateLeft(float rotation){
        leftLaser.rotate(rotation);
    }

    public void setRotateRight(float rotation){
        rightLaser.setRotation(rotation);
    }

    public void setRotateLeft(float rotation){
        leftLaser.setRotation(rotation);
    }

    public void update(boolean lasersShot, float shipX, float shipY){
        leftLaser.updateLaser(lasersShot,shipX,shipY);
        rightLaser.updateLaser(lasersShot,shipX,shipY);
    }

    public void draw(Batch batch){
        leftLaser.draw(batch);
        rightLaser.draw(batch);
    }

    public void drawLaserHitboxes(Batch batch){
        leftLaser.drawHitBox(batch);
        rightLaser.drawHitBox(batch);
    }
}
