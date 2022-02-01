package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.utils.Font;

public class HUD {

    Font font;

    public HUD(){
        font = new Font(32);
    }

    public void drawHud(Batch batch, float score){
        font.draw(batch,"Score: " + score, 32,1000,0,false);
    }
}
