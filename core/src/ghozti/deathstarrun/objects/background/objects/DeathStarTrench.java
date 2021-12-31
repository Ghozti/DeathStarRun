package ghozti.deathstarrun.objects.background.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ghozti.deathstarrun.utils.Atlas;

public class DeathStarTrench {

    TextureRegion image;
    float[] positionArray;
    float width, height, initY;

    public DeathStarTrench(float y){
        image = new TextureRegion(Atlas.getBackground());
        positionArray = new float[] {0,y};
        initY = y;
        width = 1920;
        height = 1080;
    }

    public void update(){
        positionArray[1] -= 2;
        System.out.println(positionArray[1]);
        if (positionArray[1] <= -1080){
            positionArray[1] = 1080;
        }
    }

    public void draw(Batch batch){
        batch.draw(image,positionArray[0],positionArray[1],width,height);
    }
}
