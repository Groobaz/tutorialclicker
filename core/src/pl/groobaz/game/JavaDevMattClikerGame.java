package pl.groobaz.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pl.groobaz.screen.SplashScreen;

public class JavaDevMattClikerGame extends Game {
	
	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	private boolean paused;
	
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	/*@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}*/
	
	/*@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	*/
	/*
	 * --------------------------------------
	 * Gettery i Settery
	 * */
	
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
