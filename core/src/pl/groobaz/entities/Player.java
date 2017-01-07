package pl.groobaz.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image {

	private final static int WIDTH = 77;
	private final static int HEIGHT = 152;
	private final static int STARTING_X = 200;
	private final static int STARTING_Y = 300;
	
	public Player(){
		super(new Texture("badlogic.jpg"));
				
		this.setOrigin(WIDTH / 2, HEIGHT / 2);
		this.setSize(WIDTH, HEIGHT);
		
		//starting position
		this.setPosition(STARTING_X, STARTING_Y);
	}

	public void reactOnClick() {
		//Action testAction = Actions.moveBy(10, 10);
		//this.addAction(testAction);
		int moveAmmount = MathUtils.random(-130, 130);
		Action moveAction = Actions.sequence(
				Actions.moveBy(moveAmmount, 10, 0.3f, Interpolation.circleOut),
				Actions.moveBy(-moveAmmount, -10, 0.3f, Interpolation.circle)
		);
		
		int growAmmount = MathUtils.random(-30, 100);
		Action growAction = Actions.sequence(
				Actions.sizeBy(growAmmount, 20, 0.2f, Interpolation.circleOut),
				Actions.sizeBy(-growAmmount, -20, 0.2f, Interpolation.circle)
		);
		
		this.addAction(moveAction);
		this.addAction(growAction);
		if(this.getHeight() > 170){
			this.addAction(Actions.rotateBy(MathUtils.randomSign() * 360, 0.4f));
		}
	}
	
}
