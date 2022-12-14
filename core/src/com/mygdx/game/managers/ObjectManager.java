package com.mygdx.game.managers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.BaseGameSingleton;
import com.mygdx.game.GameOverScreen;
import com.mygdx.game.characters.Dog;
import com.mygdx.game.characters.Enemy;
import com.mygdx.game.characters.Furball;
import com.mygdx.game.characters.Item;
import com.mygdx.game.characters.Mouse;
import com.mygdx.game.characters.Player;
import com.mygdx.game.util.Constants;
import com.mygdx.game.patterns.*;

public class ObjectManager {
	
	
    private Player player;
    private Furball fb; 
    private Array<Enemy> enemies;
    private Array<Item> items;
    
    private boolean debug = true;
    
    // Controla a que ritmo van apareciendo las distintas entidades
    //private long lastItem; // Para cuando spawneemos objetos.
    private long lastEnemy;
    //private float gameTime; // Por si más adelante le ponemos límite de tiempo.
    
    public ObjectManager() {
    	init();
    }
    
    private void init() {
    	//generateBall();
    	// Representa al player en el juego
    	generatePlayer();
    	// Genera los enemigos
    	enemies = new Array<>();

    }
    public void generatePlayer() {
    	player = new Player(new Vector2(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2),
    			ResourceManagerSingleton.getInstance().getAtlas().findRegion("wolfFront"),200f,1000);
    	
    	player.setTypeOfMovement(new InputMovement(player));
    }
    
    //posX Random
    private int getRandomX() {
    	return MathUtils.random(0, Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH);
    }
    //posY Random
    private int getRandomY() {
    	return MathUtils.random(0, Constants.SCREEN_HEIGHT - Constants.PLAYER_WIDTH);
    }

    private Vector2 getPosDog() {
    	int posX;
    	int posY;
    	posX = MathUtils.random(0, Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH);
    	if (posX > 0 && posX < Constants.SCREEN_WIDTH) {
    		if(MathUtils.random(1,2) == 1 )
    			posY = 0;
    		else
    			posY = Constants.SCREEN_HEIGHT;
    	}else
    		posY = MathUtils.random(0, Constants.SCREEN_HEIGHT - Constants.PLAYER_WIDTH);
    	
    		
    	return new Vector2(posX, posY);
    }
    
  
    //random direccion 
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
    		Mouse mouse = new Mouse(pos,  ResourceManagerSingleton.getInstance().getAtlas().findRegion("jiniretFront"),200f,100,x,y);
    		mouse.setTypeOfMovement(new RandomMovement(mouse));
    		
            enemies.add(mouse);
            lastEnemy = TimeUtils.nanoTime();
    	}
    }
    
    public void generateDog(){
    	if(enemies.size < 20 ) {
    		
    		Vector2 pos = new Vector2(getPosDog());
    		Dog dog = new Dog(pos, ResourceManagerSingleton.getInstance().getAtlas().findRegion("wolfFront"),100f,100, player);
    		dog.setTypeOfMovement(new ChaseMovement(dog, player));
    		
            enemies.add(dog);
            lastEnemy = TimeUtils.nanoTime();
    	}
    }
    
    
    public void render() {
    	
    	debugging();
    	
    	//Dibujo de Entidades
    	player.render();
    	for(Enemy en : enemies) {
    		en.render();	
    	}
    	
    }
    
    public void debugging() {
    	//para revisar el manejo de colisiones en rectangulos
    	if (debug) {
    		BaseGameSingleton.getInstance().getSR().begin(ShapeType.Line); 
    		BaseGameSingleton.getInstance().getSR().setColor(Color.RED);
    		BaseGameSingleton.getInstance().getSR().rect(player.getRect().x, player.getRect().y, player.getRect().height, player.getRect().width);
    	
    	
	    	for(Enemy en : enemies) {	
	    		BaseGameSingleton.getInstance().getSR().setColor(Color.BLUE);
	    		BaseGameSingleton.getInstance().getSR().rect(en.getRect().x, en.getRect().y,
						en.getRect().height, en.getRect().width);
	    	}
	    	BaseGameSingleton.getInstance().getSR().end();
    	}
    }
    


	public void update(float dt) {
		
    	BaseGameSingleton.getInstance().setScore(BaseGameSingleton.getInstance().getScore() + 1); // Para que el puntaje vaya aumentando.
    	
    	player.update(dt);
    	
    	if(player.getFurball()!=null)
    		player.getFurball().update(dt);
    	
    	generateEnemies();
    	
    	// Por cada enemigo:
    	for(int i = 0 ; i < enemies.size ; i++) {
    		
    		Enemy en = enemies.get(i);
    		en.update(dt);
    		
    		player.checkCollision(en); // Chequea colisión con ese enemigo
    		if(player.getHp() <= 0) {
    			dispose();
    			BaseGameSingleton.getInstance().setScreen(new GameOverScreen());
    		}
    	}
    	
    }
    public void generateEnemies() {
    	// Genera nuevos ratones desde el último tiempo.
    	if (TimeUtils.nanoTime() - lastEnemy > Constants.SECOND/2) {
    		generateMouses();
    		generateDog();
    	}
    	// Genera nuevos perros cada 
    	
    }
    public void deleteEnemy(Enemy enemy) {
    	enemies.removeValue(enemy, false);
    }
    public Player getPlayer() {
    	return player;
    }
    
    public void dispose() {
    	ResourceManagerSingleton.getInstance().dispose();
    	enemies.clear();
    }
    

}
