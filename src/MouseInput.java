import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	private GameHandler handler;
	private Camera camera;
	
	public MouseInput(GameHandler handler, Camera camera) {
		this.handler = handler;
		this.camera = camera;
	}
	
	public void mousePressed(MouseEvent e) {
		// Agregamos las coordenadas de la camara porque, sin ellas no se "traducen" las posiciones actuales del mouse.
		// Si nos vamos a través del mapa y clickeamos al medio de la pantalla, va a seguir mostrando las coordenadas anteriores y no las actuales.  
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());
		
		// Cuando clickeemos, se cree la bala en nuestro Player:
		for(int i = 0 ; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// Se agrega 16 y 24 porque o sino la bala se crearía en el centro del Player 
				handler.addObject(new Bullet(tempObject.getX()+16, tempObject.getY()+24, ID.Bullet, handler, mx, my));
			}
		}
	}
}
