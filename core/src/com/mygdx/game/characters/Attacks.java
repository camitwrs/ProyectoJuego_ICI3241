package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.ID;
/*
 * Subclase. 2do nivel. Se refiere a los ataques.
 * Podría a llegar a constituir: Golpes, disparos, etc.
 */
public abstract class Attacks extends Entity{

	int damageDone;
	
	public Attacks(Vector2 position, TextureRegion texture, ID id, int damageDone) {
		super(position, texture, id);
		this.damageDone = damageDone;
	}
	
	
}
