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
import java.util.ArrayList;

public class ShipSelector implements Screen {

    String teamSelected;
    SpriteBatch batch;
    TextureRegion backGround, leftArrow, rigthArrow, currentShip;
    public static TextureRegion selectedShip;
    TextureRegion hitboxTexture;
    com.badlogic.gdx.math.Rectangle rightArrowHitbox, leftArrowHitbox, shipHitbox, mouseHitbox;
    ArrayList<TextureRegion> shipList;
    boolean screenDisposed, coolDownActive;

    public ShipSelector(String teamSelected){
        this.teamSelected = teamSelected;
        batch = new SpriteBatch();
        backGround = Atlas.getBackground();
        leftArrow = Atlas.getLEFT_ARROW1();
        rigthArrow = Atlas.getLEFT_ARROW2();
        hitboxTexture = Atlas.getHitbox();
        leftArrowHitbox = new Rectangle(120,430,220,220);
        rightArrowHitbox =  new Rectangle(1580,430,220,220);
        shipHitbox = new Rectangle(635,215,650,650);
        mouseHitbox = new Rectangle(Gdx.input.getX(),Math.abs(Gdx.input.getY() - (int) Constants.Screen.HEIGHT),10,10);
        setShipList(teamSelected);
    }

    @Override
    public void show() {
        coolDownActive = true;
    }

    public void update(){
        updateMousePos();
        handleArrowInput();
    }

    float deltaRecorded = 0;

    @Override
    public void render(float delta) {
        if (!screenDisposed) {
            updateTime();
            update();
            ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
            batch.begin();
            batch.draw(rigthArrow, rightArrowHitbox.x, rightArrowHitbox.y, rightArrowHitbox.width, rightArrowHitbox.height);
            batch.draw(leftArrow, leftArrowHitbox.x, leftArrowHitbox.y, leftArrowHitbox.width, leftArrowHitbox.height);
            batch.draw(currentShip, shipHitbox.x, shipHitbox.y, shipHitbox.width, shipHitbox.height);
            batch.draw(hitboxTexture, mouseHitbox.x, mouseHitbox.y, mouseHitbox.width, mouseHitbox.height);
            batch.draw(hitboxTexture, rightArrowHitbox.x, rightArrowHitbox.y, rightArrowHitbox.width, rightArrowHitbox.height);
            batch.draw(hitboxTexture, shipHitbox.x, shipHitbox.y, shipHitbox.width, shipHitbox.height);
            batch.draw(hitboxTexture, leftArrowHitbox.x, leftArrowHitbox.y, leftArrowHitbox.width, leftArrowHitbox.height);
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
    }

    int currentIndex = 0;
    boolean coolDown;

    private void handleArrowInput(){
        if (mouseHitbox.overlaps(leftArrowHitbox)){
            leftArrow = Atlas.getLEFT_ARROW2();
            if (Gdx.input.isButtonPressed(Input.Keys.LEFT) && !coolDownActive){
                leftArrow = Atlas.getLEFT_ARROW3();
                if (!coolDown){
                    coolDown = true;
                    if (currentIndex > 0){
                        currentIndex--;
                    }
                    currentShip = shipList.get(currentIndex);
                }
            }else {
                coolDown = false;
            }
        }else {
            leftArrow = Atlas.getLEFT_ARROW1();
        }

        if (mouseHitbox.overlaps(rightArrowHitbox)){
            rigthArrow = Atlas.getRIGHT_ARROW2();
            if (Gdx.input.isButtonPressed(Input.Keys.LEFT) && !coolDownActive){
                rigthArrow = Atlas.getRIGHT_ARROW3();
                if (!coolDown){
                    coolDown = true;
                    if (currentIndex < shipList.size()-1){
                        currentIndex++;
                    }
                    currentShip = shipList.get(currentIndex);
                }
            }else {
                coolDown = false;
            }
        }else {
            rigthArrow = Atlas.getRIGHT_ARROW1();
        }

        if (mouseHitbox.overlaps(shipHitbox)){
            if (Gdx.input.isButtonPressed(Input.Keys.LEFT) && !coolDownActive){
                selectedShip = currentShip;
                screenDisposed = true;
            }
        }
    }

    private void updateMousePos(){
        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = Math.abs(Gdx.input.getY() - (int)Constants.Screen.HEIGHT);
    }

    private void setShipList(String team){
        shipList = new ArrayList<>();
        if (team.equals(Constants.Teams.REBELS)){
            shipList.add(Atlas.getX_WING_BLUE());
            shipList.add(Atlas.getX_WING_GOLD());
            shipList.add(Atlas.getX_WING_GREEN());
            shipList.add(Atlas.getX_WING_ORANGE());
            shipList.add(Atlas.getX_WING_PURPLE());
            shipList.add(Atlas.getX_WING_RED());

            currentShip = shipList.get(0);
        }else if(team.equals(Constants.Teams.IMPERIALS)){
            //TODO do this
        }
    }

    private void updateTime(){
        if (deltaRecorded >= 30){
            coolDownActive = false;
        }else {
            deltaRecorded++;
        }
    }
}
