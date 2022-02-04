package ghozti.deathstarrun.objects.background.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.deathstarrun.utils.Font;
import ghozti.deathstarrun.utils.saver.CurrentGameState;
import ghozti.deathstarrun.utils.saver.GameSaver;

public class HUD {

    Font font;
    boolean devMode = true;

    public HUD(){
        font = new Font(120);
    }

    float x, y;

    public void updateHud(float scoreIncrement, float x, float y){
        CurrentGameState.score += scoreIncrement;
        this.x = x;
        this.y = y;
    }

    public void drawHud(Batch batch){
        font.draw(batch,"Score: " + (int)CurrentGameState.score, 32,1000,0,false);
        font.draw(batch,"Greatest Score: " + (int)Float.parseFloat(GameSaver.data.highestScore), 32,950,0,false);
        if (devMode){
            font.draw(batch,"X pos: " + x, 32, 900,0,false);
            font.draw(batch,"Y pos: " + y, 32, 850, 0, false);
        }
    }
}
