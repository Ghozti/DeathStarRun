package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.objects.background.environment.objects.Pole;
import ghozti.deathstarrun.objects.background.utils.InteractableBackGroundItem;
import ghozti.deathstarrun.utils.Randomizer;

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
    private final float xPosRight = 395, xPosLeft = 900;
    private final float yPos = 2010;

    public BackGroundObjectGroupRenderer(){
        objects = new ArrayList<>();
        objects.add(new Pole(xPosRight, yPos, true));
        objects.add(new Pole(xPosRight, yPos, true));
        objects.add(new Pole(xPosRight, yPos, true));
    }

    private void updateRenderer(){//true for right side false for left
        for (int i = 0; i < objects.size(); i++) {
            if (!objects.get(i).isAlive){
                Randomizer randomizer = new Randomizer();
                if (randomizer.flipCoin() == 1){
                    objects.set(i, new Pole(395,2010,true));
                }else {
                    objects.set(i, new Pole(900,2010, false));
                }
            }
        }
    }

    public void updateAllObjects(){
        for (InteractableBackGroundItem i : objects){
            i.update();
        }
        updateRenderer();
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
