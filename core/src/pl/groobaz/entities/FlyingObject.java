package pl.groobaz.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sun.xml.internal.ws.assembler.dev.TubelineAssemblyContextUpdater;

import pl.groobaz.game.JavaDevMattClikerGame;

public class FlyingObject extends Image {

	public enum FlyingObjectType {
		MONEY, PASSIVE
	}

	public final static String MONEY = "money.png";
	public final static String BOOKS = "books.png";

	private final static int WIDTH = 80;
	private final static int HEIGHT = 80;

	private final static int STARTING_X_1 = 0;
	private final static int STARTING_X_2 = JavaDevMattClikerGame.WIDTH;
	private final static int STARTING_Y = -100; // startuje poza ekranem;
	private int startingX;
	
	private JavaDevMattClikerGame game;

	private FlyingObjectType type;

	public FlyingObject(FlyingObjectType type, JavaDevMattClikerGame game) {
		super(new Texture(getTextureString(type)));
		this.type = type;
		this.game = game;
		this.setOrigin(WIDTH / 2, HEIGHT / 2);
		this.setSize(WIDTH, HEIGHT);

		// starting position
		startingX = MathUtils.randomBoolean() ? STARTING_X_1 : STARTING_X_2;
		this.setPosition(startingX, STARTING_Y);

		this.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				reactOnClick();
				FlyingObject.this.remove();
				return super.touchDown(event, x, y, pointer, button);
			}

		});

	}

	private void reactOnClick() {
		if (FlyingObjectType.MONEY.equals(type)) {
			game.addPoints(50);
		} else if(FlyingObjectType.PASSIVE.equals(type)){
			game.addPassiveIncome();
		}
	}

	private static String getTextureString(FlyingObjectType type) {
		if (FlyingObjectType.MONEY.equals(type)) {
			return MONEY;
		} else if (FlyingObjectType.PASSIVE.equals(type)) {
			return BOOKS;
		}

		return "";
	}

	public void flyLikeHell() {
		
		int xSign = (startingX == STARTING_X_1)? 1 : -1;
		int time1 = MathUtils.random(1,4);
		int time2 = MathUtils.random(1,4);
		int randomYEffect = MathUtils.random(-100,500);
		
		Action a = Actions.parallel(Actions.moveBy(xSign * 300 + (MathUtils.random(-200,200)), 200 + randomYEffect, time1), Actions.rotateBy(360, time1));
		Action b = Actions.parallel(Actions.moveBy(xSign * -500, 900, time2), Actions.rotateBy(360, time2));
		Action c = Actions.run(new Runnable() {
			@Override
			public void run() {
				FlyingObject.this.remove();
			}
		});
		this.addAction(Actions.sequence(a, b, c));
	}
}
