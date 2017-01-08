package pl.groobaz.screen;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.groobaz.entities.Player;
import pl.groobaz.game.JavaDevMattClikerGame;

public class GamePlayScreen extends AbstractScreen {

	private Player player; 
	private Button playerButton, resetScoreButton;
	private Label scoreLabel;
	
	public GamePlayScreen(JavaDevMattClikerGame game) {
		super(game);
	}

	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
	}

	private void initResetScoreButton() {
		resetScoreButton = new Button(new ButtonStyle());//dzieki temu bêdzie przezroczysty
		resetScoreButton.setWidth(100);
		resetScoreButton.setHeight(100);
		resetScoreButton.setX(330);
		resetScoreButton.setY(560);
		resetScoreButton.setDebug(true);
		
		stage.addActor(resetScoreButton);
		
		resetScoreButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				game.resetGameScore();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initScoreLabel() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		scoreLabel = new Label("", labelStyle);
		scoreLabel.setX(20);
		scoreLabel.setY(650);
		stage.addActor(scoreLabel);
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
				player.reactOnClick();
				game.addPoint();
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
		
		//System.out.println("Points: " + game.getPoints());
		
		spriteBatch.begin();
		stage.draw();
		
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}
	
}
