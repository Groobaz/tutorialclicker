package pl.groobaz.screen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.groobaz.entities.Player;
import pl.groobaz.game.JavaDevMattClikerGame;

public class GamePlayScreen extends AbstractScreen {

	private Player player; 
	private Button playerButton;
	
	public GamePlayScreen(JavaDevMattClikerGame game) {
		super(game);
	}

	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
	}

	private void initPlayerButton() {
		playerButton = new Button(new ButtonStyle());//dzieki temu bêdzie przezroczysty
		playerButton.setWidth(460);
		playerButton.setHeight(360);
		playerButton.setX(10);
		playerButton.setY(170);
		//tymczasowo ma byc widoczny , na czas projektu
		playerButton.setDebug(true);
		
		stage.addActor(playerButton);
		playerButton.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return super.touchDown(event, x, y, pointer, button);
			}
			
		});
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
