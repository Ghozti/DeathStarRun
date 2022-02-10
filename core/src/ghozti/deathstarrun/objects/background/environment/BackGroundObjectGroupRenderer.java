package ghozti.deathstarrun.objects.background.environment;

import ghozti.deathstarrun.objects.background.utils.InteractableBackGroundItem;

public class BackGroundObjectGroupRenderer {

    /*
        RULES FOR OBJECTS:

       - no more than 3 objects at once

       - only big objects can deal 100% damage

       - object has to start to be rendered above the screen borders and will become invalid after it's 60 px below the bottom border
     */

    final float rightSide = 500;

    private float[] getRandomizedCoordinates(){
        return null;
    }

    private InteractableBackGroundItem getNext(){
        //will calculate next object to render
        float[] position = getRandomizedCoordinates();
        return new Pole(position[0],position[1]);
    }
}
