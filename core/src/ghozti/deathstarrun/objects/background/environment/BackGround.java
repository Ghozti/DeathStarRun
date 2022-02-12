package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.objects.background.environment.DeathStarTrench;
import ghozti.deathstarrun.objects.background.utils.InteractableBackGroundItem;

public class BackGround {

    //wrapper for all bg objects and stuff

    //all bg objects here
    DeathStarTrench[] trenches;
    HUD hud;
    BackGroundObjectGroupRenderer renderer;

    public BackGround(){
        trenches = new DeathStarTrench[]{new DeathStarTrench(0), new DeathStarTrench(1080)};
        hud = new HUD();
        renderer = new BackGroundObjectGroupRenderer();
    }

    public void update(float x, float y){
        for (DeathStarTrench i : trenches) {
            i.update();
        }
        renderer.updateAllObjects();
        hud.updateHud(0.1f,x,y);
    }

    public void draw(Batch batch){
        for (DeathStarTrench i : trenches) {
            i.draw(batch);
        }
        renderer.drawAllObjects(batch);
        //renderer.drawAllObjectHitboxes(batch);
        hud.drawHud(batch);
    }
}
