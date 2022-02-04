package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.objects.background.environment.DeathStarTrench;

public class BackGround {

    //wrapper for all bg objects and stuff

    //all bg objects here
    DeathStarTrench[] trenches;
    HUD hud;

    public BackGround(){
        trenches = new DeathStarTrench[]{new DeathStarTrench(0), new DeathStarTrench(1080)};
        hud = new HUD();
    }

    public void update(float x, float y){
        for (DeathStarTrench i : trenches) {
            i.update();
        }
        hud.updateHud(0.1f,x,y);
    }

    public void draw(Batch batch){
        for (DeathStarTrench i : trenches) {
            i.draw(batch);
        }
        hud.drawHud(batch);
    }
}
