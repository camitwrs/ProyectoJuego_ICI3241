import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class AmmoBox extends GameObject {
	
	private BufferedImage tex;

	public AmmoBox(int x, int y, ID id, GameHandler handler, SpriteSheet ss) {
		super(x, y, id, handler, ss);
		
		tex = ss.cropImage(4, 3, 32, 32);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tex, x, y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}

	@Override
	public void update() {
		
	}

}
