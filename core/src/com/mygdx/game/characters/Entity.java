package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;
/*
 * Clase suprema. 1er nivel. Engloba todo.
 */
public abstract class Entity { 
	private Vector2 position;
	private TextureRegion texture;
	private Rectangle rect;
	private ID id;

	
	public Entity(Vector2 position, TextureRegion texture, ID id) {
		this.position = position;
		this.texture = texture;
		this.id = id;
		
		if(id == ID.Mouse)
			rect = new Rectangle(position.x, position.y, (texture.getRegionWidth()*0.6f), (texture.getRegionHeight()*0.6f));
		else
			rect = new Rectangle(position.x, position.y, texture.getRegionWidth(), texture.getRegionHeight());
	}
	
	public abstract void update(float dt);

	
	// Dibuja la entidad en pantalla.
	public abstract void render();
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void setPositionX(float x) {
		this.position.x = x;
	}
	
	public void setPositionY(float y) {
		this.position.y = y;
	}
	
	public void setPosition(Vector2 v) {
		this.position = v;
	}
	

	public Rectangle getRect() {
		return rect;
	}
	
	public TextureRegion getTexture() {
		return texture;
	}
	
	public ID getId() {
		return id;	
	}
	
	public void updateRect() {
		rect.x = position.x;
		rect.y = position.y;
	}

}
