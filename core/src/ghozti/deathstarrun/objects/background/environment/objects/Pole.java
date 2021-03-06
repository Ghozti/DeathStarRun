package ghozti.deathstarrun.objects.background.environment.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.objects.background.utils.InteractableBackGroundItem;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;

public class Pole extends InteractableBackGroundItem{

    public Pole(float x, float y, boolean rightSide){
        if (rightSide) {
            setTexture(new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/pole.png")));
        }else {
            setTexture(new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/pole.png")));
        }
        setHitbox(new Rectangle());
        setPosArray(new float[] {x, y});
        setSpeed(Constants.ScrollingBackGround.INIT_SPEED);
        setWidth(64*8);
        setHeight(16*8);
        setDamageGiven(5);
    }

    @Override
    public void onTargetCollision(Rectangle target) {
        if (isAlive) {
            if (getHitbox().overlaps(target)) {
                isAlive = false;
                //todo maybe lower player score too
            }
        }
    }

    @Override
    public void update() {
        if (isAlive) {
            getPosArray()[1] -= getSpeed();
        }
        if (getPosArray()[1] <= 0){
            isAlive = false;
        }
    }

    @Override
    public void draw(Batch batch) {
        if (isAlive) {
            batch.draw(getTexture(), getPosArray()[0], getPosArray()[1], getWidth(), getHeight());
        }
    }

    @Override
    public void drawHitbox(Batch batch) {
        if (isAlive) {
            batch.draw(Atlas.getHitbox(), getPosArray()[0], getPosArray()[1], getWidth(), getHeight());
        }
    }
}
