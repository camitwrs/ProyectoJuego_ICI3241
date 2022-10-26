import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject{

	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	public Enemy(int x, int y, ID id, GameHandler handler) {
		super(x, y, id, handler);
	}

	@Override
	public void update() {
		x += velX;
		y += velY;
		
		choose = r.nextInt(10); // Numero random de 0 a 9
		
		checkCollisions();

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, 32, 32);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.green);
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	
	/* 	Usar este método si es que se quiere que se detecte la colisión con más distancia (Rectangulo más grande)
	 * 	public Rectangle getBoundsBig() {
	 * 	return new Rectangle(x-16,y-16,64,64);
	 * 	}
	 */	

	@Override
	public void checkCollisions() {
		for(int i = 0 ; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			// En caso de que haya colisión con un bloque
			if(tempObject.getId() == ID.Block) { 
				if(getBounds().intersects(tempObject.getBounds())) { // Si hay colision (interseccion de rectangulos)				
					// Cambiar dirección a quintuple de velocidad
					x += (velX*5) * -1;
					y += (velY*5) * -1;
					// Para que si llega a "chocar mucho" se quede quieto en vez de seguir
					velX = 0;
					velY = 0;
				}else if(choose == 0) { // Si no colisina, igualmente queremos que cambie de dirección
					// Numero random entre -4 y 4
					velX = (r.nextInt(4 - -4) + -4); 
					velY = (r.nextInt(4 - -4) + -4); 
				}
			}
			
			// En caso de que haya colisión con una bala
			if(tempObject.getId() == ID.Bullet) {
				if(getBounds().intersects(tempObject.getBounds())) {
					hp -= 50; // Con 2 disparos, muere
					handler.removeObject(tempObject); // Se elimina el enemigo
				}				
			}
		}
		
		if(hp <= 0) handler.removeObject(this);
	}

}
