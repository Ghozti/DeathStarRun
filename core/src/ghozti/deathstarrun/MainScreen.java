package ghozti.deathstarrun;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import ghozti.deathstarrun.objects.background.BackGround;

public class MainScreen implements Screen {

    //screen
    OrthographicCamera camera;
    SpriteBatch batch;
    Viewport viewport;

    //game objects
    BackGround backGround;

    public MainScreen(){
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(1920,1080,camera);

        //game objects
        backGround = new BackGround();
    }

    @Override
    public void show() {

    }

    private void update(){//call all of the update methods in sprites here
        backGround.update();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);// will reset the screen to black
        update();
        batch.begin();
        backGround.draw(batch);
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
}
