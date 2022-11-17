package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Meowro;
import com.mygdx.game.managers.InputManager;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;

public class Furball2 extends Attacks{
	private Vector2 bulletLocation = new Vector2(0,0);
	private Vector2 bulletVelocity = new Vector2(0,0);
	public Furball2(Vector2 position, TextureRegion texture, int damageDone) {
		super(position, texture, ID.Furball, damageDone);
	}
}
