package com.mygdx.game.patterns;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.characters.Mouse;

public class MouseMovement implements MovementStrategy{
	
	Mouse m;
	
	public MouseMovement(Mouse m) {
		this.m = m;
	}

	@Override
	public void moveBehavior(float dt) {
		if (m.outBounds() == 1) {
			m.setDirX(m.getDirX() * -1);
		}else if(m.outBounds() == 2) {
			m.setDirY(m.getDirY() * -1);
		}
			
		m.move(new Vector2(m.getDirX()*dt, m.getDirY()*dt));	
		
	}

}
