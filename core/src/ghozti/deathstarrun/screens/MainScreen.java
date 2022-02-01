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
import ghozti.deathstarrun.utils.Constants;

public class MainScreen implements Screen {

    //screen
    OrthographicCamera camera;
    SpriteBatch batch;
    Viewport viewport;

    //game objects
    BackGround backGround;
    Player player;
    String team;

    boolean pause;
    float deltaRecorded;
    boolean clickCoolDown;

    Texture opacity = new Texture(Gdx.files.internal("core/assets/death-star-run-startAssets/opacity.png"));

    public MainScreen(TextureRegion ship){
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(Constants.Screen.WIDTH,Constants.Screen.HEIGHT,camera);

        //game objects
        backGround = new BackGround();
        player = new Player(new Sprite(ship),new float[]{500,500},1.5f,256,256,0,0,new Rectangle(), true, Constants.ShipIDs.X_WING, ship);//todo mak the player set the ship id
    }

    @Override
    public void show() {
    }

    private void update(){//call all of the update methods in sprites here
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
        backGround.update();
        player.update();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        update();
        batch.begin();
        backGround.draw(batch);
        player.draw(batch);
        if (pause){
            batch.draw(opacity,0,0,1920,1080);
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
}
