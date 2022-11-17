package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Meowro;
import com.mygdx.game.managers.InputManager;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;

public class Furball extends Attacks {
	
	private Vector2 posMouse;
	private float vel = 100f;
	private Vector2 dst = new Vector2(0,0);

	public Furball(Vector2 position, TextureRegion texture, int damageDone, Vector2 posMouse) {
		super(position, texture, ID.Furball, damageDone);
		//this.posMouse = posMouse;
		dst = posMouse.sub(getPosition());
		dst.y *=-1;
		//System.out.println(prb.toString());
		//vel.x = (posMouse.x - position.x)/10;
		//vel.y = (posMouse.y - position.y)/10;
	}
	

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		//setPositionX((getPosition().x+vel.x));
		//setPositionY((getPosition().y+vel.y));
		//dst = getPosition().mulAdd(dst, dt);
		//System.out.println(prb.toString());
		//prb = prb.
		setPosition(getPosition().mulAdd(dst, dt));
		
		//posMouse.x = InputManager.getInstance().getPosMouseX();
		//posMouse.y = InputManager.getInstance().getPosMouseY();
		
		//move(posMouse);
		/*Vector2 p = new Vector2();
		
		
		p.x = posMouse.x-getPosition().x;
		p.y = posMouse.y-getPosition().y;
		/*if(posMouse.x-getPosition().x >0)
			p.x=1*dt;
		if(posMouse.y-getPosition().y <0)
			p.y=-1*dt;
		if(posMouse.y-getPosition().y >0)*/
		//move(vel.scl(dt), dt);
	}

	@Override
	public void render() {
		Meowro.getInstance().getBatch().begin();
		Meowro.getInstance().getBatch().setColor(Color.BLUE);
		Meowro.getInstance().getBatch().draw(getTexture(), getPosition().x, getPosition().y, Constants.PLAYER_WIDTH,
				Constants.PLAYER_WIDTH,Constants.PLAYER_WIDTH*0.6f , Constants.PLAYER_WIDTH*0.6f, 1, 1, 0);
		Meowro.getInstance().getBatch().end();
	}

}
