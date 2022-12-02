package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.patterns.MovementStrategy;
import com.mygdx.game.util.ID;
/*
 * Subclase. 2do nivel. Se refiere a los personajes.
 * Podría a llegar a constituir: Jugadores, enemigos, personajes narrativos, etc.
 */
public abstract class Character extends Entity { //
	
	private float speed;	
	private int hp;
	MovementStrategy typeOfMove;
	
	public Character(Vector2 position, TextureRegion texture, float speed, int hp, ID id) {
		super(position, texture, id);
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
	
	public void setTypeOfMovement(MovementStrategy ms) {
		typeOfMove = ms;
	}
	
	public void doTypeOfMovement(float d) {
		typeOfMove.moveBehavior(d);
	}
	
}
