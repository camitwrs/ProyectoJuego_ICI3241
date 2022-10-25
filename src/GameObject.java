import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x, y;
	protected float velX = 0;
	protected float velY = 0;
	protected ID id;
	protected GameHandler handler;
	
	public GameObject(int x, int y, ID id, GameHandler handler) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.handler = handler;
	}

	public abstract void update();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); // Se consigue el rectángulo para las colisiones
	public abstract void checkCollisions();
	
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

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
