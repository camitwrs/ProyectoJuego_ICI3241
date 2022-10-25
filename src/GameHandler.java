import java.awt.Graphics;
import java.util.LinkedList;

public class GameHandler {
	
	LinkedList<GameObject> GameObject = new LinkedList<GameObject>();
	
	private boolean up = false, down = false, right = false, left = false; // Variables de input teclado
	
	public void update() {
		for(int i = 0 ; i < GameObject.size(); i++) {
			GameObject tempGameObject = GameObject.get(i);
			tempGameObject.update();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0 ; i < GameObject.size(); i++) {
			GameObject tempGameObject = GameObject.get(i);
			tempGameObject.render(g);
		}
	}
	
	public void addObject(GameObject tempGameObject) {
		GameObject.add(tempGameObject);
	}
	
	public void removeObject(GameObject tempGameObject) {
		GameObject.remove(tempGameObject);
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
	
	
}
