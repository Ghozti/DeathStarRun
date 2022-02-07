package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.objects.background.utils.InteractableBackGroundItem;

public class Pole extends InteractableBackGroundItem{

    public Pole(float x, float y){
        setPosArray(new float[] {x, y});
    }

    @Override
    public void onTargetCollision(Rectangle target) {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Batch batch) {

    }

    @Override
    public void drawHitbox(Batch batch) {

    }
}
