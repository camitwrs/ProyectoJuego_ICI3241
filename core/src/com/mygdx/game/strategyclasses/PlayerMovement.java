package com.mygdx.game.strategyclasses;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.managers.InputManager;
import com.mygdx.game.patterns.MovementStrategy;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;
import com.mygdx.game.util.Interactable;
import com.mygdx.game.characters.Character;
import com.mygdx.game.util.Collidable;

public class PlayerMovement  extends Character implements MovementStrategy, Collidable{
	public PlayerMovement(Vector2 position, TextureRegion texture, float speed, int hp, ID id) {
		super(position, texture, speed, hp, id);
		setRect(makeRect());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update (float dt) {
		if (getPosition().x <= 0)
			getPosition().x = 0;
		if(getPosition().y < 0)
			getPosition().y = 0;
		if ((getPosition().x + getTexture().getRegionWidth() >= Constants.SCREEN_WIDTH))
			getPosition().x = Constants.SCREEN_WIDTH - getTexture().getRegionWidth();
		if ((getPosition().y + getTexture().getRegionWidth() >= Constants.SCREEN_HEIGHT))
			getPosition().y = Constants.SCREEN_HEIGHT - getTexture().getRegionHeight();
		//if (hurted && TimeUtils.nanoTime() - timeHurt < Constants.SECOND/4)
		//	return;
		//else {
		//	hurted = false;
		//	timeHurt = TimeUtils.nanoTime();
		//}
		if(InputManager.getInstance().isGoingLeft())
			this.move(new Vector2(-1 * dt , 0));
		if(InputManager.getInstance().isGoingRight())
			this.move(new Vector2(1 * dt , 0));
		if(InputManager.getInstance().isGoingDown())
			this.move(new Vector2(0 , -1 * dt));
		if(InputManager.getInstance().isGoingUp())
			this.move(new Vector2(0 , 1 * dt));
	}

	@Override
	public Rectangle makeRect() {
		// TODO Auto-generated method stub
		return new Rectangle(getPosition().x, getPosition().y, getTexture().getRegionWidth(), getTexture().getRegionHeight());

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkCollision(Interactable i) {
		// TODO Auto-generated method stub
if (getRect().overlaps(i.getRect())) {
			
			i.interaction(this);
		}
		
	}
	

}
