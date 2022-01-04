package ghozti.deathstarrun;

import ghozti.deathstarrun.screens.MainScreen;
import ghozti.deathstarrun.screens.MenuScreen;

public class Game extends com.badlogic.gdx.Game {

	boolean startGame, gameStarted;

	@Override
	public void create () {
		setScreen(new MenuScreen());
	}

	@Override
	public void render() {
		if (startGame && !gameStarted){
			screen = new MainScreen();
			gameStarted = true;
		}
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		screen.dispose();
	}

	@Override
	public void resize(int width, int height) {
		screen.resize(width, height);
	}
}
