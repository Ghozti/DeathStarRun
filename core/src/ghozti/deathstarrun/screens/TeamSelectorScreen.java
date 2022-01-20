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
import ghozti.deathstarrun.utils.Constants;
import ghozti.deathstarrun.utils.Font;

public class TeamSelectorScreen implements Screen {

    TextureRegion background,rebelLogo,imperialLogo;
    Texture selectTeamTexture;
    TextureRegion hitboxTexture;
    float width,height;
    SpriteBatch batch;
    Sound rebelSound, imperialSound;
    com.badlogic.gdx.math.Rectangle rebelHitbox, imperialHitbox, mouseHitbox;
    boolean debug, screenDisposed;
    ghozti.deathstarrun.utils.Font font;

    public static String teamSelected = "";

    public TeamSelectorScreen(){
        background = Atlas.getSTARBG();
        rebelLogo = Atlas.getREBEL_LOGO();
        imperialLogo = Atlas.getEMPIRE_LOGO();
        selectTeamTexture = new Texture("core/assets/death-star-run-startAssets/chooseYourSide.png");
        hitboxTexture = Atlas.getHitbox();
        width = Constants.Screen.WIDTH;
        height = Constants.Screen.HEIGHT;
        batch = new SpriteBatch();
        rebelSound = Gdx.audio.newSound(Gdx.files.internal(Constants.Paths.REBEL_SOUND));
        imperialSound = Gdx.audio.newSound(Gdx.files.internal(Constants.Paths.IMPERIAL_SOUND));
        rebelHitbox = new com.badlogic.gdx.math.Rectangle();
        imperialHitbox = new com.badlogic.gdx.math.Rectangle();
        mouseHitbox = new com.badlogic.gdx.math.Rectangle();
        debug = true;
        font = new Font(250);

        rebelHitbox.x = 400;
        rebelHitbox.y = 400;
        rebelHitbox.width = 300;
        rebelHitbox.height = 300;

        imperialHitbox.x = 1220;
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
        coolDownActive = true;
    }

    float rebelVolume = 1, empireVolume = 1;
    float rebelLogoPosMax = 420, rebelLogoPosMin = 400, rebelLogoPos = 400, empireLogoPosMax = 420, empireLogoPosMin = 400, empireLogoPos = 400;
    boolean rebelSoundPlaying, imperialSoundPlaying, rebelLogoGoingUp, rebelLogoGoingDown, empireLogoGoingUp, empireLogoGoingDown;
    long rebelSoundID, empireSoundID;

    boolean coolDownActive;

    public void update(){
        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = Math.abs(Gdx.input.getY() - (int)height);

        //REBEL LOGO LOGIC//////////////////////////////////////////////////////////////////////////////////////////////
        if (mouseHitbox.overlaps(rebelHitbox)){

            if (Gdx.input.isButtonPressed(Input.Keys.LEFT) && !coolDownActive){
                teamSelected = Constants.Teams.REBELS;
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
                rebelLogoPos += 1;
            }
            if (rebelLogoGoingDown){
                rebelLogoPos -= 1;
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

            if (Gdx.input.isButtonPressed(Input.Keys.LEFT) && !coolDownActive){
                teamSelected = Constants.Teams.IMPERIALS;
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
                empireLogoPos += 1;
            }
            if (empireLogoGoingDown){
                empireLogoPos -= 1;
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

    //constant vals for the render method
    private final float rebelLogoX = 400, rebelLogoWidth = 300, rebelLogoHeight = 300;
    private final float imperialLogoX = 1220, imperialLogoWidth = 300, imperialLogoHeight = 300;
    private final float rebelFontX = 315, rebelFontY = 300;
    private final float empireFontX = 1220, empireFontY = 300;

    float deltaRecorded;

    @Override
    public void render(float delta) {
        if (!screenDisposed) {
            ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
            updateTime();
            update();
            batch.begin();
            batch.draw(background, 0, 0, Constants.Screen.WIDTH, Constants.Screen.HEIGHT);
            batch.draw(selectTeamTexture, 450,800,1020,100);
            batch.draw(rebelLogo, rebelLogoX, rebelLogoPos, rebelLogoWidth, rebelLogoHeight);
            batch.draw(imperialLogo, imperialLogoX, empireLogoPos, imperialLogoWidth, imperialLogoHeight);
            batch.draw(hitboxTexture, rebelHitbox.x, rebelHitbox.y, rebelHitbox.width, rebelHitbox.height);
            batch.draw(hitboxTexture, imperialHitbox.x, imperialHitbox.y, imperialHitbox.width, imperialHitbox.height);
            batch.draw(hitboxTexture, mouseHitbox.x, mouseHitbox.y, mouseHitbox.width, mouseHitbox.height);

            font.draw(batch, "Rebellion", rebelFontX, rebelFontY, 0, false);
            font.draw(batch, "Empire",empireFontX,empireFontY,0,false);
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

    private void updateTime(){
        if (deltaRecorded >= 50){
            coolDownActive = false;
        }else {
            deltaRecorded++;
        }
    }
}
