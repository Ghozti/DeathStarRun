package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.graphics.g2d.Batch;

public class LaserGroup {

    private Laser leftLaser, rightLaser;

    public LaserGroup(Laser leftLaser, Laser rightLaser){
        this.leftLaser = leftLaser;
        this.rightLaser = rightLaser;
    }

    public void rotateBoth(float rotate){
        if (rotate < 0){//rotates right
            if (leftLaser.addedOffSet <= 5){
                leftLaser.addedOffSet += .5;
            }
        }else if (rotate > 0){//rotates left
            if (leftLaser.addedOffSet > 0){
                leftLaser.addedOffSet -= .5;
            }
        }else {
            leftLaser.addedOffSet = 0;
        }
        leftLaser.rotate(rotate);
        rightLaser.rotate(rotate);
    }

    public void setRotateBoth(float rotate){
        leftLaser.setRotation(rotate);
        rightLaser.setRotation(rotate);
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
