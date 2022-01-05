package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import ghozti.deathstarrun.utils.Atlas;

import java.awt.*;

public class TeamSelectorScreen implements Screen {

    Texture background,rebelLogo,imperialLogo;
    TextureRegion hitboxTexture;
    float width,height;
    SpriteBatch batch;
    Sound rebelSound, imperialSound;
    com.badlogic.gdx.math.Rectangle rebelHitbox, imperialHitbox, mouseHitbox;
    boolean debug, rebelSoundPlaying, imperialSoundPlaying;

    public TeamSelectorScreen(){
        background = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/teamSelectorBG.png"));
        rebelLogo = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/rebel.png"));
        imperialLogo = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/empire.png"));
        hitboxTexture = Atlas.getHitbox();
        width = 1920;
        height = 1080;
        batch = new SpriteBatch();
        rebelSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/death-star-run-startAssets/rebelSound.mp3"));
        imperialSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/death-star-run-startAssets/imperialMarch.mp3"));
        rebelHitbox = new com.badlogic.gdx.math.Rectangle();
        imperialHitbox = new com.badlogic.gdx.math.Rectangle();
        mouseHitbox = new com.badlogic.gdx.math.Rectangle();
        debug = true;

        rebelHitbox.x = 400;
        rebelHitbox.y = 400;
        rebelHitbox.width = 300;
        rebelHitbox.height = 300;

        imperialHitbox.x = 1120;
        imperialHitbox.y = 400;
        imperialHitbox.width = 300;
        imperialHitbox.height = 300;

        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = -Gdx.input.getY();
        mouseHitbox.width = 10;
        mouseHitbox.height = 10;
    }

    @Override
    public void show() {

    }

    public void update(){
        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = Math.abs(Gdx.input.getY() - (int)height);

        if (mouseHitbox.overlaps(rebelHitbox)){
           if (!rebelSoundPlaying){
               rebelSoundPlaying = true;
               rebelSound.play(1);
           }
        }else {
            rebelSoundPlaying = false;
            rebelSound.stop();
        }

        if (mouseHitbox.overlaps(imperialHitbox)){
            if (!imperialSoundPlaying){
                imperialSoundPlaying = true;
                imperialSound.play(1);
            }
        }else {
            imperialSoundPlaying = false;
            imperialSound.stop();
        }
    }

    @Override
    public void render(float delta) {
        update();
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        batch.begin();
        batch.draw(background,0,0,1920,1080);
        batch.draw(rebelLogo,400,400,300,300);
        batch.draw(imperialLogo,1120,400,300,300);
        batch.draw(hitboxTexture, rebelHitbox.x,rebelHitbox.y,rebelHitbox.width,rebelHitbox.height);
        batch.draw(hitboxTexture, imperialHitbox.x,imperialHitbox.y,imperialHitbox.width,imperialHitbox.height);
        batch.draw(hitboxTexture,mouseHitbox.x,mouseHitbox.y,mouseHitbox.width,mouseHitbox.height);
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
