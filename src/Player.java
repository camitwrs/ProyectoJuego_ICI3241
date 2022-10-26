import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// GATO
public class Player extends GameObject {
	
	Game game;
	
	public Player(int x, int y, ID id, GameHandler handler, Game game) {
		super(x, y, id, handler);
		this.game = game;
	}

	@Override
	public void update() {
		x += velX;
		y += velY;
		
		checkCollisions();
		
		// Movimiento
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
	}
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x,y,32,48);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,48);
	}

	@Override  
	public void checkCollisions() {
		for(int i = 0 ; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			// Si colisina con un bloque
			if(tempObject.getId() == ID.Block) { 
				if(getBounds().intersects(tempObject.getBounds())) { // Si hay colision (interseccion de rectangulos)				
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			// Si colisiona con un AmmoBox
			if(tempObject.getId() == ID.AmmoBox) { 
				if(getBounds().intersects(tempObject.getBounds())) { // Si hay colision (interseccion de rectangulos)				
					game.ammo += 10; // Gana 10 de municion
					handler.removeObject(tempObject);
				}
			}
		}
		
	}

}
