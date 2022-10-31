package com.mygdx.game.managers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Meowro;
import com.mygdx.game.GameOverScreen;
import com.mygdx.game.characters.Enemy;
import com.mygdx.game.characters.Mouse;
import com.mygdx.game.characters.Player;
import com.mygdx.game.util.Constants;

public class ObjectManager {
	private ResourceManager resManager;
	ShapeRenderer shapeRenderer = new ShapeRenderer();

    private Player player;
    private Array<Enemy> enemies;
    private boolean debug = false;
    
    // Controla a que ritmo van apareciendo las distintas entidades
    private long lastItem; // Para cuando spawneemos objetos.
    private long lastEnemy;
    private float gameTime; // Por si más adelante le ponemos límite de tiempo.
    
    public ObjectManager(ResourceManager res) {
    	resManager = res;
    	//generatePlayer();
    	//generateEnemies();
    	init();
    }
    
    private void init() {
    	// Representa al player en el juego
    	generatePlayer();
    	// Genera los enemigos
    	enemies = new Array<>();
    	generateMouses();
    }
    
    public void generatePlayer() {
    	player = new Player(new Vector2(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2),  resManager.getAtlas().findRegion("wolfFront"),200f,1000);
    }
    
    private int getRandomX() {
    	return MathUtils.random(0, Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH);
    }
    
    private int getRandomY() {
    	return MathUtils.random(0, Constants.SCREEN_HEIGHT - Constants.PLAYER_WIDTH);
    }
    private int random() {
    	if (MathUtils.random(1,10)>7)
    		return 1;
    	else if(MathUtils.random(1,10)>4)
    		return -1;
    	return 0;
    }
    public void generateMouses(){
    	if(enemies.size < 20) {
    		Vector2 pos = new Vector2(getRandomX(), getRandomY());
    		int x= random();
    		int y = random();
    		if(x==0 && y==0)
    			y=1;
    		if (Math.abs(pos.x - player.getPosition().x) >= Constants.PLAYER_WIDTH/2 &&
    				Math.abs(pos.y - player.getPosition().y) >= Constants.PLAYER_WIDTH/2) {
    			pos = new Vector2(pos.x-10,pos.y-10);
    		}
        	Enemy enemy = new Mouse(pos,  resManager.getAtlas().findRegion("jiniretFront"),200f,100,x,y);
            enemies.add(enemy);
            lastEnemy = TimeUtils.nanoTime();
    	}
    }
    
    public void render() {
    	Meowro.getInstance().getBatch().begin();
    	if (debug) {
    		shapeRenderer.begin(ShapeType.Line);
    		shapeRenderer.setColor(Color.RED);
    		shapeRenderer.rect(player.getRect().x, player.getRect().y, player.getRect().height, player.getRect().width);
    	
    	}
    	
    	///////////////////////////////////////////////

    	player.render(Meowro.getInstance().getBatch());
    	
    	for(Enemy en : enemies) {
    		en.render(Meowro.getInstance().getBatch());		
    		if (debug) {
    			shapeRenderer.setColor(Color.BLUE);
    			shapeRenderer.rect(en.getRect().x, en.getRect().y, en.getRect().height, en.getRect().width);
    		}
    	}
    	
    	Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Puntos: " + Meowro.getInstance().getScore(), 10, 490);
    	Meowro.getInstance().getFont().draw(Meowro.getInstance().getBatch(), "Salud: " + player.getHp(), 10, 470);
    	///////////////////////////////////////////////
    	Meowro.getInstance().getBatch().end();
		
        
        
        
        shapeRenderer.end();
    	//generateEnemies();
    }
    
    public void update(float dt) {
		
    	Meowro.getInstance().setScore(Meowro.getInstance().getScore() + 1); // Para que el puntaje vaya aumentando.
    	
    	player.update(dt);
    	
		// Genera nuevos enemigos desde el último tiempo.
    	if (TimeUtils.nanoTime() - lastEnemy > Constants.SECOND)
    		generateMouses();
    	
    	// Por cada enemigo:
    	for(int i = 0 ; i < enemies.size ; i++) {
    		
    		Enemy en = enemies.get(i);
    		en.update(dt);
    		
    		player.checkCollision(en); // Chequea colisión con ese enemigo
    		if(player.getHp() <= 0) {
    			dispose();
    			Meowro.getInstance().setScreen(new GameOverScreen());
    		}
    	}
    	
    }
    
    public void deleteEnemy(Enemy enemy) {
    	enemies.removeValue(enemy, false);
    }
    
    public void dispose() {
    	resManager.dispose();
    	enemies.clear();
    }
}
