import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x, y;
	protected int velX, velY;
	protected ID id;
	protected SpriteSheet ss;
	protected GameHandler handler;
	
	public GameObject(int x, int y, ID id, GameHandler handler, SpriteSheet ss) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.handler = handler;
		this.ss = ss;
	}

	public abstract void render(Graphics g);
	public abstract void update();
	public abstract Rectangle getBounds(); // Se consigue el rectángulo para las colisiones
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
