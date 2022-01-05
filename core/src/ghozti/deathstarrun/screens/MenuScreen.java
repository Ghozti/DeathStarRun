package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {

    //TODO add to the atlas
    Texture background;
    float width,height;
    SpriteBatch batch;
    Sound screenSound;

    public MenuScreen(){
        background = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/title.png"));
        width = 1920;
        height = 1080;
        batch = new SpriteBatch();
        screenSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/death-star-run-startAssets/star wars intro.mp3"));
        screenSound.loop();
    }

    @Override
    public void show() {
        screenSound.play(1,1f,0);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        batch.begin();
        batch.draw(background,0,0,width,height);
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
        screenSound.stop();
    }

    @Override
    public void dispose() {
        batch.dispose();
        screenSound.dispose();
    }
}
