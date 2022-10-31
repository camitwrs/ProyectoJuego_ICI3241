package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;

public class Mouse extends Enemy {

	private int randomX;
	private int randomY;
	
	public Mouse(Vector2 position, TextureRegion texture, float speed, int hp, int randomX, int randomY) {
		super(position, texture, speed, hp, 25);
		this.randomX = randomX;
		this.randomY = randomY;
	}

	@Override
	public void update(float dt) {
		if (outBounds() == 1) {
			randomX*=-1;
		}else if(outBounds() == 2) {
			randomY*=-1;
		}
			
		move(new Vector2(randomX*dt, randomY*dt));
		
		
	}

	@Override
	public ID getId() {
		return ID.Mouse;
	}

	/*
	@Override
	public void interaction(Entity e) {
		super.interaction(e);
	}*/
}
