package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;
import ghozti.deathstarrun.utils.GameSprite;

public class Player extends GameSprite {

    public Player(Sprite sprite, float[] positionArray, float scale, float unscaledWidth, float unscaledHeight, float hitboxOffsetx, float hitboxOffsetY, Rectangle rectangle, boolean debugMode, int fighterID) {
        super(sprite, positionArray, scale, unscaledWidth, unscaledHeight, hitboxOffsetx, hitboxOffsetY, rectangle, debugMode, fighterID);
    }

    @Override
    public void draw(Batch batch) {
        sprite.draw(batch);
        drawHitBox(batch);
    }

    @Override
    public void update() {
        handleInput();
    }

    private float rightRotation, leftRotation;

    private void handleInput(){
        float xChange = 0, yChange = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            xChange = speed;
            if (rightRotation <= maxRotationValue){
                sprite.rotate(-rotaionSpeed);
                rightRotation += rotaionSpeed;
                leftRotation -= rotaionSpeed;
            }
        }else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            xChange = -speed;
            if (leftRotation <= maxRotationValue){
                sprite.rotate(rotaionSpeed);
                leftRotation += rotaionSpeed;
                rightRotation -= rotaionSpeed;
            }
        }else{
            if (rightRotation >= 0){
                if ((int)rightRotation != 0){
                    sprite.rotate(rotaionSpeed);
                    rightRotation -= rotaionSpeed;
                    leftRotation += rotaionSpeed;
                }else {
                    sprite.setRotation(0);
                }
            }else if (leftRotation >= 0){
                if ((int)leftRotation != 0){
                    sprite.rotate(-rotaionSpeed);
                    leftRotation -= rotaionSpeed;
                    rightRotation += rotaionSpeed;
                }else {
                    sprite.setRotation(0);
                }
            }
        }
        updateSpritePosition(xChange,yChange);
    }
}
