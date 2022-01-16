package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;

import java.awt.*;
import java.util.ArrayList;

public class ShipSelector implements Screen {

    String teamSelected;
    SpriteBatch batch;
    Texture backGround, leftArrow, rigthArrow;
    TextureRegion hitboxTexture;
    com.badlogic.gdx.math.Rectangle rightArrowHitbox, leftArrowHitbox, shipHitbox, mouseHitbox;
    ArrayList<Texture> ships;

    public ShipSelector(String teamSelected){
        this.teamSelected = teamSelected;
        batch = new SpriteBatch();
        backGround = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/teamSelectorBG.png"));
        leftArrow = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/leftArrow1.png"));
        rigthArrow = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/rightArrow1.png"));
        hitboxTexture = Atlas.getHitbox();
        leftArrowHitbox = new com.badlogic.gdx.math.Rectangle(120,430,220,220);
        rightArrowHitbox =  new com.badlogic.gdx.math.Rectangle(1580,430,220,220);
        mouseHitbox = new Rectangle(Gdx.input.getX(),Math.abs(Gdx.input.getY() - (int) Constants.Screen.HEIGHT),10,10);
        if (teamSelected.equals(Constants.Teams.REBELS)){

        }
    }

    @Override
    public void show() {

    }

    public void update(){
        updateMousePos();
        handleArrowInput();
    }

    @Override
    public void render(float delta) {
        update();
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        batch.begin();
        batch.draw(rigthArrow,rightArrowHitbox.x,rightArrowHitbox.y,rightArrowHitbox.width,rightArrowHitbox.height);
        batch.draw(leftArrow,leftArrowHitbox.x,leftArrowHitbox.y,leftArrowHitbox.width,leftArrowHitbox.height);
        batch.draw(hitboxTexture,mouseHitbox.x,mouseHitbox.y,mouseHitbox.width,mouseHitbox.height);
        batch.draw(hitboxTexture,rightArrowHitbox.x,rightArrowHitbox.y,rightArrowHitbox.width,rightArrowHitbox.height);
        batch.draw(hitboxTexture,leftArrowHitbox.x,leftArrowHitbox.y,leftArrowHitbox.width,leftArrowHitbox.height);
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

    private void handleArrowInput(){
        if (mouseHitbox.overlaps(leftArrowHitbox)){
            leftArrow = new Texture("core/assets/death-star-run-startAssets/leftArrow2.png");
            if (Gdx.input.isButtonPressed(Input.Keys.LEFT)){
                leftArrow = new Texture("core/assets/death-star-run-startAssets/leftArrow3.png");
            }
        }else {
            leftArrow = new Texture("core/assets/death-star-run-startAssets/leftArrow1.png");
        }

        if (mouseHitbox.overlaps(rightArrowHitbox)){
            rigthArrow = new Texture("core/assets/death-star-run-startAssets/rightArrow2.png");
            if (Gdx.input.isButtonPressed(Input.Keys.LEFT)){
                rigthArrow = new Texture("core/assets/death-star-run-startAssets/rightArrow3.png");
            }
        }else {
            rigthArrow = new Texture("core/assets/death-star-run-startAssets/rightArrow1.png");
        }
    }

    private void updateMousePos(){
        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = Math.abs(Gdx.input.getY() - (int)Constants.Screen.HEIGHT);
    }

    private static void setShipList(String team){
        if (team.equals(Constants.Teams.REBELS)){

        }else if(team.equals(Constants.Teams.IMPERIALS)){

        }
    }
}
