/*
 *  Transformar los Graphics g que tenemos a Graphics 2d para que renderice coordenadas
 */

public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(GameObject ob) { // Le damos coordenadas para que se "bloqueen" en nuestro personaje
		 x += ((ob.getX()- x) - 1000/2) * 0.05f; 
		 y += ((ob.getY()- y) - 563/2) * 0.05f; 
		 
		 // Para que la cámara no se salga de los bordes del mapa (ya que el mapa es más grande de lo que muestra la cámara)
		 if(x <= 0) x = 0;
		 if(x >= 1032) x = 1032;
		 if(y <= 0) y = 0;
		 if(y >= 563+48) y = 563+48;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
