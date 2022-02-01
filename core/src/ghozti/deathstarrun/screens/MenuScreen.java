package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;
import ghozti.deathstarrun.utils.saver.GameSaver;

public class MenuScreen implements Screen {

    //TODO add to the atlas
    TextureRegion background, playButton, hitBoxTexture;
    Rectangle playButtonHitBox, mouseHitbox;
    float width,height;
    SpriteBatch batch;
    Sound screenSound;

    public static boolean screenDisposed;

    public MenuScreen(){
        GameSaver.loadGameData();
        background = Atlas.getTITLEBG();
        playButton = Atlas.getPLAY_BUTTON();
        hitBoxTexture = Atlas.getHitbox();
        playButtonHitBox = new Rectangle(960-275,300,550,150);
        mouseHitbox = new Rectangle(Gdx.input.getX(),Math.abs(Gdx.input.getY() - (int) Constants.Screen.HEIGHT),10,10);
        width = 1920;
        height = 1080;
        batch = new SpriteBatch();
        screenSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/death-star-run-startAssets/star wars intro.mp3"));
        screenSound.loop();
    }

    @Override
    public void show() {
        screenSound.play(.8f);
    }

    private void update(){
        updateMousePos();
        handleInput();
    }

    @Override
    public void render(float delta) {
        if (!screenDisposed) {
            update();
            ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
            batch.begin();
            batch.draw(background, 0, 0, width, height);
            batch.draw(playButton, playButtonHitBox.x, playButtonHitBox.y, playButtonHitBox.width, playButtonHitBox.height);
            batch.draw(hitBoxTexture, playButtonHitBox.x, playButtonHitBox.y, playButtonHitBox.width, playButtonHitBox.height);
            batch.end();
        }
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
        screenDisposed = true;
    }

    @Override
    public void dispose() {
        batch.dispose();
        screenSound.dispose();
    }

    private void updateMousePos(){
        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = Math.abs(Gdx.input.getY() - (int)Constants.Screen.HEIGHT);
    }

    public void handleInput(){
        if (mouseHitbox.overlaps(playButtonHitBox)){
            playButton = Atlas.getPLAY_BUTTON_HOVERED();
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                screenDisposed = true;
            }
        }else {
            playButton = Atlas.getPLAY_BUTTON();
        }
    }
}
