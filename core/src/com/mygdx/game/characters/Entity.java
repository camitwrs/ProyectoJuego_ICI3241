package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity { // Clase superpadre
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
