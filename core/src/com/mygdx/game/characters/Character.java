package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
/*
 * Subclase. 2do nivel. Se refiere a los personajes.
 * Podría a llegar a constituir: Jugadores, enemigos, personajes narrativos, etc.
 */
public abstract class Character extends Entity { //
	
	private float speed;	
	private int hp;
	
	public Character(Vector2 position, TextureRegion texture, float speed, int hp) {
		super(position, texture);
		this.speed = speed;
		this.hp = hp;
	}

	public void move(Vector2 movement) {
		
		movement.scl(speed);
		getPosition().add(movement);
		updateRect();
	}
	
	public void takeDamage(int damage) {
		hp -= damage;
	}

	public int getHp() {
		return hp;
	}
	
	

	
	
}
