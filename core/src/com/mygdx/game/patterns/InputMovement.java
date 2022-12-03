package com.mygdx.game.patterns;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.characters.Player;
import com.mygdx.game.managers.InputManagerSingleton;
import com.mygdx.game.util.Constants;

public class InputMovement implements MovementStrategy {
	
	Player p;
	
	public InputMovement(Player p) {
		this.p = p;
	}

	@Override
	public void moveBehavior(float dt) {
		
		// Movimiento respecto límites de pantalla
		
		if (p.getPosition().x <= 0) p.getPosition().x = 0;
		if(p.getPosition().y < 0) p.getPosition().y = 0;
		if ((p.getPosition().x + p.getTexture().getRegionWidth() >= Constants.SCREEN_WIDTH))
			p.getPosition().x = Constants.SCREEN_WIDTH - p.getTexture().getRegionWidth();
		if ((p.getPosition().y + p.getTexture().getRegionWidth() >= Constants.SCREEN_HEIGHT))
			p.getPosition().y = Constants.SCREEN_HEIGHT - p.getTexture().getRegionHeight();
				
		// Movimiento respecto input
				
		if(InputManagerSingleton.getInstance().isGoingLeft())
			p.move(new Vector2(-1 * dt , 0));
		if(InputManagerSingleton.getInstance().isGoingRight())
			p.move(new Vector2(1 * dt , 0));
		if(InputManagerSingleton.getInstance().isGoingDown())
			p.move(new Vector2(0 , -1 * dt));
		if(InputManagerSingleton.getInstance().isGoingUp())
			p.move(new Vector2(0 , 1 * dt));	
				
	}
		
}

