package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;

public class Mouse extends Enemy {

	private int dirX;
	private int dirY;
	
	public Mouse(Vector2 position, TextureRegion texture, float speed, int hp, int randomX, int randomY) {
		super(position, texture, speed, hp, 25);
		dirX = randomX;
		dirY = randomY;
	}

	@Override
	public void update(float dt) {
		if (outBounds() == 1) {
			dirX*=-1;
		}else if(outBounds() == 2) {
			dirY*=-1;
		}
			
		move(new Vector2(dirX*dt, dirY*dt));
		
		
	}

	@Override
	public ID getId() {
		return ID.Mouse;
	}


	@Override
	public void interaction(Entity e) {
		super.interaction(e);
		if(e.getId() == ID.Player) { // Si es un jugador
			dirX *=-1;
			dirY *=-1;
			Player p = (Player) e;
			p.stop();
		}
	}
}
