import java.awt.image.BufferedImage;

public abstract class Enemy extends GameObject implements Colisionable{
	
	protected BufferedImage tex;
	
	public Enemy(int x, int y, ID id, GameHandler handler, SpriteSheet ss) {
		super(x, y, id, handler, ss);
	}
	
}
