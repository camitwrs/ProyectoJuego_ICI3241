package com.mygdx.game.characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.Meowro;
import com.mygdx.game.managers.InputManager;
import com.mygdx.game.managers.ResourceManager;
import com.mygdx.game.strategyclasses.PlayerMovement;
import com.mygdx.game.util.Collidable;
import com.mygdx.game.util.Constants;
import com.mygdx.game.util.ID;
import com.mygdx.game.util.Interactable;

public class Player extends PlayerMovement implements Collidable{

	private boolean hurted;
	private long timeHurt;
	private int ammo;
	private Furball fb;
	
	public Player(Vector2 position, TextureRegion texture, float speed, int hp) {
		super(position, texture, speed, hp, ID.Player);
		setRect(makeRect());
		ammo = 40;
	}

	//@Override
	public void update(float dt) {
		// Comprueba que no se salga de los bordes de la pantalla 
		if (getPosition().x <= 0)
			getPosition().x = 0;
		if(getPosition().y < 0)
			getPosition().y = 0;
		if ((getPosition().x + getTexture().getRegionWidth() >= Constants.SCREEN_WIDTH))
			getPosition().x = Constants.SCREEN_WIDTH - getTexture().getRegionWidth();
		if ((getPosition().y + getTexture().getRegionWidth() >= Constants.SCREEN_HEIGHT))
			getPosition().y = Constants.SCREEN_HEIGHT - getTexture().getRegionHeight();
		if (hurted && TimeUtils.nanoTime() - timeHurt < Constants.SECOND/4)
			return;
		else {
			hurted = false;
			timeHurt = TimeUtils.nanoTime();
		}
		if(InputManager.getInstance().isGoingLeft())
			this.move(new Vector2(-1 * dt , 0));
		if(InputManager.getInstance().isGoingRight())
			this.move(new Vector2(1 * dt , 0));
		if(InputManager.getInstance().isGoingDown())
			this.move(new Vector2(0 , -1 * dt));
		if(InputManager.getInstance().isGoingUp())
			this.move(new Vector2(0 , 1 * dt));
		if(InputManager.getInstance().mouseClicked(getRect()) != null) {
			Vector2 posMouse = new Vector2();
			posMouse = InputManager.getInstance().mouseClicked(getRect());
			System.out.println("2"+posMouse.toString());
			fb = new Furball(new Vector2(getRect().x,getRect().y),ResourceManager.getInstance().getAtlas().findRegion("Mi_proyecto_64x64"),1000,posMouse);
			ammo-=1;
			//fb.update(dt); // Se dispara la bala.
		}
		
		
	}
	
	//@Override
	public void checkCollision(Interactable i) {
		if (getRect().overlaps(i.getRect())) {
			
			i.interaction(this);
		}
	}

	public void stop() {
		hurted = true;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Meowro.getInstance().getBatch().begin();
		Meowro.getInstance().getBatch().setColor(Color.WHITE);
		Meowro.getInstance().getBatch().draw(getTexture(), getPosition().x, getPosition().y, Constants.PLAYER_WIDTH,
				Constants.PLAYER_WIDTH,Constants.PLAYER_WIDTH , Constants.PLAYER_WIDTH, 1, 1, 0);
		Meowro.getInstance().getBatch().end();
		if (fb != null) {
			fb.render();
		}
	}
	
	public Furball getFurball() {
		return fb;
	}

	//@Override
	public Rectangle makeRect() {
		// TODO Auto-generated method stub
		return new Rectangle(getPosition().x, getPosition().y, getTexture().getRegionWidth(), getTexture().getRegionHeight());

	}
}
