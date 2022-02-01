package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.utils.Font;

public class HUD {

    Font font;
    float score;

    public HUD(){
        font = new Font(120);
    }

    public void updateHud(float scoreIncrement){
        score += scoreIncrement;
    }

    public void drawHud(Batch batch){
        font.draw(batch,"Score: " + (int)score, 32,1000,0,false);
    }
}
