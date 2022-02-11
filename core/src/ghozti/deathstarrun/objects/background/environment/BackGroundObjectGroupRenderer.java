package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.objects.background.utils.InteractableBackGroundItem;

import java.util.ArrayList;

public class BackGroundObjectGroupRenderer {

    /*
        RULES FOR OBJECTS:

       - no more than 3 objects at once

       - only big objects can deal 100% damage

       - object has to start to be rendered above the screen borders and will become invalid after it's 60 px below the bottom border

       - objects should be placed atleast 100 px above each other
     */

    private ArrayList<InteractableBackGroundItem> objects;
    private final float xPosRight = 500, xPosLeft = 900;
    private final float yPos = 2010;

    public BackGroundObjectGroupRenderer(){
        objects = new ArrayList<>();
        objects.add(new Pole(xPosRight, yPos));
    }

    private InteractableBackGroundItem getNext(){
        //will calculate next object to render
        float[] position = {500,2100};
        return new Pole(position[0],position[1]);
    }

    public void updateAllObjects(){
        for (InteractableBackGroundItem i : objects){
            i.update();
        }
    }

    public void drawAllObjects(Batch batch){
        for (InteractableBackGroundItem i : objects){
            i.draw(batch);
        }
    }

    public void drawAllObjectHitboxes(Batch batch){
        for (InteractableBackGroundItem i : objects){
            i.drawHitbox(batch);
        }
    }
}
