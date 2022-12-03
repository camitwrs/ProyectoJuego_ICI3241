package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.BaseGameSingleton;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;

public class Furball extends Attacks {
	
	//private Vector2 posMouse;
	//private float vel = 100f;
	private Vector2 dst = new Vector2(0,0);

	public Furball(Vector2 position, TextureRegion texture, int damageDone, Vector2 posMouse) {
		super(position, texture, ID.Furball, damageDone);
		setRect(makeRect());

		dst = posMouse.sub(getPosition());
		dst.y *=-1;
	}
	

	@Override
	public void update(float dt) {
		setPosition(getPosition().mulAdd(dst, dt));
	}

	@Override
	public void render() {
		BaseGameSingleton.getInstance().getBatch().begin();
		BaseGameSingleton.getInstance().getBatch().draw(getTexture(), getPosition().x, getPosition().y, Constants.PLAYER_WIDTH,
				Constants.PLAYER_WIDTH,Constants.PLAYER_WIDTH*0.6f , Constants.PLAYER_WIDTH*0.6f, 1, 1, 0);
		BaseGameSingleton.getInstance().getBatch().end();
	}


	@Override
	public Rectangle makeRect() {
		return new Rectangle(getPosition().x, getPosition().y, getTexture().getRegionWidth()*0.6f, getTexture().getRegionHeight()*0.6f);
	}

}
