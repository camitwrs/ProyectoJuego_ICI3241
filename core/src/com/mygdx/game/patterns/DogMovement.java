package com.mygdx.game.patterns;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.characters.Dog;
import com.mygdx.game.characters.Player;

public class DogMovement implements MovementStrategy {

	Dog dg;
	Player ply;
	
	public DogMovement(Dog d, Player p) {
		dg = d;
		ply = p;
	}
	
	@Override
	public void moveBehavior(float dt) {
		Vector2 p = new Vector2();
		if(ply.getPosition().x - dg.getPosition().x <0)
			p.x=-1*dt;
		if(ply.getPosition().x - dg.getPosition().x >0)
			p.x=1*dt;
		if(ply.getPosition().y - dg.getPosition().y <0)
			p.y=-1*dt;
		if(ply.getPosition().y - dg.getPosition().y >0)
			p.y=1*dt;
		
		dg.move(p);
		
	}

}
