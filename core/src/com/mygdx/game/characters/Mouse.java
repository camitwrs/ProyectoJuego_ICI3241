package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Meowro;
import com.mygdx.game.patterns.MovementStrategy;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;

public class Mouse extends Enemy {

	private int dirX;
	private int dirY;
	
	public Mouse(Vector2 position, TextureRegion texture, float speed, int hp, int dirX, int dirY) {
		super(position, texture, speed, hp, 25, ID.Mouse);
		setRect(makeRect());
		
		this.dirX = dirX;
		this.dirY = dirY;
	}

	@Override
	public void update(float dt) {
		
		this.doTypeOfMovement(dt);
			
	}

	@Override
	public void interaction(Entity e) {
		super.interaction(e);
		float dt = Gdx.graphics.getDeltaTime();
		if(e.getId() == ID.Player) { // Si es un jugador
			
			if(dirY==0 && e.getPosition().y - getPosition().y > 0) {
				dirY=1;
			}else if(dirY==0 && e.getPosition().y - getPosition().y < 0) {
				dirY=-1;
			}
		
			if(dirX==0 && e.getPosition().x - getPosition().x > 0) {
				dirX=1;
			}else if(dirX==0 && e.getPosition().x - getPosition().x < 0) {
				dirX=-1;
			}
			
			dirX*=-1;
			dirY*=-1;
			move(new Vector2(dirX*dt*5,dirY*dt*5));
			Player p = (Player) e;
			p.stop();
		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Meowro.getInstance().getBatch().begin();
		Meowro.getInstance().getBatch().setColor(Color.WHITE);
		Meowro.getInstance().getBatch().draw(getTexture(), getPosition().x, getPosition().y, Constants.PLAYER_WIDTH,
				Constants.PLAYER_WIDTH,Constants.PLAYER_WIDTH*0.6f , Constants.PLAYER_WIDTH*0.6f, 1, 1, 0);
		Meowro.getInstance().getBatch().end();
	}

	@Override
	public Rectangle makeRect() {
		return new Rectangle(getPosition().x, getPosition().y, (getTexture().getRegionWidth()*0.6f), (getTexture().getRegionHeight()*0.6f));
		
	}

	public int getDirX() {
		return dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
		
	}

	
}
