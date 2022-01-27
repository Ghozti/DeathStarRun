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
            if (leftLaser.addedOffSetY <= 5){
                leftLaser.addedOffSetY += .5;
            }

            if (rightLaser.addedOffSetY >= -15){
                rightLaser.addedOffSetY -= .5;
            }

            if (leftLaser.addedOffSetX <= 4){
                leftLaser.addedOffSetX += .2;
            }

            if (rightLaser.addedOffSetX <= 4){
                rightLaser.addedOffSetX += .2;
            }
        }else if (rotate > 0){//rotates left
            if (leftLaser.addedOffSetY > 0){
                leftLaser.addedOffSetY -= .5;
            }
            if (leftLaser.addedOffSetX > 4){
                leftLaser.addedOffSetX -= .2;
            }

            if (leftLaser.addedOffSetY == 0 || leftLaser.addedOffSetY > -15){
                leftLaser.addedOffSetY -= .5;
                leftLaser.addedOffSetX -= .2;
            }
        }else {
            leftLaser.addedOffSetY = 0;
            leftLaser.addedOffSetX = 0;

            rightLaser.addedOffSetY = 0;
            rightLaser.addedOffSetX = 0;
        }
        leftLaser.setRotation(rotate);
        rightLaser.setRotation(rotate);
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
