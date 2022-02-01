package ghozti.deathstarrun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import ghozti.deathstarrun.objects.background.environment.BackGround;
import ghozti.deathstarrun.objects.entities.Player;
import ghozti.deathstarrun.utils.Atlas;
import ghozti.deathstarrun.utils.Constants;
import ghozti.deathstarrun.utils.saver.CurrentGameState;
import ghozti.deathstarrun.utils.saver.GameSaver;

public class MainScreen implements Screen {

    //screen
    OrthographicCamera camera;
    SpriteBatch batch;
    Viewport viewport;

    //game objects
    BackGround backGround;
    Player player;
    String team;
    Rectangle mouseHitbox;

    boolean pause;
    float deltaRecorded;
    boolean clickCoolDown;

    //ESC menu
    TextureRegion text = Atlas.getSAVE_AND_QUIT();
    Rectangle textHitBox = new Rectangle(695,500,530,45);

    public MainScreen(TextureRegion ship){
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(Constants.Screen.WIDTH,Constants.Screen.HEIGHT,camera);

        //game objects
        backGround = new BackGround();
        player = new Player(new Sprite(ship),new float[]{500,500},1.5f,256,256,0,0,new Rectangle(), true, Constants.ShipIDs.X_WING, ship);//todo make the player set the ship id
        mouseHitbox = new Rectangle(Gdx.input.getX(),Math.abs(Gdx.input.getY() - (int) Constants.Screen.HEIGHT),10,10);
    }

    @Override
    public void show() {
    }

    private void update(){//call all of the update methods in sprites here
        updateMousePos();
        updateTime();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) && !clickCoolDown){
            if (!pause){
                pause = true;
                deltaRecorded = 0;
            }else {
                pause = false;
                deltaRecorded = 0;
            }
        }

        if (pause){
            if (mouseHitbox.overlaps(textHitBox)){
                text = Atlas.getSAVE_AND_QUIT2();
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                    if (CurrentGameState.score > Float.parseFloat(GameSaver.data.highestScore)) {
                        GameSaver.data.highestScore = CurrentGameState.score + "";
                    }
                    GameSaver.saveGameState();
                    System.exit(0);
                }
            }else {
                text = Atlas.getSAVE_AND_QUIT();
            }
        }
        if (!pause) {
            backGround.update();
            player.update();
        }
    }

    //TODO optimize the esc menu

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        update();
        batch.begin();
        backGround.draw(batch);
        player.draw(batch);
        if (pause){
            batch.draw(Atlas.getOPACITY_BG(),0,0,1920,1080);
            batch.draw(text,695,500,530,45);
            batch.draw(Atlas.getHitbox(),695,500,530,45);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);//tells the viewport to update accordingly
        batch.setProjectionMatrix(camera.combined);
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

    private void updateTime(){
        if (deltaRecorded >= 15){
            clickCoolDown = false;
        }else {
            deltaRecorded++;
            clickCoolDown = true;
        }
    }

    private void updateMousePos(){
        mouseHitbox.x = Gdx.input.getX();
        mouseHitbox.y = Math.abs(Gdx.input.getY() - (int)Constants.Screen.HEIGHT);
    }
}
