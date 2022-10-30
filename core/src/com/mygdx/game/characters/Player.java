package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.managers.InputManager;
import com.mygdx.game.util.Constants;

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
		if ((getPosition().y + getTexture().getRegionWidth() >= Constants.SCREEN_WIDTH))
			getPosition().y = Constants.SCREEN_HEIGHT - getTexture().getRegionHeight();
		
		move(InputManager.getInstance().getInputMove(), dt);
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
