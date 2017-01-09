package pl.groobaz.controller;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import pl.groobaz.entities.FlyingObject;
import pl.groobaz.entities.FlyingObject.FlyingObjectType;
import pl.groobaz.game.JavaDevMattClikerGame;

public class FlyingObjectController {

	private int spawnTime;

	public FlyingObjectController(JavaDevMattClikerGame game, Stage stage) {
		init(game, stage);
	}

	private void init(final JavaDevMattClikerGame game, final Stage stage) {
		randomizeSpawnTime();

		Timer.schedule(new Task() {

			@Override
			public void run() {
				Timer.schedule(new Task() {

					@Override
					public void run() {
						addRandomFlyingObjectToStage(game, stage);
						randomizeSpawnTime();
					}

				}, spawnTime);
			}

		}, 0, 3);
	}

	private void randomizeSpawnTime() {
		spawnTime = MathUtils.random(1, 2);
	}

	private void addRandomFlyingObjectToStage(JavaDevMattClikerGame game, Stage stage) {
		// cos tu dodaj
		FlyingObject flyingObject = null;

		if (MathUtils.randomBoolean()) {
			flyingObject = new FlyingObject(FlyingObjectType.MONEY, game);
		} else {
			flyingObject = new FlyingObject(FlyingObjectType.PASSIVE, game);
		}

		stage.addActor(flyingObject);
		flyingObject.flyLikeHell();
	}

}
