package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Font;

public class TeamSelectorScreen implements Screen {

    Texture background,rebelLogo,imperialLogo;
    TextureRegion hitboxTexture;
    float width,height;
    SpriteBatch batch;
    Sound rebelSound, imperialSound;
    com.badlogic.gdx.math.Rectangle rebelHitbox, imperialHitbox, mouseHitbox;
    boolean debug, screenDisposed;
    ghozti.deathstarrun.utils.Font font;

    public static String teamSelected = "";

    //TODO master the sound

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
        font = new Font(250);

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

    float rebelVolume = 1, empireVolume = 1;
    float rebelLogoPosMax = 420, rebelLogoPosMin = 400, rebelLogoPos = 400, empireLogoPosMax = 420, empireLogoPosMin = 400, empireLogoPos = 400;
    boolean rebelSoundPlaying, imperialSoundPlaying, rebelLogoGoingUp, rebelLogoGoingDown, empireLogoGoingUp, empireLogoGoingDown;
    long rebelSoundID, empireSoundID;

    public void update(){
        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = Math.abs(Gdx.input.getY() - (int)height);

        //REBEL LOGO LOGIC//////////////////////////////////////////////////////////////////////////////////////////////
        if (mouseHitbox.overlaps(rebelHitbox)){

            if (Gdx.input.isButtonPressed(Input.Keys.LEFT)){
                teamSelected = "Rebels";
                screenDisposed = true;
                rebelSound.stop();
            }

            if (rebelLogoPos <= rebelLogoPosMax){
                if (!rebelLogoGoingDown) {
                    rebelLogoGoingUp = true;
                }
            }else {
                rebelLogoGoingDown = true;
                rebelLogoGoingUp = false;
            }

            if (rebelLogoPos <= rebelLogoPosMin){
                rebelLogoGoingDown = false;
            }

            if (rebelLogoGoingUp){
                rebelLogoPos += .5;
            }
            if (rebelLogoGoingDown){
                rebelLogoPos -= .5;
            }

           if (!rebelSoundPlaying){
                rebelSoundPlaying = true;
                imperialSound.stop();
                rebelSound.stop();
                rebelVolume = 1;
                rebelSoundID = rebelSound.play(rebelVolume);
           }
        }else {
            if (rebelVolume != 0){
                rebelVolume -= .01;
            }
            rebelLogoPos = 400;
            rebelSoundPlaying = false;
            if (!imperialSoundPlaying){
                rebelSound.setVolume(rebelSoundID,rebelVolume);
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //IMPERIAL LOGO LOGIC///////////////////////////////////////////////////////////////////////////////////////////
        if (mouseHitbox.overlaps(imperialHitbox)){

            if (Gdx.input.isButtonPressed(Input.Keys.LEFT)){
                teamSelected = "Empire";
                screenDisposed = true;
                imperialSound.stop();
            }

            if (empireLogoPos <= empireLogoPosMax){
                if (!empireLogoGoingDown) {
                    empireLogoGoingUp = true;
                }
            }else {
                empireLogoGoingDown = true;
                empireLogoGoingUp = false;
            }

            if (empireLogoPos <= empireLogoPosMin){
                empireLogoGoingDown = false;
            }

            if (empireLogoGoingUp){
                empireLogoPos += .5;
            }
            if (empireLogoGoingDown){
                empireLogoPos -= .5;
            }

            if (!imperialSoundPlaying){
                imperialSoundPlaying = true;
                rebelSound.stop();
                imperialSound.stop();
                empireVolume = 1;
                empireSoundID = imperialSound.play(empireVolume);
            }
        }else {
            if (empireVolume != 0){
                empireVolume -= .01;
            }
            imperialSoundPlaying = false;
            empireLogoPos = 400;
            if (!rebelSoundPlaying) {
                imperialSound.setVolume(empireSoundID, empireVolume);
            }
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        if (!screenDisposed) {
            update();
            batch.begin();
            batch.draw(background, 0, 0, 1920, 1080);
            batch.draw(rebelLogo, 400, rebelLogoPos, 300, 300);
            batch.draw(imperialLogo, 1120, empireLogoPos, 300, 300);
            batch.draw(hitboxTexture, rebelHitbox.x, rebelHitbox.y, rebelHitbox.width, rebelHitbox.height);
            batch.draw(hitboxTexture, imperialHitbox.x, imperialHitbox.y, imperialHitbox.width, imperialHitbox.height);
            batch.draw(hitboxTexture, mouseHitbox.x, mouseHitbox.y, mouseHitbox.width, mouseHitbox.height);

            font.draw(batch, "Rebellion", 315, 300, 0, false);
            font.draw(batch, "Empire",1120,300,0,false);
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
        screenDisposed = true;
    }

    @Override
    public void dispose() {
        batch.dispose();
        rebelSound.dispose();
        imperialSound.dispose();
    }
}
