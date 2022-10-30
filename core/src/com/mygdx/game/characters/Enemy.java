package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Meowro;

public abstract class Enemy extends Character implements Interactable {

	private int damage;
	
	public Enemy(Vector2 position, TextureRegion texture, float speed, int hp, int damage) {
		super(position, texture, speed, hp);
		this.damage = damage;
	}
	
	@Override
	public void interaction(Entity e) {
		if(e.getId() == ID.Player) {
			Player p = (Player) e;
			p.takeDamage(damage);
		}
		
		
	}
}
