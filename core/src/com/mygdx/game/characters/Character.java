package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class Character extends Entity { // Clase hija de los 
	
	private float speed;	
	private int hp;
	
	public Character(Vector2 position, TextureRegion texture, float speed, int hp) {
		super(position, texture);
		this.speed = speed;
		this.hp = hp;
	}


	public void move(Vector2 direction, float delta) {
		
		if(direction.x < 0)
			getPosition().x -= speed * delta;
		if(direction.x > 0)
			getPosition().x += speed * delta;
		if(direction.y < 0)
			getPosition().y -= speed * delta;
		if(direction.y > 0)
			getPosition().y += speed * delta;
		
		updateRect();
		//System.out.println(getPosition());
	}


	
	public void takeDamage(int damage) {
		hp -= damage;
		System.out.println(hp);
	}


	
	
}
