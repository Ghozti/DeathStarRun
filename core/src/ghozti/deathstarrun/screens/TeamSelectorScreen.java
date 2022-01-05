package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class TeamSelectorScreen implements Screen {

    Texture background, rebelLogo, imperialLogo;
    float width,height;
    SpriteBatch batch;
    Sound rebelSound, imperialSound;
    Rectangle rebelHitbox, imperialHitbox;

    public TeamSelectorScreen(){
        background = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/teamSelectorBG.png"));
        rebelLogo = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/rebel.png"));
        imperialLogo = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/empire.png"));
        width = 1920;
        height = 1080;
        batch = new SpriteBatch();
        rebelHitbox = new Rectangle();
        imperialHitbox = new Rectangle();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        batch.begin();
        batch.draw(background,0,0,1920,1080);
        batch.draw(rebelLogo,400,400,300,300);
        batch.draw(imperialLogo,1120,400,300,300);
        batch.end();
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
