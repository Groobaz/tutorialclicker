package pl.groobaz.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


import pl.groobaz.screen.SplashScreen;

public class JavaDevMattClikerGame extends Game {
	public final static String GAME_PREFS = "pl.groobaz.game.prefs";
	public final static String GAME_SCORE = "pl.groobaz.game.prefs.score";
	public final static String GAME_NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	private boolean paused;
	
	private Preferences prefs;
	
	private int points; 
	
	public int getPoints() {
		return points;
	}

	public void addPoint() {
		this.points++;
		updateSavedScore();
	}
	
	public void addPoints(int pointsToAdd) {
		this.points += pointsToAdd;
		updateSavedScore();
	}

	private void updateSavedScore() {
		prefs.putInteger(GAME_SCORE,points);
		prefs.flush();
	}

	@Override
	public void create () {
		init();
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
	
	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public void resetGameScore() {
		// TODO Auto-generated method stub
		points = 0;
		updateSavedScore();
	}

	public void addPassiveIncome() {
		// To implement
		System.out.println("Pasive income");
	}
}
