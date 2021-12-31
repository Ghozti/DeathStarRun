package ghozti.deathstarrun.objects.background;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.objects.background.objects.DeathStarTrench;

public class BackGround {

    //wrapper for all bg objects and stuff

    //all bg objects here
    DeathStarTrench[] trenches;

    public BackGround(){
        trenches = new DeathStarTrench[]{new DeathStarTrench(0), new DeathStarTrench(1080)};
    }

    public void update(){
        for (DeathStarTrench i : trenches) {
            i.update();
        }
    }

    public void draw(Batch batch){
        for (DeathStarTrench i : trenches) {
            i.draw(batch);
        }
    }
}
