import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// GATO
public class Player extends GameObject {
	
	GameHandler handler;

	public Player(int x, int y, ID id, GameHandler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void update() {
		x += velX;
		y += velY;
		
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

}
