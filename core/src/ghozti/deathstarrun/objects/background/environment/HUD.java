package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.utils.Font;
import ghozti.deathstarrun.utils.saver.CurrentGameState;
import ghozti.deathstarrun.utils.saver.GameSaver;

public class HUD {

    Font font;

    public HUD(){
        font = new Font(120);
    }

    public void updateHud(float scoreIncrement){
        CurrentGameState.score += scoreIncrement;
    }

    public void drawHud(Batch batch){
        font.draw(batch,"Score: " + (int)CurrentGameState.score, 32,1000,0,false);
        font.draw(batch,"Greatest Score: " + Integer.parseInt(GameSaver.data.highestScore), 32,950,0,false);
    }
}
