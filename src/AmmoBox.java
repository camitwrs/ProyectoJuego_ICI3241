import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AmmoBox extends GameObject {

	public AmmoBox(int x, int y, ID id, GameHandler handler) {
		super(x, y, id, handler);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}

	@Override
	public void checkCollisions() {

		
	}

}
