package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.objects.background.utils.ShipGameSprite;

public class Player extends ShipGameSprite {

    public Player(Sprite sprite, float[] positionArray, float scale, float unscaledWidth, float unscaledHeight, float hitboxOffsetx, float hitboxOffsetY, Rectangle rectangle, boolean debugMode, int fighterID, TextureRegion region) {
        super(sprite, positionArray, scale, unscaledWidth, unscaledHeight, hitboxOffsetx, hitboxOffsetY, rectangle, debugMode, fighterID, region);
    }

    @Override
    public void draw(Batch batch) {
        drawSprite(batch);
        //drawHitBox(batch);
        for (Laser i : lasers){
            i.draw(batch);
            i.drawHitBox(batch);
        }
    }

    @Override
    public void update() {
        handleInput();
        for (Laser i : lasers){
            i.updateLaser(Gdx.input.isKeyPressed(Input.Keys.SPACE),getPositionArray()[0],getPositionArray()[1]);
        }
    }

    private float rightRotation, leftRotation;

    private void handleInput(){
        float xChange = 0, yChange = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            xChange = speed;
            if (rightRotation <= maxRotationValue){
                sprite.rotate(-rotaionSpeed);
                for(Laser i : lasers){
                    i.rotate(-rotaionSpeed);
                }
                rightRotation += rotaionSpeed;
                leftRotation -= rotaionSpeed;
            }
        }else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            xChange = -speed;
            if (leftRotation <= maxRotationValue){
                sprite.rotate(rotaionSpeed);
                for(Laser i : lasers){
                    i.rotate(rotaionSpeed);
                }
                leftRotation += rotaionSpeed;
                rightRotation -= rotaionSpeed;
            }
        }else{
            if (rightRotation >= 0){
                if ((int)rightRotation != 0){
                    sprite.rotate(rotaionSpeed);
                    for(Laser i : lasers){
                        i.rotate(rotaionSpeed);
                    }
                    rightRotation -= rotaionSpeed;
                    leftRotation += rotaionSpeed;
                }else {
                    for(Laser i : lasers){
                        i.setRotation(0);
                    }
                }
            }else if (leftRotation >= 0){
                if ((int)leftRotation != 0){
                    sprite.rotate(-rotaionSpeed);
                    for(Laser i : lasers){
                        i.rotate(-rotaionSpeed);
                    }
                    leftRotation -= rotaionSpeed;
                    rightRotation += rotaionSpeed;
                }else {
                    sprite.setRotation(0);
                    for(Laser i : lasers){
                        i.setRotation(0);
                    }
                }
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            yChange = speed;
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            yChange = -speed;
        }
        updateSpritePosition(xChange,yChange);
    }
}
