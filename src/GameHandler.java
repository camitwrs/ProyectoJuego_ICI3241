import java.awt.Graphics;
import java.util.ArrayList;
/*
 * 	GameHandler "Manejador de objetos":
 *  Maneja todos los objetos del juego a la vez, así no hayestar uno por uno actualizandolos, renderizandolos, etc.
 *  Los objetos se guardan en una lista.
 */
public class GameHandler {
	
	ArrayList<GameObject> object = new ArrayList<GameObject>();
	
	private boolean up = false, down = false, right = false, left = false; // Variables de input teclado
	
	public void update() {
		for(int i = 0 ; i < object.size(); i++) {
			GameObject tempGameObject = object.get(i);
			tempGameObject.update();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0 ; i < object.size(); i++) {
			GameObject tempGameObject = object.get(i);
			tempGameObject.render(g);
		}
	}
	
	public void addObject(GameObject tempGameObject) {
		object.add(tempGameObject);
	}
	
	public void removeObject(GameObject tempGameObject) {
		object.remove(tempGameObject);
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
