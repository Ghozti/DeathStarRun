package ghozti.deathstarrun;

import ghozti.deathstarrun.screens.MainScreen;
import ghozti.deathstarrun.screens.MenuScreen;
import ghozti.deathstarrun.screens.TeamSelectorScreen;

public class Game extends com.badlogic.gdx.Game {

	boolean gameStarted;

	@Override
	public void create () {
		setScreen(new TeamSelectorScreen());
	}

	public void update(){
		if (!TeamSelectorScreen.teamSelected.isEmpty() && !gameStarted){
			setScreen(new MainScreen());
			gameStarted = true;
		}
	}

	@Override
	public void render() {
		update();
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
