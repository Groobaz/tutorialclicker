package pl.groobaz.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import pl.groobaz.entities.FlyingObject;
import pl.groobaz.entities.FlyingObject.FlyingObjectType;
import pl.groobaz.entities.Player;
import pl.groobaz.game.JavaDevMattClikerGame;
import pl.groobaz.screen.ui.IClickCallback;
import pl.groobaz.screen.ui.PlayerButton;
import pl.groobaz.screen.ui.ResetScoreButton;
import pl.groobaz.screen.ui.ScoreLabel;

public class GamePlayScreen extends AbstractScreen {

	private Image bgImg;
	private Player player; 
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;
	private FlyingObject flyingObject1;
	
	public GamePlayScreen(JavaDevMattClikerGame game) {
		super(game);
	}

	@Override
	protected void init() {
		initBg();
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
		initFlyingObjects();
	}

	private void initFlyingObjects() {
		flyingObject1 = new FlyingObject(FlyingObjectType.MONEY, game);
		stage.addActor(flyingObject1);
		flyingObject1.flyLikeHell();
	}

	private void initBg() {
		bgImg = new Image(new Texture("bg.png"));
		stage.addActor(bgImg);
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
		
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}
	
}
