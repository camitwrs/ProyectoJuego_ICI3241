package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Mouse extends Enemy {

	public Mouse(Vector2 position, TextureRegion texture, float speed, int hp) {
		super(position, texture, speed, hp, 25);
	}

	@Override
	public void update(float dt) {
		
		
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
