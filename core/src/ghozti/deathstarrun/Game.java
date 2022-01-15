package ghozti.deathstarrun;

import ghozti.deathstarrun.screens.MainScreen;
import ghozti.deathstarrun.screens.MenuScreen;
import ghozti.deathstarrun.screens.ShipSelector;
import ghozti.deathstarrun.screens.TeamSelectorScreen;
import ghozti.deathstarrun.utils.Constants;

public class Game extends com.badlogic.gdx.Game {

	boolean gameStarted;

	@Override
	public void create () {
		//setScreen(new TeamSelectorScreen());
		setScreen(new ShipSelector(Constants.Teams.REBELS));
	}

	public void update(){
		//if (!TeamSelectorScreen.teamSelected.isEmpty() && !gameStarted){
		//	setScreen(new MainScreen(TeamSelectorScreen.teamSelected));
		//	gameStarted = true;
		//}
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
