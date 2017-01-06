package pl.groobaz.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sun.xml.internal.ws.assembler.dev.TubelineAssemblyContextUpdater;

import pl.groobaz.game.JavaDevMattClikerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = JavaDevMattClikerGame.GAME_NAME;
		config.width = JavaDevMattClikerGame.WIDTH;
		config.height = JavaDevMattClikerGame.HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new JavaDevMattClikerGame(), config);
	}
}
