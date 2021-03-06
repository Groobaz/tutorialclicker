package pl.groobaz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import pl.groobaz.game.JavaDevMattClikerGame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg;
	
	public SplashScreen(final JavaDevMattClikerGame game) {
		super(game);
		//init();
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				game.setScreen(new GamePlayScreen(game));
			}
		}, 1);
	}

	@Override
	protected void init() {
		splashImg = new Texture("splash.png");
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		spriteBatch.begin();
		spriteBatch.draw(splashImg,0,0);
		spriteBatch.end();
	}
	
}
