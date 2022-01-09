package ghozti.deathstarrun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ghozti.deathstarrun.Game;
import ghozti.deathstarrun.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.width = (int)Constants.Screen.WIDTH;
		config.height = (int)Constants.Screen.HEIGHT;
		config.foregroundFPS = 120;
		config.backgroundFPS = 120;
		config.title = "Death Star Run";
		config.fullscreen = true;
		new LwjglApplication(new Game(), config);
	}
}
