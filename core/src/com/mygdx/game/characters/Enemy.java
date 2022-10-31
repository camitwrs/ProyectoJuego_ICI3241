package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Meowro;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;
import com.mygdx.game.util.Interactable;
/*
 * Subclase. 3er nivel. Se refiere a los enemigos. 
 * Podría llegar a constituir: Subtipos de enemigos (Mouse, Dog, etc) y jefes (Boss, FinalBoss, etc)
 */
public abstract class Enemy extends Character implements Interactable { 

	private int damage;
	
	public Enemy(Vector2 position, TextureRegion texture, float speed, int hp, int damage) {
		super(position, texture, speed, hp);
		this.damage = damage;
	}
	
	@Override
	public void interaction(Entity e) {
		if(e.getId() == ID.Player) { // Si es un jugador
			Player p = (Player) e;
			p.takeDamage(damage);
		}
	}
	public int outBounds() {
		if (getPosition().x <= 0)
			return 1;
		if(getPosition().y < 0)
			return 2;
		if ((getPosition().x + getTexture().getRegionWidth() >= Constants.SCREEN_WIDTH))
			return 1;
		if ((getPosition().y + getTexture().getRegionWidth() >= Constants.SCREEN_HEIGHT))
			return 2;
		return 0;
		
	}
}