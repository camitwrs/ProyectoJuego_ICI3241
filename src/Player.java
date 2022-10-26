import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// GATO
public class Player extends GameObject implements Movible, Colisionable{
	
	Game game;
	private BufferedImage tex;
	
	public Player(int x, int y, ID id, GameHandler handler, Game game, SpriteSheet ss) {
		super(x, y, id, handler, ss);
		this.game = game;
		
		tex = ss.cropImage(2, 1, 32, 32);
	}

	@Override
	public void update() {
		x += velX;
		y += velY;
		
		checkCollisions();
		
		moveUp();
		moveDown();
		moveLeft();
		moveRight();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tex, x, y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,48);
	}

	@Override  
	public void checkCollisions() {
		for(int i = 0 ; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			// Si colisina con un Bloque
			if(tempObject.getId() == ID.Block) { 
				if(getBounds().intersects(tempObject.getBounds())) { // Si hay colision (interseccion de rectangulos)				
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			// Si colisiona con una Caja de Municion
			if(tempObject.getId() == ID.AmmoBox) { 
				if(getBounds().intersects(tempObject.getBounds())) { // Si hay colision (interseccion de rectangulos)				
					game.ammo += 10; // Gana 10 de municion
					handler.removeObject(tempObject);
				}
			}
			
			// Si colisiona con un Raton
			if(tempObject.getId() == ID.Mouse) { 
				if(getBounds().intersects(tempObject.getBounds())) { // Si hay colision (interseccion de rectangulos)				
					game.hp--;
					if(game.hp <= 0) {
						handler.removeObject(this);
						// Pasar a pantalla de game over
					}
				}
			}
		}
		
	}

	@Override
	public void moveUp() {
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;	
	}

	@Override
	public void moveDown() {
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
	}

	@Override
	public void moveRight() {
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;		
	}

	@Override
	public void moveLeft() {
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;	
	}


}
