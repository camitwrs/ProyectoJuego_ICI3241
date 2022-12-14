package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.BaseGameSingleton;
import com.mygdx.game.patterns.MovementStrategy;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;

public class Dog extends Enemy {
	Player player;
	
	public Dog(Vector2 position, TextureRegion texture, float speed, int hp, Player player) {
		super(position, texture, speed, hp, 50, ID.Dog);
		setRect(makeRect());
		this.player = player;
	}
	

	@Override
	public void update(float dt) {
		
		this.doTypeOfMovement(dt);
		
	}


	@Override
	public void render() {
		BaseGameSingleton.getInstance().getBatch().begin();
		BaseGameSingleton.getInstance().getBatch().setColor(Color.BROWN);
		BaseGameSingleton.getInstance().getBatch().draw(getTexture(), getPosition().x, getPosition().y, Constants.PLAYER_WIDTH,
				Constants.PLAYER_WIDTH,Constants.PLAYER_WIDTH , Constants.PLAYER_WIDTH, 1, 1, 0);
		BaseGameSingleton.getInstance().getBatch().end();
	}


	@Override
	public Rectangle makeRect() {
		return new Rectangle(getPosition().x, getPosition().y, getTexture().getRegionWidth(), getTexture().getRegionHeight());
	}

}
