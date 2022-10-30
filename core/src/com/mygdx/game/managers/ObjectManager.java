package com.mygdx.game.managers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Meowro;
import com.mygdx.game.characters.*;
import com.mygdx.game.util.*;

public class ObjectManager {
	private ResourceManager resManager;	

    private Player player;
    private Array<Enemy> enemies = new Array<>();
    
    public ObjectManager(ResourceManager res) {
    	resManager = res;
    	generatePlayer();
    	generateEnemies();
    }
    
    public void generatePlayer() {
    	player = new Player(new Vector2(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2),  resManager.getAtlas().findRegion("wolfFront"),100f,200);
    }
    
    public void generateEnemies(){
    	if(enemies.size < 20) {
    		int x = MathUtils.random(0, Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH);
        	int y = MathUtils.random(0, Constants.SCREEN_HEIGHT - Constants.PLAYER_WIDTH);
            Enemy enemy = new Mouse(new Vector2(x, y),  resManager.getAtlas().findRegion("jiniretFront"),200f,100);
            enemies.add(enemy);
    	}
    }
    
    public void render(float dt) {
    	Meowro.getInstance().getBatch().begin();
    	
    	for(Enemy en : enemies) {
    		en.render(Meowro.getInstance().getBatch());
    		en.update(dt);
    		player.checkCollision(en);
    	}
    	
    	player.render(Meowro.getInstance().getBatch());
    	player.update(dt);
    	
    	Meowro.getInstance().getBatch().end();
    	generateEnemies();
    }
    
    public void deleteEnemy(Enemy enemy) {
    	enemies.removeValue(enemy, false);
    }
    
}
