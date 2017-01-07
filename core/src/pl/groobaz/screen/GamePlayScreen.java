package pl.groobaz.screen;

import pl.groobaz.entities.Player;
import pl.groobaz.game.JavaDevMattClikerGame;

public class GamePlayScreen extends AbstractScreen {

	private Player player; 
	
	public GamePlayScreen(JavaDevMattClikerGame game) {
		super(game);
		init();
		
	}

	private void init() {
		initPlayer();
	}

	private void initPlayer() {
		 player = new Player();
		 stage.addActor(player);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		update();
		
		spriteBatch.begin();
		stage.draw();
		
		spriteBatch.end();
	}

	private void update() {
		stage.act();
	}
	
}
