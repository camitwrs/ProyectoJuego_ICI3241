import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject implements Colisionable{
	
	public Bullet(int x, int y, ID id, GameHandler handler, int mx, int my, SpriteSheet ss) {
		super(x, y, id, handler, ss);
		
		// Velocidad a la que va
		velX = (mx - x) / 10; // /10: tiempo de viaje de la bala
		velY = (my - y) / 10;
	}

	@Override
	public void update() {
		x += velX;
		y += velY;
		
		checkCollisions();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8); // Balas de 8x8
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,8,8);	
	}

	@Override
	public void checkCollisions() {
		for(int i = 0 ; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) { // Verificar si está colisionando con un bloque
				if(getBounds().intersects(tempObject.getBounds())) { 			
					// Si colisiona con un bloque, se destruye la bala
					handler.removeObject(this);
				}
			}
		}
		
	}

	
}
