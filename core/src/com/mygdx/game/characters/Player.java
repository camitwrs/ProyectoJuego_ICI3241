package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.managers.InputManager;
import com.mygdx.game.util.Collidable;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;
import com.mygdx.game.util.Interactable;

public class Player extends Character implements Collidable{

	public Player(Vector2 position, TextureRegion texture, float speed, int hp) {
		super(position, texture, speed, hp);
	}

	@Override
	public void update(float dt) {
		// Comprueba que no se salga de los bordes de la pantalla 
		if (getPosition().x <= 0)
			getPosition().x = 0;
		if(getPosition().y < 0)
			getPosition().y = 0;
		if ((getPosition().x + getTexture().getRegionWidth() >= Constants.SCREEN_WIDTH))
			getPosition().x = Constants.SCREEN_WIDTH - getTexture().getRegionWidth();
		if ((getPosition().y + getTexture().getRegionWidth() >= Constants.SCREEN_HEIGHT))
			getPosition().y = Constants.SCREEN_HEIGHT - getTexture().getRegionHeight();
		
		if(InputManager.getInstance().isGoingLeft())
			this.move(new Vector2(-1 * dt , 0));
		if(InputManager.getInstance().isGoingRight())
			this.move(new Vector2(1 * dt , 0));
		if(InputManager.getInstance().isGoingDown())
			this.move(new Vector2(0 , -1 * dt));
		if(InputManager.getInstance().isGoingUp())
			this.move(new Vector2(0 , 1 * dt));
		
	}

	@Override
	public void checkCollision(Interactable i) {
		if (this.getRect().overlaps(i.getRect()))
			i.interaction(this);
	}

	@Override
	public ID getId() {
		return ID.Player;
	}

}
