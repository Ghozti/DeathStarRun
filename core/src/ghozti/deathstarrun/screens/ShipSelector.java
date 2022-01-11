package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ShipSelector implements Screen {

    SpriteBatch batch;
    Texture backGround;
    Texture ship;
    String teamSelected;

    public ShipSelector(String teamSelected){
        batch = new SpriteBatch();
        backGround = new Texture(Gdx.files.internal("core/assets/death-star-runAssets/teamSelectorBG.png"));
        this.teamSelected = teamSelected;
    }

    @Override
    public void show() {

    }

    public void update(){

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
