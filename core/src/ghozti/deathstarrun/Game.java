package ghozti.deathstarrun;

import ghozti.deathstarrun.screens.MainScreen;
import ghozti.deathstarrun.screens.MenuScreen;
import ghozti.deathstarrun.screens.ShipSelector;
import ghozti.deathstarrun.screens.TeamSelectorScreen;
import ghozti.deathstarrun.utils.Constants;

public class Game extends com.badlogic.gdx.Game {

	boolean switchedScreensToTeamSelector,switchedScreensToShipSelector, switchedScreensToMainGame;

	//TODO remember the mechanics of the game in Player, and GameSprite

	@Override
	public void create () {
		setScreen(new MenuScreen());
	}

	public void update(){
		if (MenuScreen.screenDisposed && !switchedScreensToTeamSelector){
			setScreen(new TeamSelectorScreen());
			switchedScreensToTeamSelector = true;
		}
		if (!TeamSelectorScreen.teamSelected.isEmpty() && !switchedScreensToShipSelector){
			setScreen(new ShipSelector(TeamSelectorScreen.teamSelected));
			switchedScreensToShipSelector = true;
		}
		if (ShipSelector.selectedShip != null && !switchedScreensToMainGame){
			setScreen(new MainScreen(ShipSelector.selectedShip));
			switchedScreensToMainGame = true;
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
