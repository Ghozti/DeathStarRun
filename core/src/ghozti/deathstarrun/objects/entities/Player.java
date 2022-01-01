package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;
import ghozti.deathstarrun.utils.GameSprite;

public class Player extends GameSprite {

    public Player(Sprite sprite, float[] positionArray, float width, float height, float scale, float unscaledWidth, float unscaledHeight, float hitboxOffsetx, float hitboxOffsetY, Rectangle rectangle, boolean debugMode, int fighterID) {
        super(sprite, positionArray, width, height, scale, unscaledWidth, unscaledHeight, hitboxOffsetx, hitboxOffsetY, rectangle, debugMode, fighterID);
    }

    @Override
    public void draw(Batch batch) {
        batch.draw(region,getPositionArray()[0],getPositionArray()[1],getWidth(),getHeight());
        drawHitBox(batch);
    }

    @Override
    public void update() {
        updateSpritePosition(1,0);
    }

    private void handleInput(){

    }
}
