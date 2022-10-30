package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.ID;
/*
 * Clase suprema. 1er nivel. Engloba todo.
 */
public abstract class Entity { 
	private Vector2 position;
	private TextureRegion texture;
	private Rectangle rect;
	
	public Entity(Vector2 position, TextureRegion texture) {
		this.position = position;
		this.texture = texture;
		
		rect = new Rectangle(position.x, position.y, (int)(texture.getRegionWidth() * 0.71875f), (int)(texture.getRegionHeight()*0.875));
	}
	
	public abstract void update(float dt);
	public abstract ID getId();
	
	// Dibuja la entidad en pantalla.
	public void render(SpriteBatch batch) {
		batch.draw(getTexture(), getPosition().x, getPosition().y);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void setPositionX(int x) {
		this.position.x = x;
	}
	
	public void setPositionY(int y) {
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
	
	public void updateRect() {
		rect.x = position.x;
		rect.y = position.y;
	}
}
