package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.ID;
/*
 * Subclase. 2do nivel. Se refiere a los items/objetos. 
 * Podría llegar a constituir: Subtipos de recolectables (Moneda, Vida, Cofre, etc) y ataques (Golpe, Hechizo, etc) 
 */
public abstract class Item extends Entity { 
	
	public Item(Vector2 position, TextureRegion texture, ID id) {
		super(position, texture, id);
	}



}
