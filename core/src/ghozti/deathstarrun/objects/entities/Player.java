package ghozti.deathstarrun.objects.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ghozti.deathstarrun.utils.GameSprite;

public class Player extends GameSprite {

    public Player(Sprite sprite, float[] positionArray, float width, float height, float scale, float unscaledWidth, float unscaledHeight, float hitboxOffsetx, float hitboxOffsetY, Rectangle rectangle, boolean debugMode, TextureRegion region) {
        super(sprite, positionArray, width, height, scale, unscaledWidth, unscaledHeight, hitboxOffsetx, hitboxOffsetY, rectangle, debugMode, region);
    }

    @Override
    public void draw(Batch batch) {

    }

    @Override
    public void update() {

    }

    private void handleInput(){

    }
}
