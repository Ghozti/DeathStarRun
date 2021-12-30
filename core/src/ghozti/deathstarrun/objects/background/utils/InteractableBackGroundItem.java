package ghozti.deathstarrun.objects.background.utils;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public interface InteractableBackGroundItem {

    public void onTargetCollision(Rectangle target);

    public void update();

    public void draw(Batch batch);

    public void drawHitbox(Batch batch);
}
