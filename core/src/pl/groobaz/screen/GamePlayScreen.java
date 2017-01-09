package pl.groobaz.screen;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import pl.groobaz.entities.Player;
import pl.groobaz.game.JavaDevMattClikerGame;
import pl.groobaz.screen.ui.IClickCallback;
import pl.groobaz.screen.ui.PlayerButton;
import pl.groobaz.screen.ui.ResetScoreButton;
import pl.groobaz.screen.ui.ScoreLabel;

public class GamePlayScreen extends AbstractScreen {

	private Player player; 
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;
	
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
		resetScoreButton = new ResetScoreButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				game.resetGameScore();
			}
		});
		
		stage.addActor(resetScoreButton);
	}

	private void initScoreLabel() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}

	private void initPlayerButton() {
		playerButton = new PlayerButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				player.reactOnClick();
				game.addPoint();
			}
		});
		stage.addActor(playerButton);
	
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
