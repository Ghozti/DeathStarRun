package ghozti.deathstarrun.objects.background.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;

public class DeathStarTrench {

    TextureRegion image;
    float[] positionArray;
    float width, height, initY;
    float currentSpeed;

    public DeathStarTrench(float y){
        image = new TextureRegion(Atlas.getBackground());
        positionArray = new float[] {0,y};
        initY = y;
        width = 1920;
        height = 1080;
        currentSpeed = Constants.ScrollingBackGround.INIT_SPEED;
    }

    public void update(){
        positionArray[1] -= currentSpeed;
        if (positionArray[1] <= -1080){
            positionArray[1] = 1080;
        }
    }

    public void draw(Batch batch){
        batch.draw(image,positionArray[0],positionArray[1],width,height);
    }
}
